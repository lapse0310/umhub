package comp3350.umhub.tests.objects;

import org.junit.Test;

import comp3350.umhub.objects.Course;

import static org.junit.Assert.*;

public class CourseTest {

    @Test
    public void testCourse1(){
        Course course;

        System.out.println("\nStarting testCourse");

        course = new Course("Software Engineering", "COMP 3350", "Course to get you trained in industry standards of coding projects", "Computer Science");
        assertNotNull(course);
        assertTrue("Software Engineering".equals(course.getName()));
        assertTrue("COMP 3350".equals(course.getId()));
        assertTrue("Course to get you trained in industry standards of coding projects".equals(course.getDescription()));
        assertTrue("Computer Science".equals(course.getMajor()));

        System.out.println("Finished testCourse");
    }
}
