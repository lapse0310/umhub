package comp3350.umhub.objects;

public abstract class Review {
    User user;
    int score;
    String review;

    public User getUser() {
        return user;
    }

    public String getUid() {
        return user.getUserName();
    }

    public double getScore() {
        return score;
    }

    public String getReview() {
        return review;
    }

}
