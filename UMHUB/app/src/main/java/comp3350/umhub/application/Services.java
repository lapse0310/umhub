package comp3350.umhub.application;

import comp3350.umhub.persistence.MajorPersistence;
import comp3350.umhub.persistence.stubs.MajorPersistenceStub;

public class Services {
    private static MajorPersistence majorPersistence = null;

    public static synchronized MajorPersistence getMajorPersistence(){
        if(majorPersistence==null){
            majorPersistence = new MajorPersistenceStub();
        }
        return majorPersistence;
    }
}
