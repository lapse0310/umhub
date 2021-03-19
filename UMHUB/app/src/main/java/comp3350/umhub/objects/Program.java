package comp3350.umhub.objects;

public class Program {
    private final String name;
    private Major major;

    public Program(String name){
        this.name = name;
    }

    public Program(String name, Major major){
        this.name = name;
        this.major = major;
    }


    public String getName() {
        return name;
    }

    public Major getMajor(){
        return major;
    }

}