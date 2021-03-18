package comp3350.umhub.objects;


public class Major {
<<<<<<< Updated upstream
    private String name;
    private List<Program> programs;
    private List<Course> courses;
=======
    private final String name;
    private String id;

    public Major(String id, String name){
        this.id = id;
        this.name = name;
    }
>>>>>>> Stashed changes
    private final String name;

    public Major(String name){
        this.name = name;
    }


    public String getName(){
        return this.name;
    }

<<<<<<< Updated upstream
    public List<Course> getCourses() {
        return courses;
    }

    public List<Program> getPrograms() {
        return programs;
=======
    public String getId() {
        return id;
>>>>>>> Stashed changes
    }
}
