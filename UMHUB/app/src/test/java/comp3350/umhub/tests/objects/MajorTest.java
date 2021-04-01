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
        Major major, major1;



        System.out.println("\nStarting testMajor");

        major = new Major("Computer Science");

        assertNotNull(major);
        assertTrue("Computer Science".equals(major.getName()));

        major1 = new Major("Not computer science");
        assert(!major.equals(major1));
        major1 = new Major("Computer Science");
        assert(major.equals(major1));

        System.out.println("Finished testMajor");
    }
}
