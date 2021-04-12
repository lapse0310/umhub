package comp3350.umhub.tests.business;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import comp3350.umhub.business.old.AccessCourses;
import comp3350.umhub.business.old.IAccessCourses;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.old.ICoursePersistence;
import comp3350.umhub.persistence.stubs.CoursePersistenceStub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class AccessCoursesTest {
    private IAccessCourses accessCourses;

    @Before
    public void setUp(){
        ICoursePersistence persistence = new CoursePersistenceStub();
        accessCourses = new AccessCourses(persistence);
    }

    @Test
    public void testGetAllCoursesByProgram(){

        System.out.println("\nStarting test AccessPrograms - get all courses by program");

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

        System.out.println("Finished test AccessCourses - get all courses by program");
    }

    @Test
    public void testGetYearCoursesProgram(){
        System.out.println("Starting test AccessCourses - get courses by year and program");
        Program program = new Program("Computer Science General");
        List<Course> courses = accessCourses.getCoursesByYearProgram(program,1);
        for(int i=0; i<courses.size(); i++){
            assertEquals(1,courses.get(i).getYear());
        }

        courses = accessCourses.getCoursesByYearProgram(program,2);
        for(int i=0; i<courses.size(); i++){
            assertEquals(2,courses.get(i).getYear());
        }

        courses = accessCourses.getCoursesByYearProgram(program,3);
        for(int i=0; i<courses.size(); i++){
            assertEquals(3,courses.get(i).getYear());
        }

        courses = accessCourses.getCoursesByYearProgram(program,4);
        for(int i=0; i<courses.size(); i++){
            assertEquals(4,courses.get(i).getYear());
        }


        System.out.println("Finished test AccessCourses - get courses by year and program");
    }

    @Test
    public void testGetAllCoursesByMajor(){
        System.out.println("\nStarting test AccessCourses - get all courses by major");
        Major major = new Major("Computer Science");
        List<Course> courses = accessCourses.getCoursesByMajor(major);
        for(int i=0; i<courses.size(); i++){
            assertEquals(major.getName(),courses.get(i).getMajor().getName());
        }
        System.out.println("Finished test AccessCourses - get all courses by major");
    }

    @Test
    public void testGetCoursesByYearMajor(){
        System.out.println("\nStarting test AccessCourses - get courses by year and program");
        Major major = new Major("Mathematics");
        List<Course> courses = accessCourses.getCoursesByYearMajor(major,1);
        for(int i=0; i<courses.size();i++){
            assertEquals(1,courses.get(i).getYear());
        }

        courses = accessCourses.getCoursesByYearMajor(major,2);
        for(int i=0; i<courses.size();i++){
            assertEquals(2,courses.get(i).getYear());
        }

        courses = accessCourses.getCoursesByYearMajor(major,3);
        for(int i=0; i<courses.size();i++){
            assertEquals(3,courses.get(i).getYear());
        }

        courses = accessCourses.getCoursesByYearMajor(major,4);
        for(int i=0; i<courses.size();i++){
            assertEquals(4,courses.get(i).getYear());
        }
        System.out.println("Finished test AccessCourses - get courses by year and program");
    }

}
