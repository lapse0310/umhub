package comp3350.umhub.tests.business;

import org.junit.Before;

import java.io.File;
import java.io.IOException;

import comp3350.umhub.business.AccessMajors;
import comp3350.umhub.persistence.IMajorPersistence;
import comp3350.umhub.persistence.hsqldb.MajorPersistenceHSQLDB;

public class AccessMajorsIT {
    private AccessMajors accessMajors;
    private File tempDB;


    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final IMajorPersistence persistence = new MajorPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessMajors = new AccessMajors(persistence);
    }


}
