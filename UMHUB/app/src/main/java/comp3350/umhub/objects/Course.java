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
>>>>>>> Stashed changes
    private int year;
    private Major major;
    private List<Program> programs;

    public Course(String id){
        this.id = id;
    }

    public Course(String name, String id, String desc, int year){
        this.name = name;
        this.id = id;
        description = desc;
        this.year = year;
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
