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

    public String toString(){
        String res = "CourseReview: ";
        String str1 = "id = " + id + ", ";
        String str2 = "user = " + getUser().getUsername() + ", ";
        String str3 = "course = " + getCourse().getId() + ", ";
        String str4 = "review = " + getReview();
        return res + str1 + str2 + str3 + str4;
    }

}
