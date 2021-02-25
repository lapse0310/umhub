package comp3350.umhub.objects;

//Student object -if name == "guest" other attributes are null
//password? need to see how to make a login
public class Student {
    private String name;
    private String id;
    private Major major;
    private String email;

    public Student(String name, String id, Major major, String email){
        this.name = name;
        this.id = id;
        this.major = major;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Major getMajor() {
        return major;
    }

    public String getEmail() {
        return email;
    }
}
