package comp3350.umhub.objects;

import java.util.List;

public class Course {
    private String name;
    private String id;
    private String description;
    private int year;
    private String major;
    private List<Program> programs;

    public Course(String id){
        this.id = id;
    }

    public Course(String id, String name, String desc, int year){
        this.name = name;
        this.id = id;
        description = desc;
        this.year = year;
    }

    public Course(String id, String name, String desc, int year, String major){
        this.id = id;
        this.name = name;
        this.description = desc;
        this.year = year;
        this.major = major;
    }

    public Course(String name, String id, String desc, int year, String major, List<Program> programs){
        this.name = name;
        this.id = id;
        description = desc;
        this.year = year;
        this.major = major;
        this.programs = programs;
    }




    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getMajor(){
        return major;
    }

    public List<Program> getPrograms(){
        return programs;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", year=" + year +
                ", major=" + major +
                '}';
    }
}
