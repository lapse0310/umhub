package comp3350.umhub.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.TutorEntry;
import comp3350.umhub.objects.TutorRating;
import comp3350.umhub.persistence.interfaces.ITutorPersistence;

public class TutorPersistenceStub implements ITutorPersistence {
    private List<TutorEntry> tutorEntries;

    public TutorPersistenceStub(){
//        this.tutorEntries = new ArrayList<>();
//
//        Course course0 = new Course("COMP3350");
//        Course course1 = new Course("COMP1010");
//        Course course2 = new Course("MATH1500");
//        Course course3 = new Course("MATH1700");
//        Course course4 = new Course("COMP3430");
//
//        tutorEntries.add(new TutorEntry("Cool","cool@umanitoba.ca",course0,"Professor",4.5f));
//        tutorEntries.add(new TutorEntry("Tall","tall@umanitoba.ca",course0,"TA",2f));
//        tutorEntries.add(new TutorEntry("Middle","middle@umanitoba.ca",course0,"TA",3f));
//        tutorEntries.add(new TutorEntry("Short","short@umanitoba.ca",course1,"Professor",3f));
//        tutorEntries.add(new TutorEntry("Grumpy","grumps@umanitoba.ca",course1,"Professor",2.5f));
//        tutorEntries.add(new TutorEntry("Awesome","awsm@umanitoba.ca",course2,"TA",3.5f));
//        tutorEntries.add(new TutorEntry("Nice","noice@umanitoba.ca",course2,"Professor",4f));
//        tutorEntries.add(new TutorEntry("Angry","angry@umanitoba.ca",course3,"TA",3.5f));
//        tutorEntries.add(new TutorEntry("Funny","funyan@umanitoba.ca",course3,"Professor",3.5f));
//        tutorEntries.add(new TutorEntry("Smart","smarties@umanitoba.ca",course4,"Professor",4.5f));
//        tutorEntries.add(new TutorEntry("Sleepy","sleepy@umanitoba.ca",course4,"TA",2.5f));
    }

    public List<TutorEntry> getTutorEntries() {
        return tutorEntries;
    }

    @Override
    public TutorEntry getTutorEntry(String email, String course) {
        return null;
    }

    @Override
    public List<TutorEntry> getTutorEntriesSequential() {
        return null;
    }

    @Override
    public List<TutorEntry> getTutorEntriesByCourse(String course) {
        return null;
    }

    @Override
    public List<TutorEntry> getTutorEntriesByTutor(String email) {
        return null;
    }

    @Override
    public void insertTutorEntry(String name, String email, String courseid, String type) {

    }

    @Override
    public List<TutorRating> getTutorRatingsSequential() {
        return null;
    }

    @Override
    public List<TutorRating> getTutorRatingsByTutorEntry(String email, String courseid) {
        return null;
    }

    @Override
    public void insertTutorRating(String email, String courseid, float rating, String user) {

    }

    @Override
    public void update(int id, String email, String courseId, float rating, String username) {

    }
}
