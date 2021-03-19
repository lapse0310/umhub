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



        System.out.println("\nStarting testMajor");

        major = new Major("Computer Science");

        assertNotNull(major);
        assertTrue("Computer Science".equals(major.getName()));

        System.out.println("Finished testMajor");
    }
}
