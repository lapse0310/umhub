package comp3350.umhub.objects;

public abstract class Review {
    Users user;
    int score;
    String review;

    public Users getUser() {
        return user;
    }

    public String getUid() {
        return user.getUserName();
    }

    public int getScore() {
        return score;
    }

    public String getReview() {
        return review;
    }

}
