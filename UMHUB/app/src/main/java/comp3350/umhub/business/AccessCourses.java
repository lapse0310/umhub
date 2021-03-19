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

    public AccessCourses(){
        ICoursePersistence coursePersistence = Services.getCoursePersistence();
        courses = coursePersistence.getCourseSequential();

    }

    @Override
    public List<Course> getCourses(Program programSelected) {
        List<Course> coursesUnderProgram = new ArrayList<>();
        for(int i=0; i<courses.size();i++) {
            List<Program> programList = courses.get(i).getPrograms();
            boolean found = false;
            int count = 0;
            while(!found && count < programList.size()){
                if(Equals.isEqualProgram(programSelected,programList.get(count))){
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
        List<Course> coursesUnderProgram = getCourses(program);
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
            if(Equals.isEqualMajor(major,courses.get(i).getMajor())){
                coursesUnderMajor.add(courses.get(i));
            }
        }
        return coursesUnderMajor;
    }

    @Override
    public List<Course> getCoursesByYearMajor(Major major, int year) {
        List<Course> coursesUnderProgram = getCoursesByMajor(major);
        List<Course> yearCourses = new ArrayList<>();

        for(int i=0; i<coursesUnderProgram.size();i++){
            int courseYear = coursesUnderProgram.get(i).getYear();
            if(courseYear == year){
                yearCourses.add(coursesUnderProgram.get(i));
            }
        }

        return yearCourses;
    }

}
