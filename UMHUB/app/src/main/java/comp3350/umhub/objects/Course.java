package comp3350.umhub.objects;

import java.util.List;

public class Course {
    private String name;
    private String id;
    private String description;
<<<<<<< Updated upstream
    private String major;

    public Course(String name, String id, String desc, String major){
=======
    private String majorID;
    private String year;
    private List<Program> programs;

    public Course(String id){
        this.id = id;
    }

    public Course(String name, String id, String desc, String year){
>>>>>>> Stashed changes
    private int year;
    private Major major;
    private List<Program> programs;

    public Course(String name){
        this.name = name;
    }

    public Course(String name, String id, String desc, String majorID,String year){
        this.name = name;
        this.id = id;
        description = desc;
        this.majorID = majorID;
        this.year = year;
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

    public boolean equals(Program other){
        return this.name.equalsIgnoreCase(other.getName());
    }

    public boolean equals(Course other){
        return this.name.equalsIgnoreCase(other.getId());
    }

}
