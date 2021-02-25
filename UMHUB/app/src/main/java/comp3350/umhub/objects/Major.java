package comp3350.umhub.objects;

import java.util.List;

public class Major {
    private String name;
    private List<Program> programs;
    private List<Course> courses;

    public Major(String name){
        this.name = name;
    }

    public Major(String name, List<Program> programs, List<Course> courses){
        this.name = name;
        this.programs = programs;
        this.courses = courses;
    }

    public Major(String name, List<Program> programs){
        this.name = name;
        this.programs = programs;

    }

    public String getName(){
        return this.name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Program> getPrograms() {
        return programs;
    }
}
