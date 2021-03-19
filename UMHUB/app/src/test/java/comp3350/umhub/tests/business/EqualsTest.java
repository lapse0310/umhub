package comp3350.umhub.tests.business;

import comp3350.umhub.business.Equals;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;

import org.junit.Test;
import static org.junit.Assert.*;


public class EqualsTest {

    @Test
    public void testIsEqualMajor(){
        System.out.println("\nStarting test testIsEqualMajor");
        Major major1 = new Major("Test major");
        Major major2 = new Major("Test major");
        assertTrue(Equals.isEqualMajor(major1,major2));
        System.out.println("Finished test testIsEqualMajor");
    }

    @Test
    public void testIsNotEqualMajor(){
        System.out.println("\nStarting test testIsNotEqualMajor");
        Major major1 = new Major("Test major");
        Major major2 = new Major("Test wrong major");
        assertFalse(Equals.isEqualMajor(major1,major2));
        System.out.println("Finished test testIsNotEqualMajor");

    }

    @Test
    public void testIsEqualProgram(){
        System.out.println("\nStarting test testIsEqualProgram");
        Major major1 = new Major("Test major");
        Major major2 = new Major("Test major");
        Program program1 = new Program("Test program",major1);
        Program program2 = new Program("Test program",major2);
        assertTrue(Equals.isEqualProgram(program1,program2));
        System.out.println("Finished test testIsEqualProgram");
    }

    @Test
    public void testIsNotEqualProgram(){
        System.out.println("\nStarting test testIsNotEqualProgram");
        Program program1 = new Program("Test program");
        Program program2 = new Program("Test wrong program");
        Program sameProgram = new Program("Test program");
        assertFalse(Equals.isEqualProgram(program1,program2));
        assertTrue(Equals.isEqualProgram(program1, sameProgram));
        System.out.println("Finished test testIsNotEqualProgram");

    }


}
