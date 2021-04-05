package comp3350.umhub.persistence.sqlite;

public class MyCourseReview {
    int _id;
    String courseId;
    String review;

    public MyCourseReview(int id, String courseId, String review) {
        this._id = id;
        this.courseId = courseId;
        this.review = review;
    }

    public int get_id() {
        return _id;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getReview() {
        return review;
    }
}
