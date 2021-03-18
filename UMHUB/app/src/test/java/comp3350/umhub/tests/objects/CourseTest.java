package comp3350.umhub.tests.objects;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;

import static org.junit.Assert.*;

public class CourseTest {

    @Test
    public void testCourse1(){
        Course course;
        Major major;
        Program program1, program2;
        List<Program> programList;

        System.out.println("\nStarting testCourse");
        major = new Major("Computer Science");
        programList = new ArrayList<>();
        program1 = new Program("Bachelor of Science - Computer Science",major);
        program2 = new Program("Bachelor of Computer Science Honors",major);
        programList.add(program1);
        programList.add(program2);

        course = new Course("Software Engineering", "COMP 3350", "Course to get you trained in industry standards of coding projects",3, programList);
        assertNotNull(course);
        assertTrue("Software Engineering".equals(course.getName()));
        assertTrue("COMP 3350".equals(course.getId()));
        assertTrue("Course to get you trained in industry standards of coding projects".equals(course.getDescription()));
        assertEquals(3,course.getYear());
        assertTrue(programList.equals(course.getPrograms()));
        assertTrue(course.getPrograms().contains(program1));
        assertTrue(course.getPrograms().contains(program2));

        System.out.println("Finished testCourse");
    }
}
