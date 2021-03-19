package comp3350.umhub.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


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
        UsersTest.class,
        LoginTest.class,
        AccessCoursesTest.class
})

public class AllTests {
}
