package comp3350.umhub.tests.objects;

import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Student;

public class StudentTest {

    @Test
    public void testStudent1(){
        Student student;

        System.out.println("\nStarting testStudent");

        Major major = new Major("Computer Science");
        student = new Student("John Doe", "331122", major, "johndoe@cs.ca");

        assertNotNull(student);
        assertTrue("John Doe".equals(student.getName()));
        assertTrue("331122".equals(student.getId()));
        assertTrue(major.equals(student.getMajor()));
        assertTrue("johndoe@cs.ca".equals(student.getEmail()));

        System.out.println("Finished testStudent");
    }
}

