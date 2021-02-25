package comp3350.umhub.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.umhub.tests.objects.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CourseTest.class,
        MajorTest.class,
        ProgramTest.class,
        StudentTest.class
})

public class AllTests {
}
