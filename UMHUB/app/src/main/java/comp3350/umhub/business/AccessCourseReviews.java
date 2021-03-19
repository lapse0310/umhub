package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.persistence.ICourseReviewPersistence;


public class AccessCourseReviews implements IAccessCourseReviews{

    private final ICourseReviewPersistence courseReviewPersistence;
    private List<CourseReview> courseReviews;

    public AccessCourseReviews(){
        courseReviewPersistence = Services.getCourseReviewPersistence();
        courseReviews = null;
    }

    @Override
    public List<CourseReview> getCourseReviews() {
        courseReviews = courseReviewPersistence.getCourseReviewsSequential();
        return courseReviews;
    }

    @Override
    public void addReview(CourseReview courseReview) {
        if (courseReview != null
                && courseReview.getUid() != null
                && courseReview.getCourse() != null
                && courseReview.getScore() >= 0
                && courseReview.getScore() <= 5)
            courseReviewPersistence.insertCourseReview(courseReview);
    }

    public List<CourseReview> getCourseReviews(Course course) {
        courseReviews = courseReviewPersistence.getCourseReviewsSequential(course);
        return courseReviews;
    }
}