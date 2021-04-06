package comp3350.umhub.persistence;

import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;

public interface ICourseReviewPersistence {

    List<CourseReview> getCourseReviewsSequential();
    List<CourseReview> getCourseReviewsSequential(String course);
    void insert(String courseID, String userID, String review, int reviewScore);

}
