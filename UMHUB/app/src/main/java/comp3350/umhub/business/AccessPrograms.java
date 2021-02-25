package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.IProgramPersistence;
import comp3350.umhub.presentation.MajorsActivity;
import comp3350.umhub.presentation.ProgramsActivity;

public class AccessPrograms implements IAccessPrograms {
    private IProgramPersistence IProgramPersistence;
    private List<Program> programs;
    private Program program;
    private int currentProgram;

    public AccessPrograms(){
        IProgramPersistence = Services.getProgramPersistence();
        programs = null;
        program = null;
        currentProgram = 0;
    }

    public AccessPrograms(IProgramPersistence programPersistence){
        IProgramPersistence = programPersistence;
        programs = null;
        program = null;
        currentProgram = 0;
    }

    public List<Program> getPrograms(){
        programs = IProgramPersistence.getProgramsSequential();
        return programs;
    }

    @Override
    public Program getProgramSelected() {
        return ProgramsActivity.getProgramSelected();
    }

    public Program getSequential(){
        if (programs == null){
            programs = IProgramPersistence.getProgramsSequential();
            currentProgram = 0;
        }
        if (currentProgram < programs.size()){
            program = (Program) programs.get(currentProgram);
            currentProgram++;
        }
        else {
            programs = null;
            program = null;
            currentProgram = 0;
        }
        return program;
    }


}
