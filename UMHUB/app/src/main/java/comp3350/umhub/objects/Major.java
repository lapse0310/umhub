package comp3350.umhub.objects;

import java.util.List;

public class Major {
    private String name;
    private List<Program> programs;

    public Major(String name){
        this.name = name;
    }

    public Major(String name, List<Program> programs){
        this.name = name;
        this.programs = programs;
    }

    public String getName(){
        return this.name;
    }
}
