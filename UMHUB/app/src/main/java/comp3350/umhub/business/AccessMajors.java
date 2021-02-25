package comp3350.umhub.business;

import java.util.Collections;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.IMajorPersistence;
import comp3350.umhub.presentation.MajorsActivity;

public class AccessMajors implements IAccessMajors{

    private final IMajorPersistence majorPersistence;
    private List<Major> majors;
    private Major major;
    private int currentMajor;

    public AccessMajors(){
        majorPersistence = Services.getMajorPersistence();
        majors = null;
        major = null;
        currentMajor = 0;
    }

    public List<Major> getMajors(){
        majors = majorPersistence.getMajorsSequential();
        return Collections.unmodifiableList(majors);
    }

    public Major getMajorSelected(){
        return MajorsActivity.getMajorSelected();
    }

    public Major getSequential(){
        if (majors == null){
            majors = majorPersistence.getMajorsSequential();
            currentMajor = 0;
        }
        if (currentMajor < majors.size()){
            major = (Major) majors.get(currentMajor);
            currentMajor++;
        }
        else {
            majors = null;
            major = null;
            currentMajor = 0;
        }
        return major;
    }

}
