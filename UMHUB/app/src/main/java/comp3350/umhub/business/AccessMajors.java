//get all the majors in the data layer
package comp3350.umhub.business;

import java.util.Collections;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Major;
import comp3350.umhub.persistence.IMajorPersistence;

public class AccessMajors implements IAccessMajors{

    private final IMajorPersistence majorPersistence;
    private List<Major> majors;

    public AccessMajors(){
        majorPersistence = Services.getMajorPersistence();
        majors = null;
    }

    public List<Major> getMajors(){
        majors = majorPersistence.getMajorsSequential();
        return Collections.unmodifiableList(majors);
    }



}
