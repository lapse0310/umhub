package comp3350.umhub.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.ICoursePersistence;

public class AccessCourses implements IAccessCourses{
    private final List<Course> courses;
    private ICoursePersistence coursePersistence;


    public AccessCourses( ){
        coursePersistence = Services.getCoursePersistence();
        courses = coursePersistence.getCoursesSequential();

    }

    public AccessCourses( final ICoursePersistence persistence) {
        coursePersistence = persistence;
        courses = coursePersistence.getCoursesSequential();
    }

/*    @Override
    public List<Course> getCoursesByProgram(Program programSelected) {
        List<Course> coursesUnderProgram = new ArrayList<>();
        for(int i=0; i<courses.size();i++) {
            List<Program> programList = courses.get(i).getPrograms();
            boolean found = false;
            int count = 0;
            while(programList != null && !found && count < programList.size()){
                if(programSelected.equals(programList.get(count))){
                    coursesUnderProgram.add(courses.get(i));
                    found = true;
                }
                count++;
            }

        }
        return coursesUnderProgram;
    }

    @Override
    public List<Course> getCoursesByYearProgram(Program program, int year) {
        List<Course> coursesUnderProgram = getCoursesByProgram(program);
        List<Course> yearCourses = new ArrayList<>();

        for(int i=0; i<coursesUnderProgram.size();i++){
            int courseYear = coursesUnderProgram.get(i).getYear();
            if(courseYear == year){
                yearCourses.add(coursesUnderProgram.get(i));
            }
        }

        return yearCourses;
    }

    @Override
    public List<Course> getCoursesByMajor(Major major) {
        List<Course> coursesUnderMajor = new ArrayList<>();
        for(int i=0; i<courses.size();i++){
            if (major.getName().equals(courses.get(i).getMajor())){
                coursesUnderMajor.add(courses.get(i));
            }
        }
        return coursesUnderMajor;
    }


    @Override
    public List<Course> getCoursesByYearMajor(Major major, int year) {
        List<Course> coursesUnderMajor = getCoursesByMajor(major);
        List<Course> yearCourses = new ArrayList<>();

        for(int i=0; i<coursesUnderMajor.size();i++){
            int courseYear = coursesUnderMajor.get(i).getYear();
            if(courseYear == year){
                yearCourses.add(coursesUnderMajor.get(i));
            }
        }

        return yearCourses;
    }*/

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public List<Course> getCoursesByProgram(Program program) {
        return coursePersistence.getCoursesByProgram(program.getName());
    }

    @Override
    public List<Course> getCoursesByYearProgram(Program program, int year) {
        return coursePersistence.getCoursesByYearProgram(program.getName(),year);
    }

    @Override
    public List<Course> getCoursesByMajor(Major major) {
        return coursePersistence.getCoursesByMajor(major.getName());
    }

    @Override
    public List<Course> getCoursesByYearMajor(Major major, int year) {
        return coursePersistence.getCoursesByYearMajor(major.getName(),year);
    }

}
