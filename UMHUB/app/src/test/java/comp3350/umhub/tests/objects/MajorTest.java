package comp3350.umhub.tests.objects;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;

import static org.junit.Assert.*;

public class MajorTest {

    @Test
    public void testMajor1(){
        Major major;
        Course course1;
        Course course2;
        Program program;


        System.out.println("\nStarting testMajor");

        course1 = new Course("Software Engineering", "COMP 3350", "Course to get you trained in industry standards of coding projects", "Computer Science");
        course2 = new Course("Databases:Concepts and Usage", "COMP 3380", "Course to get you started in databases", "Computer Science");
        program = new Program("Bachelor of Science Major - Computer Science");

        List<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);

        List<Program> programList = new ArrayList<>();
        programList.add(program);


        major = new Major("Computer Science", programList, courseList);

        assertNotNull(major);
        assertTrue("Computer Science".equals(major.getName()));
        assertTrue(programList.equals(major.getPrograms()));
        assertTrue(courseList.equals(major.getCourses()));

        System.out.println("Finished testMajor");
    }
}
