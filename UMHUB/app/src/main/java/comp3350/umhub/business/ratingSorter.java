package comp3350.umhub.business;

import java.util.Comparator;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.TutorEntry;

public class ratingSorter implements Comparator<TutorEntry> {
    IAccessTutors accessTutors = Services.getAccessTutors();

    @Override
    public int compare(TutorEntry o1, TutorEntry o2) {
        float rating1 = accessTutors.getAverageRating(o1);
        float rating2 = accessTutors.getAverageRating(o2);
        return (int)(rating2-rating1);
        //return (int) (o2.getRating()-o1.getRating());
    }
}
