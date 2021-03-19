package comp3350.umhub.persistence;

import java.util.List;

import comp3350.umhub.objects.Major;


public interface IMajorPersistence {
    List<Major> getMajorsSequential();

}
