package comp3350.umhub.objects;


public class Course {
    private String name;
    private String id;
    private String description;
    private String major;

    public Course(String name, String id, String desc, String major){
        this.name = name;
        this.id = id;
        description = desc;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }
}
