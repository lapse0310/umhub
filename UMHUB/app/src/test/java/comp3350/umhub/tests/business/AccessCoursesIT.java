package comp3350.umhub.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.business.AccessCourses;
import comp3350.umhub.business.AccessPrograms;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.ICoursePersistence;
import comp3350.umhub.persistence.IProgramPersistence;
import comp3350.umhub.persistence.hsqldb.CoursePersistenceHSQLDB;
import comp3350.umhub.persistence.hsqldb.ProgramPersistenceHSQLDB;
import comp3350.umhub.tests.utils.TestUtils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessCoursesIT {

    private AccessCourses accessCourses;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final ICoursePersistence persistence = new CoursePersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessCourses = new AccessCourses(persistence);
    }

    @Test
    public void getCoursesByProgramTest(){
        System.out.println("\n Starting Access Course integration test - getCoursesByProgramTest");

        Program programSelected = new Program("Computer Science Honors, Coop");

        List<Course> courses = new ArrayList<>();
        courses = accessCourses.getCourses(programSelected);

        assertNotNull("Courses list should not be null", courses);
        assert(courses.size()!=0);
        assertTrue("COMP 3350".equals(courses.get(0).getId()));

        System.out.println("Finished Access Course integration test - getCoursesByProgramTest");

    }


    @Test
    public void getCoursesByMajorTest(){
        System.out.println("\n Starting Access Course integration test - getCoursesByMajorTest");

        Major major = new Major("Computer Science");

        List<Course> courses = new ArrayList<>();
        courses = accessCourses.getCoursesByMajor(major);

        assertNotNull("Courses list should not be null", courses);
        assert(courses.size()!=0);
        assertTrue("COMP 3350".equals(courses.get(0).getId()));

        System.out.println("Finished Access Course integration test - getCoursesByMajorTest");

    }
}
