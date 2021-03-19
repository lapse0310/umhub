package comp3350.umhub.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.ICoursePersistence;

public class CoursePersistenceStub implements ICoursePersistence {
    List<Course> courses;

    public CoursePersistenceStub(){
        this.courses = new ArrayList<>();
        Program program1 = new Program("Computer Science Honors, Coop");
        Program program2 = new Program("Computer Science General");
        Program program3 = new Program("Math is fun program");
        Program program4 = new Program("Computer Science - Math Joint Honors");
        List<Program> course1List = new ArrayList<>();
        List<Program> course2List = new ArrayList<>();
        course1List.add(program1);
        course1List.add(program2);
        course2List.add(program1);
        course2List.add(program2);
        course2List.add(program3);
        course2List.add(program4);
        courses.add(new Course("Software Engineering","COMP 3350","Random description","Year 3",course1List));
        courses.add(new Course("Operating Systems","COMP 3430","Random description","Year 3",course1List));
        courses.add(new Course("Calculus 1","MATH 1500","Random description","Year 1",course2List));
        courses.add(new Course("Calculus 2","MATH 1700","Random description","Year 1",course2List));


    }
    @Override
    public List<Course> getCourseSequential() {
        return courses;
    }

    @Override
    public List<Course> getCourseRandom(Course currentCourse) {
        return null;
    }
}
