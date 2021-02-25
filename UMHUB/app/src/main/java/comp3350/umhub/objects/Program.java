package comp3350.umhub.objects;

import java.util.List;

public class Program {
    private String name;
    private List<Course> courses;

    public Program(String name){
        this.name = name;
    }

    public Program(String name, List<Course> courses){
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
