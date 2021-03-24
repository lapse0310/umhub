package comp3350.umhub.objects;

public class CourseReview extends Review{
    Course course;
    static int idCount = 0;

    public CourseReview(User user, Course course, int score, String review){
        this.id = setId();
        this.user = user;
        this.course = course;
        this.score = score;
        this.review = review;

    }

    public CourseReview(int id, User user, Course course, int score, String review){
        this.id = setId(id);
        this.user = user;
        this.course = course;
        this.score = score;
        this.review = review;
    }

    public Course getCourse() {
        return course;
    }



    public static int setId() {
        idCount++;
        return idCount;
    }

    public static int setId(int id) {
        if (idCount < id) idCount = id;
        return id;
    }


    @Override
    public String toString() {
        return "CourseReview{" +
                "id=" + id +
                ", course=" + course.getId() +
                ", user=" + user.getUsername() +
                ", score=" + score +
                ", review='" + review + '\'' +
                '}';
    }
}
