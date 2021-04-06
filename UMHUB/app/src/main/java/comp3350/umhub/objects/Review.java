package comp3350.umhub.objects;

public abstract class Review {
    int _id;
    String review;
    String userId;
    int score;
    public static int MAX_REVIEW_SCORE = 5;
    public static int MIN_REVIEW_SCORE = 0;



    public int getId() {
        return _id;
    }

    public String getUser() {
        return userId;
    }

    public int getScore() {
        return score;
    }

    public String getReview() {
        return review;
    }

}
