package comp3350.umhub.objects;


import comp3350.umhub.application.Services;

public class Major {
    private final String name;

    public Major(String name){
        this.name = name;
    }


    public String getName(){
        return this.name;
    }

    public boolean equals(Major other){
        return this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return "Major{" +
                "name='" + name + '\'' +
                '}';
    }

    public int getCourseCount() {
        return Services.getAccessCourses().getCoursesByMajor(this).size();
    }

    public int getProgramCount() {
        return Services.getAccessPrograms().getProgramsByMajor(this).size();
    }
}
