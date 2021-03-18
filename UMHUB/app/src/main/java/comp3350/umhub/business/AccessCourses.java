package comp3350.umhub.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Course;
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
    public List<Course> getYear1Courses(Program program) {
        List<Course> coursesUnderProgram = getCourses(program);
        List<Course> year1Courses = new ArrayList<>();

        for(int i=0; i<coursesUnderProgram.size();i++){
            int year = coursesUnderProgram.get(i).getYear();
            if(year == 1){
                year1Courses.add(coursesUnderProgram.get(i));
            }
        }

        return year1Courses;
    }



    @Override
    public List<Course> getYear2Courses(Program program) {
        List<Course> coursesUnderProgram = getCourses(program);
        List<Course> year2Courses = new ArrayList<>();

        for(int i=0; i<coursesUnderProgram.size();i++){
            int year = coursesUnderProgram.get(i).getYear();
            if(year == 2){
                year2Courses.add(coursesUnderProgram.get(i));
            }
        }

        return year2Courses;
    }

    @Override
    public List<Course> getYear3Courses(Program program) {
        List<Course> coursesUnderProgram = getCourses(program);
        List<Course> year3Courses = new ArrayList<>();

        for(int i=0; i<coursesUnderProgram.size();i++){
            int year = coursesUnderProgram.get(i).getYear();
            if(year == 3){
                year3Courses.add(coursesUnderProgram.get(i));
            }
        }

        return year3Courses;
    }

    @Override
    public List<Course> getYear4Courses(Program program) {
        List<Course> coursesUnderProgram = getCourses(program);
        List<Course> year4Courses = new ArrayList<>();

        for(int i=0; i<coursesUnderProgram.size();i++){
            int year = coursesUnderProgram.get(i).getYear();
            if(year == 4){
                year4Courses.add(coursesUnderProgram.get(i));
            }
        }


        return year4Courses;
    }
}
