package comp3350.umhub.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.umhub.tests.business.*;
import comp3350.umhub.tests.objects.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessMajorsTest.class
})

public class AllTests {
}
