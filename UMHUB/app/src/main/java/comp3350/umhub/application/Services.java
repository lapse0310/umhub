package comp3350.umhub.application;

import comp3350.umhub.business.AccessPrograms;
import comp3350.umhub.business.IAccessPrograms;
import comp3350.umhub.persistence.IMajorPersistence;
import comp3350.umhub.persistence.IProgramPersistence;
import comp3350.umhub.persistence.stubs.MajorPersistenceStub;

import comp3350.umhub.business.IAccessMajors;
import comp3350.umhub.business.AccessMajors;
import comp3350.umhub.persistence.stubs.ProgramPersistenceStub;

//used to provide an implementation of the interfaces used.
public class Services {
    private static IMajorPersistence majorPersistence = null;
    private static IAccessMajors accessMajors = null;
    private static IProgramPersistence programPersistence = null;
    private static IAccessPrograms accessPrograms = null;

    public static synchronized IMajorPersistence getMajorPersistence(){
        if(majorPersistence==null){
            majorPersistence = new MajorPersistenceStub();
        }
        return majorPersistence;
    }

    public static synchronized IAccessMajors getAccessMajors(){
        if(accessMajors==null){
            accessMajors = new AccessMajors();
        }
        return accessMajors;
    }

    public static synchronized IProgramPersistence getProgramPersistence(){
        if(programPersistence==null){
            programPersistence = new ProgramPersistenceStub();
        }
        return programPersistence;
    }

    public static synchronized IAccessPrograms getAccessPrograms(){
        if(accessPrograms==null){
            accessPrograms = new AccessPrograms();
        }
        return accessPrograms;
    }



}
