package comp3350.umhub.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.business.AccessMajors;
import comp3350.umhub.objects.Major;
import comp3350.umhub.persistence.MajorPersistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/*import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;*/


public class AccessMajorsTest {
/*
    private AccessMajors accessMajors;
    private MajorPersistence majorPersistence;

    @Before
    public void setUp() {
        majorPersistence = mock(MajorPersistence.class);
        accessMajors = new AccessMajors();
    }

    @Test
    public void test1()
    {
        final Major major;

        System.out.println("\nStarting test AccessMajors");
        final List<Major> majors = new ArrayList<>();
        majors.add(new Major("Engineering"));
        when(majorPersistence.getMajorsSequential()).thenReturn(majors);

        major = accessMajors.getSequential();
        assertNotNull("first sequential course should not be null", major);
        assertTrue("Engineering".equals(major.getCourseID()));

        verify(majorPersistence).getCourseSequential();

        System.out.println("Finished test AccessCourses");
    }

*/

}
