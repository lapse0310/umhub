package comp3350.umhub.objects;

import java.util.List;

public class Program {
    private String name;
    private Major major;
    private List<Course> courses;

    public Program(String name){
        this.name = name;
    }

    public Program(String name, Major major){
        this.name = name;
        this.major = major;
    }

    public Program(String name, Major major, List<Course> courses){
        this.name = name;
        this.major = major;
        this.courses = courses;
    }

    public Program(String name, List<Course> courses){
        this.name = name;
        this.courses = courses;
    }


    public String getName() {
        return name;
    }

    public Major getMajor(){
        return major;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
