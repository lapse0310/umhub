package comp3350.umhub.objects;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private String name;
    private List<Course> courses;

    public Program(String name){
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void addCourses(Course course){
        courses.add(course);
    }

}
