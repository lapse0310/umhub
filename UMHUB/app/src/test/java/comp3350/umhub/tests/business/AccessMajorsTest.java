//package comp3350.umhub.tests.business;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import comp3350.umhub.application.Services;
//import comp3350.umhub.business.AccessMajors;
//import comp3350.umhub.business.IAccessMajors;
//import comp3350.umhub.objects.Major;
//import comp3350.umhub.objects.Program;
//import comp3350.umhub.persistence.IMajorPersistence;
//
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//public class AccessMajorsTest {
//    private IAccessMajors accessMajors;
//
//    @Before
//    public void setUp() {
//        accessMajors = new AccessMajors();
//    }
//
//    @Test
//    public void test1()
//    {
//        final Major major;
//        System.out.println("\nStarting test AccessMajors");
//        List<Major> majors = accessMajors.getMajors();
//        assertNotNull("first sequential major should not be null", major);
//        assertTrue("Accounting".equals(major.getName()));
//        System.out.println("Finished test AccessMajors");
//    }
//
//
//
//
//}
