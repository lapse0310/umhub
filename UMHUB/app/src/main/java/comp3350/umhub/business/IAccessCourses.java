package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;

public interface IAccessCourses {
    List<Course> getCourses();
    List<Course> getCoursesByProgram(Program program);
    List<Course> getCoursesByYearProgram(Program programSelected, int year);
    List<Course> getCoursesByMajor(Major major);
    List<Course> getCoursesByYearMajor(Major major, int year);

}
