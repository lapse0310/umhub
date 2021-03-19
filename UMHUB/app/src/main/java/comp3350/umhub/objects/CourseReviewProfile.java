package comp3350.umhub.objects;

import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessCourseReviews;

public class CourseReviewProfile {
    Course course;
    List<CourseReview> courseReviewList;
    IAccessCourseReviews courseReviews;

    public CourseReviewProfile(Course course){
        this.course = course;
        this.courseReviews = Services.getAccessCourseReviews();
        this.courseReviewList = courseReviews.getCourseReviews(course);
    }

}
