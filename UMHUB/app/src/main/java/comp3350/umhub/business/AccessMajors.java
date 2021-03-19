//get all the majors in the data layer
package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Major;
import comp3350.umhub.persistence.IMajorPersistence;

public class AccessMajors implements IAccessMajors{

    private List<Major> majors;
    private IMajorPersistence majorPersistence;

    public AccessMajors(){
        majorPersistence = Services.getMajorPersistence();
        majors = majorPersistence.getMajorsSequential();
    }

    public AccessMajors(final IMajorPersistence persistence){
        this();
        majorPersistence = persistence;
    }

    public List<Major> getMajors(){
        return majors;
    }

}
