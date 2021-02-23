package comp3350.umhub.persistence.stubs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.umhub.objects.Major;
import comp3350.umhub.persistence.MajorPersistence;

public class MajorPersistenceStub implements MajorPersistence {
    private List<Major> majors;

    public MajorPersistenceStub(){
        this.majors = new ArrayList<>();

        majors.add(new Major("Computer Science"));
        majors.add(new Major("Accounting"));
        majors.add(new Major("Engineering"));
        majors.add(new Major("Mathematics"));
        majors.add(new Major("Social Work"));
        majors.add(new Major("Philosophy"));

    }

    @Override
    public List<Major> getMajorsSequential(){
        return Collections.unmodifiableList(majors) ;
    }
}
