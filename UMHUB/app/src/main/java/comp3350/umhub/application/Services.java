package comp3350.umhub.application;

import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.MajorPersistence;
import comp3350.umhub.persistence.ProgramPersistence;
import comp3350.umhub.persistence.stubs.MajorPersistenceStub;
import comp3350.umhub.persistence.stubs.ProgramPersistenceStub;

public class Services {
    private static MajorPersistence majorPersistence = null;
    private static ProgramPersistence programPersistence = null;

    public static synchronized MajorPersistence getMajorPersistence(){
        if(majorPersistence==null){
            majorPersistence = new MajorPersistenceStub();
        }
        return majorPersistence;
    }

    public static synchronized ProgramPersistence getProgramPersistence(){
        if(programPersistence==null){
            programPersistence = new ProgramPersistenceStub();
        }
        return programPersistence;
    }
}
