package comp3350.umhub.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.ICoursePersistence;

public class CoursePersistenceStub implements ICoursePersistence {
    List<Course> courses;

    public CoursePersistenceStub(){
        this.courses = new ArrayList<>();
        Major major1 = new Major("Computer Science");
        Major major2 = new Major("Mathematics");
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
        courses.add(new Course("Software Engineering","COMP 3350","Random description",3,major1,course1List));
        courses.add(new Course("Operating Systems","COMP 3430","Random description",3,major1,course1List));
        courses.add(new Course("Calculus 1","MATH 1500","Random description",1,major2,course2List));
        courses.add(new Course("Calculus 2","MATH 1700","Random description",1,major2,course2List));
        courses.add(new Course("Object Oriented Programming","COMP 2150","Random description",2,major1,course1List));
        courses.add(new Course("Programming Practices","COMP 2160","Random description",2,major1,course1List));
        courses.add(new Course("4000 Level Course","COMP 4170","Random description",4,major1,course1List));
        courses.add(new Course("Calculus 4","MATH 4700","Random description",4,major2,course2List));


    }
    @Override
    public List<Course> getCourseSequential() {
        return courses;
    }
}
