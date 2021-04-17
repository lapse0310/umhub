package comp3350.umhub.business;

import java.util.Comparator;

import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;

public class programSorter implements Comparator<Program> {

    @Override
    public int compare(Program o1, Program o2) {
        int value = o1.getCourseCount() - o2.getCourseCount();
        if (value == 0) value = o1.getName().compareTo(o2.getName());
        return value;
    }
}
