package comp3350.umhub.persistence;

import java.util.List;

import comp3350.umhub.objects.Course;

public interface ICoursePersistence {
    List<Course> getCourseSequential();

    List<Course> getCourseRandom(Course currentCourse);
}
