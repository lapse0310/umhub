//get the programs from the data layer
package comp3350.umhub.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.IProgramPersistence;

public class AccessPrograms implements IAccessPrograms {
    private final List<Program> programs;


    public AccessPrograms(){
        IProgramPersistence programPersistence = Services.getProgramPersistence();
        programs = programPersistence.getProgramsSequential();


    }

    public List<Program> getPrograms(Major majorSelected){

        List<Program> programsUnderMajor = new ArrayList<>();
        for(int i=0; i<programs.size();i++){
            if(Equals.isEqualMajor(majorSelected,programs.get(i).getMajor())){
                programsUnderMajor.add(programs.get(i));
            }
        }
        return programsUnderMajor;
    }



}
