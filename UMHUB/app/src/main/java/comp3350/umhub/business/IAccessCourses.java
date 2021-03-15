package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Program;

public interface IAccessCourses {
    List<Course> getCourses(Program program);
}
