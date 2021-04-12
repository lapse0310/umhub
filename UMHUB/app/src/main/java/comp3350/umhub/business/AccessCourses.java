package comp3350.umhub.business;


import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessCourses;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.interfaces.ICoursePersistence;

public class AccessCourses implements IAccessCourses {
    private ICoursePersistence coursePersistence;


    public AccessCourses( ){
        coursePersistence = Services.getCoursePersistence(null);
    }

    public AccessCourses( final ICoursePersistence persistence) {
        coursePersistence = persistence;
    }

    @Override
    public Course getCourse(String courseId) {
        if (courseId != null) return coursePersistence.getCourse(courseId);
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return coursePersistence.getCoursesSequential();
    }

    @Override
    public List<Course> getCoursesByProgram(Program program) {
        if (program != null)  return coursePersistence.getCoursesByProgram(program.getName());
        return null;
    }

    @Override
    public List<Course> getCoursesByYearProgram(Program program, int year) {
        if (program != null) return coursePersistence.getCoursesByYearProgram(program.getName(),year);
        return null;
    }

    @Override
    public List<Course> getCoursesByMajor(Major major) {
        if (major != null) return coursePersistence.getCoursesByMajor(major.getName());
        return null;
    }

    @Override
    public List<Course> getCoursesByYearMajor(Major major, int year) {
        if (major != null) return coursePersistence.getCoursesByYearMajor(major.getName(),year);
        return null;
    }

}
