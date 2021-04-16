package comp3350.umhub.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import comp3350.umhub.business.AccessTutors;
import comp3350.umhub.business.IAccessTutors;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.TutorEntry;
import comp3350.umhub.persistence.interfaces.ITutorPersistence;
import comp3350.umhub.persistence.stubs.TutorPersistenceStub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccessTutorsTest {
    private IAccessTutors accessTutors;

    @Before
    public void setUp(){
        ITutorPersistence persistence = new TutorPersistenceStub();
        accessTutors = new AccessTutors(persistence);
    }


    @Test
    public void AccessTutorsTest(){
        Course course;
        List<TutorEntry> tutorEntryList;

        System.out.println("\nStarting AccessTutorsTest");
        course = new Course("COMP3350");
        tutorEntryList = accessTutors.getTutors(course);
        assertNotNull("List of tutors for COMP3350 should not be null", tutorEntryList);
        assertEquals("Cool", tutorEntryList.get(0).getName());
        assertEquals("Middle", tutorEntryList.get(1).getName());
        assertEquals("Tall", tutorEntryList.get(2).getName());
        assert(tutorEntryList.get(0).getRating()>= tutorEntryList.get(1).getRating());
        assert(tutorEntryList.get(0).getRating()>= tutorEntryList.get(2).getRating());
        assert(tutorEntryList.get(1).getRating()>= tutorEntryList.get(2).getRating());
        System.out.println("Finished AccessTutorsTest");
    }


}
