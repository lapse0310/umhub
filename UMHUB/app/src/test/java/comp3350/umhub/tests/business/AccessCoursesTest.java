package comp3350.umhub.tests.business;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import comp3350.umhub.business.AccessCourses;
import comp3350.umhub.business.IAccessCourses;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Program;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class AccessCoursesTest {
    private IAccessCourses accessCourses;

    @Before
    public void setUp(){
        accessCourses = new AccessCourses();
    }

    @Test
    public void testGetAllCourses(){

        System.out.println("\nStarting test AccessPrograms - get all courses");

        Course course;

        Program program = new Program("Invalid program");
        List<Course> courses = accessCourses.getCourses(program);
        assert(courses.size()==0);

        program = new Program("Computer Science General");
        courses  = accessCourses.getCourses(program);
        assertNotNull("List of courses for Computer Science General program must not be null",courses);
        assert(courses.size()>0);
        course = courses.get(0);
        assertEquals("COMP 3350",course.getId());
        List<Program> programList = course.getPrograms();
        boolean found = false; //to find if the course is under one of the programs
        int count = 0;
        while(!found || count<programList.size()){
            if(programList.get(count).getName().equals(program.getName())){
                found = true;
            }
            count++;
        }

        assert(found);

        System.out.println("Finished test AccessCourses - get all courses");
    }

    @Test
    public void testGetYear1Courses(){
        System.out.println("Starting test AccessCourses - year 1 courses");
        Program program = new Program("Computer Science General");
        List<Course> courses = accessCourses.getYear1Courses(program);
        for(int i=0; i<courses.size(); i++){
            assertEquals(1,courses.get(i).getYear());
        }

        System.out.println("Finished test AccessCourses - year 1 courses");
    }
    @Test
    public void testGetYear2Courses(){
        System.out.println("Starting test AccessCourses - year 2 courses");
        Program program = new Program("Computer Science General");
        List<Course> courses = accessCourses.getYear2Courses(program);
        for(int i=0; i<courses.size(); i++){
            assertEquals(2,courses.get(i).getYear());
        }

        System.out.println("Finished test AccessCourses - year 2 courses");
    }
    @Test
    public void testGetYear3Courses(){
        System.out.println("Starting test AccessCourses - year 3 courses");
        Program program = new Program("Computer Science General");
        List<Course> courses = accessCourses.getYear3Courses(program);
        for(int i=0; i<courses.size(); i++){
            assertEquals(3,courses.get(i).getYear());
        }

        System.out.println("Finished test AccessCourses - year 3 courses");
    }
    @Test
    public void testGetYear4Courses(){
        System.out.println("Starting test AccessCourses - year 4 courses");
        Program program = new Program("Computer Science General");
        List<Course> courses = accessCourses.getYear4Courses(program);
        for(int i=0; i<courses.size(); i++){
            assertEquals(4,courses.get(i).getYear());
        }

        System.out.println("Finished test AccessCourses - year 4 courses");
    }
}
