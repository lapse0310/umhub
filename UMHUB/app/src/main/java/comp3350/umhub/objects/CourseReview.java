package comp3350.umhub.objects;

public class CourseReview extends Review{
    String courseId;

    public CourseReview(String courseId , String userId, String review, int score){
        this._id = 0;
        this.userId = userId;
        this.courseId = courseId;
        this.score = score;
        this.review = review;

    }

    public CourseReview(int id, String courseId , String userId, String review, int score){
        this._id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.score = score;
        this.review = review;
    }

    public String getCourseId() {
        return courseId;
    }


    @Override
    public String toString() {
        return "CourseReview{" +
                "id=" + _id +
                ", course=" + courseId +
                ", user=" + userId +
                ", score=" + score +
                ", review='" + review + '\'' +
                '}';
    }
}
