package comp3350.umhub.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.business.old.AccessPrograms;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.old.IProgramPersistence;
import comp3350.umhub.persistence.hsqldb.ProgramPersistenceHSQLDB;
import comp3350.umhub.tests.utils.TestUtils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessProgramsIT {
    private AccessPrograms accessPrograms;
    private File tempDB;
    
    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final IProgramPersistence persistence = new ProgramPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessPrograms = new AccessPrograms(persistence);
        //this.accessPrograms = (AccessPrograms) Services.getAccessPrograms();
    }

    @Test
    public void getProgramsTest(){
        Major majorSelected = new Major("Accounting");
        System.out.println("\nStarting Access Programs integration test - getPrograms");
        List<Program> programs = new ArrayList<>();
        programs = accessPrograms.getPrograms(majorSelected);

        assertNotNull("Majors list should not be null", programs);
        assert(programs.size()!=0);

        assertTrue("BComm Honors Accounting".equals(programs.get(0).getName()));

        System.out.println("Finished Access Programs integration test - getPrograms");

    }
}
