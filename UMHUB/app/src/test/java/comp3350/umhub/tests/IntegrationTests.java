package comp3350.umhub.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.umhub.tests.business.AccessMajorsIT;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessMajorsIT.class
})
public class IntegrationTests {
}
