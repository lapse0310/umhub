package comp3350.umhub.application;

import comp3350.umhub.persistence.IMajorPersistence;
import comp3350.umhub.persistence.stubs.MajorPersistenceStub;

public class Services {
    private static IMajorPersistence majorPersistence = null;

    public static synchronized IMajorPersistence getMajorPersistence(){
        if(majorPersistence==null){
            majorPersistence = new MajorPersistenceStub();
        }
        return majorPersistence;
    }
}
