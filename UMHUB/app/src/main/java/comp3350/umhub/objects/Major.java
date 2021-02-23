package comp3350.umhub.objects;

public class Major {
    private String name;
    private Program[] programs;
    private Course[] courses;

    public Major(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
