package comp3350.umhub.tests.objects;

import org.junit.Test;

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

        Course[] courseArr = new Course[2];
        courseArr[0] = course1;
        courseArr[1] = course2;

        Program[] progArr = new Program[1];
        progArr[0] = program;


        major = new Major("Computer Science", progArr, courseArr);

        assertNotNull(major);
        assertTrue("Computer Science".equals(major.getName()));
        assertTrue(progArr.equals(major.getPrograms()));
        assertTrue(courseArr.equals(major.getCourses()));

        System.out.println("Finished testMajor");
    }
}
