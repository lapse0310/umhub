//checks if two majors or programs are equal
package comp3350.umhub.business;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;

public class Equals{
    public static boolean isEqualMajor(Major major1, Major major2) {
        return major1.getName().equals(major2.getName());
    }
    public static boolean isEqualProgram(Program program1, Program program2) {
        return program1.getName().equals(program2.getName());
    }

    public static boolean isEqualCourse(Course course1, Course course2){
        return course1.getId().equals(course2.getId());
    }

    public static boolean isEqualCourseReview(CourseReview c1, CourseReview c2){
        return c1.getId() == c2.getId();
    }
}
