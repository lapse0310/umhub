package comp3350.umhub.objects;

public class Major {
    private String name;
    private Program[] programs;
    private Course[] courses;

    public Major(String name){
        this.name = name;
    }

    public Major(String name, Program[] programs, Course[] courses){
        this.name = name;
        this.programs = programs;
        this.courses = courses;
    }

    public String getName(){
        return this.name;
    }

    public Course[] getCourses() {
        return courses;
    }

    public Program[] getPrograms() {
        return programs;
    }
}
