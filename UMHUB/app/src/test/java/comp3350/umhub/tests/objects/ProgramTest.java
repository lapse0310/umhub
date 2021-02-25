package comp3350.umhub.tests.objects;

import org.junit.Test;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.objects.Student;

import static org.junit.Assert.*;


public class ProgramTest {

    @Test
    public void testProgram1(){
        Program program;
        Course course;

        System.out.println("\nStarting testProgram");

        course = new Course("Software Engineering", "COMP 3350", "Course to get you trained in industry standards of coding projects", "Computer Science");
        Course[] courseArr = new Course[1];
        courseArr[0] = course;

        program = new Program("Bachelor of Science Major - Computer Science", courseArr);

        assertNotNull(program);
        assertTrue("Bachelor of Science Major - Computer Science".equals(program.getName()));
        assertTrue(courseArr.equals(program.getCourses()));

        System.out.println("Finished testProgram");
    }
}
