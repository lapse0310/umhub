package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.persistence.ICourseReviewPersistence;


public class AccessCourseReviews implements IAccessCourseReviews {

    private final ICourseReviewPersistence courseReviewPersistence;
    private List<CourseReview> courseReviews;

    public AccessCourseReviews() {
        courseReviewPersistence = Services.getCourseReviewPersistence();
        if (courseReviewPersistence != null)
            courseReviews = courseReviewPersistence.getCourseReviewsSequential();
    }

    public AccessCourseReviews(ICourseReviewPersistence persistence) {
        courseReviewPersistence = persistence;
        if (courseReviewPersistence != null)
            courseReviews = courseReviewPersistence.getCourseReviewsSequential();
    }

    @Override
    public List<CourseReview> getCourseReviews() {
        return courseReviews;
    }

    @Override
    public void addReview(String courseID, String userID, String review, int reviewScore) {
        courseReviewPersistence.insert(courseID,userID,review,reviewScore);
    }

    public List<CourseReview> getCourseReviews(String course) {
        List<CourseReview> res = null;
        if (courseReviewPersistence != null)
            res = courseReviewPersistence.getCourseReviewsSequential(course);
        return res;
    }

    public String toString() {
        String res = this.getClass().toString() + "\n";
        if (courseReviews != null) {
            for (CourseReview c : courseReviews) {
                res += c.toString() + "\n";
            }
        }
        return res;
    }
}
