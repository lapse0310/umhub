//checks if two majors or programs are equal
package comp3350.umhub.business;

import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;

public class Equals{
    public static boolean isEqualMajor(Major major1, Major major2) {
        return major1.getName().equals(major2.getName());
    }
    public static boolean isEqualProgram(Program program1, Program program2) {
        return program1.getName().equals(program2.getName());
    }
}
