package comp3350.umhub.objects;

public class CourseReview extends Review{
    Course course;
    String prof;

    public CourseReview(Users user, Course course, String prof, double score, String review){
        this.user = user;
        this.course = course;
        this.prof = prof;
        this.score = score;
        this.review = review;

    }

    public Course getCourse() {
        return course;
    }

    public String getProf() {
        return prof;
    }
}

