package comp3350.umhub.objects;

public class Program {
    private String name;
    private Course[] courses;

    public Program(String name){
        this.name = name;
    }

    public Program(String name, Course[] courses){
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public Course[] getCourses() {
        return courses;
    }
}
