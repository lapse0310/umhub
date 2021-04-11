package comp3350.umhub.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import comp3350.umhub.business.AccessTutors;
import comp3350.umhub.business.IAccessTutors;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Tutor;
import comp3350.umhub.persistence.ITutorPersistence;
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
        List<Tutor> tutorList;

        System.out.println("\nStarting AccessTutorsTest");
        course = new Course("COMP 3350");
        tutorList = accessTutors.getTutors(course);
        assertNotNull("List of tutors for COMP 3350 should not be null",tutorList);
        assertEquals("Cool",tutorList.get(0).getName());
        assertEquals("Middle",tutorList.get(1).getName());
        assertEquals("Tall",tutorList.get(2).getName());
        assert(tutorList.get(0).getRating()>=tutorList.get(1).getRating());
        assert(tutorList.get(0).getRating()>=tutorList.get(2).getRating());
        assert(tutorList.get(1).getRating()>=tutorList.get(2).getRating());
        System.out.println("Finished AccessTutorsTest");
    }


}
