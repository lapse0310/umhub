package comp3350.umhub.tests.business;

import comp3350.umhub.business.Equals;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;

import org.junit.Test;
import static org.junit.Assert.*;


public class EqualsTest {

    @Test
    public void testEquals(){
        Major major1 = new Major("Test major");
        Major major2 = new Major("Test major");

        Program program1 = new Program("Test major",major1);
        Program program2 = new Program("Test major",major2);


        assert(Equals.isEqualMajor(major1,major2));
        assert(Equals.isEqualProgram(program1,program2));

    }

    @Test
    public void testNotEquals(){
        Major major1 = new Major("Test major");
        Major major2 = new Major("Test wrong major");

        Program program1 = new Program("Test major",major1);
        Program program2 = new Program("Test major",major2);


        assert(!Equals.isEqualMajor(major1,major2));
        assert(!Equals.isEqualProgram(program1,program2));
    }
}
