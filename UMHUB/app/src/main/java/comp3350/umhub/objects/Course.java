package comp3350.umhub.objects;

import java.util.List;

public class Course {
    private String name;
    private String id;
    private String description;
    private String year;
    private List<Program> programs;
    private Major major;


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

    public boolean equals(Program other){
        return this.name.equalsIgnoreCase(other.getName());
    }

    public boolean equals(Course other){
        return this.name.equalsIgnoreCase(other.getId());
    }

}
