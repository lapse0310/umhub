package comp3350.umhub.business;

import java.util.Comparator;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;

public class majorSorter implements Comparator<Major> {
    public static final int BY_COURSE = 1;
    public static final int BY_PROGRAM = 0;

    int sortBy;
    public majorSorter(){
        this.sortBy = BY_COURSE;
    }

    public majorSorter(int sortBy){
        this.sortBy = sortBy;
    }

    @Override
    public int compare(Major o1, Major o2) {
        int value = 0;
        switch (sortBy) {
            case BY_COURSE:
                value = o1.getCourseCount() - o2.getCourseCount();
                if (value == 0) value = o1.getProgramCount() - o2.getProgramCount();
                break;
            case BY_PROGRAM:
                value = o1.getProgramCount() - o2.getProgramCount();
                if (value == 0) value = o1.getCourseCount() - o2.getCourseCount();
                break;
            default:
                value = o1.getName().compareTo(o2.getName());
        }
        return value;
    }
}
