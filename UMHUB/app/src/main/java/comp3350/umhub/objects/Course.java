package comp3350.umhub.objects;

import java.util.List;

public class Course {
    private String name;
    private String id;
    private String description;
    private int year;
    private Major major;
    private List<Program> programs;

    public Course(String id){
        this.id = id;
    }

    public Course(String name, String id, String desc, String year){
        this.name = name;
        this.id = id;
        description = desc;
        this.year = year;
    }

    public Course(String name, String id, String desc, int year, Major major){
        this.name = name;
        this.id = id;
        description = desc;
        this.year = year;
        this.major = major;
    }

    public Course(String name, String id, String desc, int year, Major major, List<Program> programs){
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

    public Major getMajor(){
        return major;
    }

    public List<Program> getPrograms(){
        return programs;
    }


}
