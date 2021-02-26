//get the programs from the data layer
package comp3350.umhub.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.IProgramPersistence;
import comp3350.umhub.presentation.MajorsActivity;

public class AccessPrograms implements IAccessPrograms {
    private final IProgramPersistence programPersistence;
    private List<Program> programs;

    public AccessPrograms(){
        programPersistence = Services.getProgramPersistence();
        programs = null;

    }


    public List<Program> getPrograms(){
        programs = programPersistence.getProgramsSequential();
        List<Program> programsUnderMajor = new ArrayList<>();
        for(int i=0; i<programs.size();i++){
            if(Equals.isEqualMajor(MajorsActivity.getMajorSelected(),programs.get(i).getMajor())){
                programsUnderMajor.add(programs.get(i));
            }
        }
        return Collections.unmodifiableList(programsUnderMajor);
    }



}
