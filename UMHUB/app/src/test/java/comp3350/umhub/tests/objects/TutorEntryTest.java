package comp3350.umhub.tests.objects;

import org.junit.Test;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.TutorEntry;

import static org.junit.Assert.assertEquals;

public class TutorEntryTest {

    @Test
    public void testTutor(){
        TutorEntry tutorEntry1, tutorEntry2;
        Course course1, course2;

        System.out.println("\nStarting testTutor");

        course1 = new Course("COMP 3350");
        tutorEntry1 = new TutorEntry("Naruto","nuzumaki@myumanitoba.ca",course1,"Professor",10);
        assertEquals(tutorEntry1.getName(),"Naruto");
        assertEquals(tutorEntry1.getEmail(),"nuzumaki@myumanitoba.ca");
        assertEquals(tutorEntry1.getCourse(),course1);
        assertEquals(tutorEntry1.getType(),"Professor");
        assert(tutorEntry1.getRating()==10);
        assertEquals(tutorEntry1.displayName(),"Professor Naruto");
        assert(tutorEntry1.displaySub().contains("nuzumaki@myumanitoba.ca"));
        assert(tutorEntry1.displaySub().contains("10"));

        tutorEntry1.setRating(5);
        assert(tutorEntry1.getRating()!=10);
        assert(tutorEntry1.getRating()<10);


        System.out.println("Finished testTutor");

    }
}
