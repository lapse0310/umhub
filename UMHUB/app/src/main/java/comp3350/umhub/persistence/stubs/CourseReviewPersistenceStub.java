package comp3350.umhub.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

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

    public List<CourseReview> getCourseReviewsSequential(Course course) {
        List<CourseReview>  courseReviews1= new ArrayList<>();
        for (CourseReview review : courseReviews) {
            if (review.getCourse().equals(course)) courseReviews1.add(review);
        }
        return courseReviews1;
    }

    @Override
    public void insertCourseReview(CourseReview courseReview) {
        if (courseReview != null
                && courseReview.getUser() != null
                && courseReview.getCourse() != null
                && courseReview.getScore() >= 0
                && courseReview.getScore() <= 5)
            courseReviews.add(courseReview);
    }


    public CourseReviewPersistenceStub(){
        this.courseReviews = new ArrayList<>();
        Course comp3350 = new Course("COMP 3350");
        Course comp3170 = new Course("COMP 3170");
        Course comp3430 = new Course("COMP 3430");
        Course comp3010 = new Course("COMP 3010");
        User u1 = new User("u1");
        User u2 = new User("u2");
        User u3 = new User("u3");
        User u4 = new User("u4");
        int id = 1;
        courseReviews.add(new CourseReview(id++, u1,comp3350,5,"Awesome"));
        courseReviews.add(new CourseReview(id++,u1,comp3170,5,"Nice"));
        courseReviews.add(new CourseReview(id++,u1,comp3010,5,"Awesome"));
        courseReviews.add(new CourseReview(id++,u2,comp3430,5,"Awesome"));
        courseReviews.add(new CourseReview(id++,u2,comp3170,5,"Great"));
        courseReviews.add(new CourseReview(id++,u2,comp3350,5,"Awesome"));
        courseReviews.add(new CourseReview(id++,u3,comp3350,5,"Excellent"));
        courseReviews.add(new CourseReview(id++,u3,comp3010,5,"Loved it"));
        courseReviews.add(new CourseReview(id++,u3,comp3430,5,"Awesome"));
        courseReviews.add(new CourseReview(id++,u4,comp3010,5,"Awesome"));
        courseReviews.add(new CourseReview(id++,u4,comp3170,1,"Urgh"));
        courseReviews.add(new CourseReview(id++,u4,comp3350,5,"Awesome"));

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
