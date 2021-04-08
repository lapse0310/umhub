package comp3350.umhub.objects;

public class CourseReview extends Review{
    Course course;

    public CourseReview(Users user, Course course, int score, String review){
        this.user = user;
        this.course = course;
        this.score = score;
        this.review = review;

    }

    public Course getCourse() {
        return course;
    }

}
