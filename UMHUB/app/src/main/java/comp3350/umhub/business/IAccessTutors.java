package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Tutor;

public interface IAccessTutors {
    List<Tutor> getTutors(Course courseSelected);

}
