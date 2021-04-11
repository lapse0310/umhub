package comp3350.umhub.tests.objects;

import org.junit.Test;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Tutor;

import static org.junit.Assert.assertEquals;

public class TutorTest {

    @Test
    public void testTutor(){
        Tutor tutor1, tutor2;
        Course course1, course2;

        System.out.println("\nStarting testTutor");

        course1 = new Course("COMP 3350");
        tutor1 = new Tutor("Naruto","nuzumaki@myumanitoba.ca",course1,"Professor",10);
        assertEquals(tutor1.getName(),"Naruto");
        assertEquals(tutor1.getEmail(),"nuzumaki@myumanitoba.ca");
        assertEquals(tutor1.getCourse(),course1);
        assertEquals(tutor1.getType(),"Professor");
        assert(tutor1.getRating()==10);
        assertEquals(tutor1.displayName(),"Professor Naruto");
        assert(tutor1.displaySub().contains("nuzumaki@myumanitoba.ca"));
        assert(tutor1.displaySub().contains("10"));

        tutor1.setRating(5);
        assert(tutor1.getRating()!=10);
        assert(tutor1.getRating()<10);


        System.out.println("Finished testTutor");

    }
}
