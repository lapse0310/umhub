package comp3350.umhub.objects;

public abstract class Review {
    int id;
    User user;
    int score;
    String review;


    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public int getScore() {
        return score;
    }

    public String getReview() {
        return review;
    }

}
