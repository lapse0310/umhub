package comp3350.umhub.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.objects.Users;
import comp3350.umhub.persistence.ICourseReviewPersistence;

public class CourseReviewPersistenceStub implements ICourseReviewPersistence {
    List<CourseReview> courseReviews;

    @Override
    public List<CourseReview> getCourseReviewsSequential() {
        return courseReviews;
    }

    public List<CourseReview> getCourseReviewsSequential(Course course) {
        List<CourseReview>  courseReviews1= new ArrayList<>();
        for (CourseReview review : courseReviews) {
            if (review.getCourse().equals(course)) courseReviews1.add(review);
        }
        return courseReviews1;
    }

    @Override
    public void insertCourseReview(CourseReview courseReview) {

    }


    public CourseReviewPersistenceStub(){
        this.courseReviews = new ArrayList<>();
        Course comp3350 = new Course("comp3350");
        Course comp3170 = new Course("comp3170");
        Course comp3430 = new Course("comp3430");
        Course comp3010 = new Course("comp3430");
        Users u1 = new Users("u1");
        Users u2 = new Users("u2");
        Users u3 = new Users("u3");
        Users u4 = new Users("u4");
        courseReviews.add(new CourseReview(u1,comp3350,5,"Awesome"));
        courseReviews.add(new CourseReview(u1,comp3170,5,"Nice"));
        courseReviews.add(new CourseReview(u1,comp3010,5,"Awesome"));
        courseReviews.add(new CourseReview(u2,comp3430,5,"Awesome"));
        courseReviews.add(new CourseReview(u2,comp3170,5,"Great"));
        courseReviews.add(new CourseReview(u2,comp3350,5,"Awesome"));
        courseReviews.add(new CourseReview(u3,comp3350,5,"Excellent"));
        courseReviews.add(new CourseReview(u3,comp3010,5,"Loved it"));
        courseReviews.add(new CourseReview(u3,comp3430,5,"Awesome"));
        courseReviews.add(new CourseReview(u4,comp3010,5,"Awesome"));
        courseReviews.add(new CourseReview(u4,comp3170,5,"Awful"));
        courseReviews.add(new CourseReview(u4,comp3350,5,"Awesome"));

    }

}
