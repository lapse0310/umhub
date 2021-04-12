package comp3350.umhub.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Tutor;
import comp3350.umhub.persistence.interfaces.ITutorPersistence;

public class AccessTutors implements IAccessTutors{
    private List<Tutor> tutors;

    public AccessTutors(){
        ITutorPersistence tutorPersistence = Services.getTutorPersistence();
        tutors = tutorPersistence.getTutors();


    }

    public AccessTutors(final ITutorPersistence persistence){
        tutors = persistence.getTutors();
    }


    @Override
    public List<Tutor> getTutors(Course courseSelected) {
        List<Tutor> tutorsUnderCourse = new ArrayList<>();
        for(int i=0; i<tutors.size();i++){
            if(tutors.get(i).getCourse().equals(courseSelected)){
                tutorsUnderCourse.add(tutors.get(i));
            }
        }
        Collections.sort(tutorsUnderCourse, new ratingSorter());
        return tutorsUnderCourse;
    }
}
