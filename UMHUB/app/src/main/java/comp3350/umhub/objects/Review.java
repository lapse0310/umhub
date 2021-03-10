package comp3350.umhub.objects;

public abstract class Review {
    User user;
    double score;
    String review;
    int upVote;
    int downVote;

    public User getUser() {
        return user;
    }

    public String getUid() {
        return user.getUid();
    }

    public double getScore() {
        return score;
    }

    public String getReview() {
        return review;
    }

    public int getUpVote() {
        return upVote;
    }

    public int getDownVote() {
        return downVote;
    }

    public int getReviewPoint() {
        return upVote - downVote;
    }

    public void addUpVote() {
        this.upVote++;
    }

    public void addDownVote() {
        this.downVote++;
    }
}
