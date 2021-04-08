package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;


public interface IAccessCourseReviews {
    List<CourseReview> getCourseReviews(String courseId);
    List<CourseReview> getCourseReviews();
    void addReview(String courseID, String userID, String review, int reviewScore);
}
