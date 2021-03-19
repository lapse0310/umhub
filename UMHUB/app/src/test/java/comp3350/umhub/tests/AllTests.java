package comp3350.umhub.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


import comp3350.umhub.business.AccessCourses;
import comp3350.umhub.tests.objects.*;
import comp3350.umhub.tests.business.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CourseTest.class,
        MajorTest.class,
        ProgramTest.class,
        StudentTest.class,
        AccessMajorsTest.class,
        AccessProgramsTest.class,
        EqualsTest.class,
        AccessCoursesTest.class
})

public class AllTests {
}
