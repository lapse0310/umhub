//package comp3350.umhub.tests.business;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import comp3350.umhub.application.Services;
//import comp3350.umhub.business.AccessPrograms;
//import comp3350.umhub.business.IAccessPrograms;
//import comp3350.umhub.objects.Program;
//
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//public class AccessProgramsTest {
//
//    private IAccessPrograms accessPrograms;
//
//    @Before
//    public void setUp() {
//        accessPrograms = new AccessPrograms();
//    }
//
//    @Test
//    public void test1()
//    {
//        final Program program;
//
//        System.out.println("\nStarting test AccessPrograms");
//        program = accessPrograms.getSequential();
//        assertNotNull("first sequential program should not be null", program);
//        assertTrue("Computer Science - Math Joint Honors".equals(program.getName()));
//        System.out.println("Finished test AccessPrograms");
//    }
//
//
//}
