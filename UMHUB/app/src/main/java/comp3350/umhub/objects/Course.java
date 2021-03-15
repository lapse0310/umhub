package comp3350.umhub.objects;

import java.util.List;

public class Course {
    private final String name;
    private String id;
    private String description;
    private String year;
    private List<Program> programs;

    public Course(String name){
        this.name = name;
    }

    public Course(String name, String id, String desc, String year){
        this.name = name;
        this.id = id;
        description = desc;
        this.year = year;
    }

    public Course(String name, String id, String desc, String year, List<Program> programs){
        this.name = name;
        this.id = id;
        description = desc;
        this.year = year;
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

    public String getYear() {
        return year;
    }

    public List<Program> getPrograms(){
        return programs;
    }

    public Boolean equals(Program other){
        return this.name.equalsIgnoreCase(other.getName());
    }
}
