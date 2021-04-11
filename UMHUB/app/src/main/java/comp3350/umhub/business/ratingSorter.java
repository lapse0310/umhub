package comp3350.umhub.business;

import java.util.Comparator;

import comp3350.umhub.objects.Tutor;

public class ratingSorter implements Comparator<Tutor> {


    @Override
    public int compare(Tutor o1, Tutor o2) {
        return (int) (o2.getRating()-o1.getRating());
    }
}
