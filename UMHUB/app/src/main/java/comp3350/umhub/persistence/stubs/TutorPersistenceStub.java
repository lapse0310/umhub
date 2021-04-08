package comp3350.umhub.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Tutor;
import comp3350.umhub.persistence.ITutorPersistence;

public class TutorPersistenceStub implements ITutorPersistence {
    private List<Tutor> tutors;

    public TutorPersistenceStub(){
        this.tutors = new ArrayList<>();

        Course course0 = new Course("COMP3350");
        Course course1 = new Course("COMP1010");
        Course course2 = new Course("MATH1500");
        Course course3 = new Course("MATH1700");
        Course course4 = new Course("COMP3430");

        tutors.add(new Tutor("Cool","cool@umanitoba.ca",course0,"Professor",4.5f));
        tutors.add(new Tutor("Tall","tall@umanitoba.ca",course0,"TA",2f));
        tutors.add(new Tutor("Middle","middle@umanitoba.ca",course0,"TA",3f));
        tutors.add(new Tutor("Short","short@umanitoba.ca",course1,"Professor",3f));
        tutors.add(new Tutor("Grumpy","grumps@umanitoba.ca",course1,"Professor",2.5f));
        tutors.add(new Tutor("Awesome","awsm@umanitoba.ca",course2,"TA",3.5f));
        tutors.add(new Tutor("Nice","noice@umanitoba.ca",course2,"Professor",4f));
        tutors.add(new Tutor("Angry","angry@umanitoba.ca",course3,"TA",3.5f));
        tutors.add(new Tutor("Funny","funyan@umanitoba.ca",course3,"Professor",3.5f));
        tutors.add(new Tutor("Smart","smarties@umanitoba.ca",course4,"Professor",4.5f));
        tutors.add(new Tutor("Sleepy","sleepy@umanitoba.ca",course4,"TA",2.5f));
    }

    @Override
    public List<Tutor> getTutors() {
        return tutors;
    }
}
