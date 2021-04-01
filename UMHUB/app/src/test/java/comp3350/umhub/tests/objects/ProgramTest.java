package comp3350.umhub.tests.objects;

import org.junit.Test;

import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;

import static org.junit.Assert.*;


public class ProgramTest {

    @Test
    public void testProgram1(){
        Program program, program1;
        Major major;

        System.out.println("\nStarting testProgram");
        major = new Major("Computer Science");
        program = new Program("Bachelor of Science Major - Computer Science", major);

        assertNotNull(program);
        assertTrue("Bachelor of Science Major - Computer Science".equals(program.getName()));
        assertTrue(program.getMajor().equals(major));

        program1 = new Program("Different program - Computer Science", major);
        assert(!program.equals(program1));
        program1 = new Program("Bachelor of Science Major - Computer Science", major);
        assert(program.equals(program1));

        System.out.println("Finished testProgram");
    }
}
