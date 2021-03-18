package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Program;

public interface IAccessCourses {
    List<Course> getCourses(Program program);

    List<Course> getYear1Courses(Program program);

    List<Course> getYear2Courses(Program program);

    List<Course> getYear3Courses(Program program);

    List<Course> getYear4Courses(Program program);
}
