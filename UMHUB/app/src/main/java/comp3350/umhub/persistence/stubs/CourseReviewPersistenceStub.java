package comp3350.umhub.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.business.Equals;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.objects.User;
import comp3350.umhub.persistence.ICourseReviewPersistence;

public class CourseReviewPersistenceStub implements ICourseReviewPersistence {
    List<CourseReview> courseReviews;

    @Override
    public List<CourseReview> getCourseReviewsSequential() {
        return courseReviews;
    }

    @Override
    public List<CourseReview> getCourseReviewsSequential(Course course) {
        return null;
    }

    public List<CourseReview> getCourseReviewsSequential(String courseId) {
        List<CourseReview>  courseReviews1= new ArrayList<>();
        for (CourseReview review : courseReviews) {
            if (review.getCourseId().equals(courseId)) courseReviews1.add(review);
        }
        return courseReviews1;
    }

    @Override
    public void insertCourseReview(CourseReview courseReview) {
        if (courseReview != null
                && courseReview.getUser() != null
                && courseReview.getCourseId() != null
                && courseReview.getScore() >= 0
                && courseReview.getScore() <= 5)
            courseReviews.add(courseReview);
    }


    public CourseReviewPersistenceStub(){
        this.courseReviews = new ArrayList<>();
//        Course comp3350 = new Course("COMP 3350");
//        Course comp3170 = new Course("COMP 3170");
//        Course comp3430 = new Course("COMP 3430");
//        Course comp3010 = new Course("COMP 3010");
//        User u1 = new User("u1");
//        User u2 = new User("u2");
//        User u3 = new User("u3");
//        User u4 = new User("u4");
        String comp3350 = "COMP 3350";
        String comp3170 = "COMP 3170";
        String comp3430 = "COMP 3430";
        String comp3010 = "COMP 3010";
        String u1 = "u1";
        String u2 = "u2";
        String u3 = "u3";
        String u4 = "u4";
        int id = 1;
        courseReviews.add(new CourseReview(id++, u1,comp3350,"Awesome",5));
        courseReviews.add(new CourseReview(id++,u1,comp3170,"Nice",5));
        courseReviews.add(new CourseReview(id++,u1,comp3010,"Awesome",5));
        courseReviews.add(new CourseReview(id++,u2,comp3430,"Awesome",5));
        courseReviews.add(new CourseReview(id++,u2,comp3170,"Great",5));
        courseReviews.add(new CourseReview(id++,u2,comp3350,"Awesome",5));
        courseReviews.add(new CourseReview(id++,u3,comp3350,"Excellent",5));
        courseReviews.add(new CourseReview(id++,u3,comp3010,"Loved it",5));
        courseReviews.add(new CourseReview(id++,u3,comp3430,"Awesome",5));
        courseReviews.add(new CourseReview(id++,u4,comp3010,"Awesome",5));
        courseReviews.add(new CourseReview(id++,u4,comp3170,"Urgh",2));
        courseReviews.add(new CourseReview(id++,u4,comp3350,"Awesome",5));

    }

    public String toString(){
        String res = this.getClass().toString() + "\n";
        if (courseReviews != null){
            for (CourseReview c: courseReviews) {
                res += c.toString() + "\n";
            }
        }
        return res;
    }

}
