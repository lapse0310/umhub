package comp3350.umhub.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


import comp3350.umhub.business.AccessMajors;
import comp3350.umhub.objects.Major;
import comp3350.umhub.persistence.interfaces.IMajorPersistence;
import comp3350.umhub.persistence.sqlite.MajorSQLDB;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessMajorsIT {
    private AccessMajors accessMajors;


    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final IMajorPersistence persistence = new MajorSQLDB();
        this.accessMajors = new AccessMajors(persistence);
    }

    @Test
    public void getMajorsTest(){

        System.out.println("\n Starting Access Majors integration test - getMajors");
        List<Major> majors  =accessMajors.getAllMajors();

        assertNotNull("Majors list should not be null", majors);
        assert(majors.size()!=0);
        assertTrue("Accounting".equals(majors.get(0).getName()));

        System.out.println("Finished Access Majors integration test - getMajors");

    }


}
