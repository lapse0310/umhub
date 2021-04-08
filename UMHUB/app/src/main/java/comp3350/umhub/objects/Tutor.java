package comp3350.umhub.objects;

import java.text.DecimalFormat;

public class Tutor {
    private String name;
    private String email;
    private Course course;
    private String type;
    private float rating;

    public Tutor(String name, String email, Course course, String type, float rating){
        this.name = name;
        this.email = email;
        this.course = course;
        this.type = type;
        this.rating = rating;
    }

    public Tutor(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public float getRating() {
        DecimalFormat df = new DecimalFormat("#.##");
        return Float.parseFloat(df.format(rating));
    }

    public void setRating(float r){
        rating = (rating + r)/2.0f;
    }

    public String getType() {
        return type;
    }

    public String displayName(){
        return type+" "+name;
    }

    public String displaySub(){return "Contact: "+email+"   Rating: "+getRating();}

    public Course getCourse() {
        return course;
    }


}
