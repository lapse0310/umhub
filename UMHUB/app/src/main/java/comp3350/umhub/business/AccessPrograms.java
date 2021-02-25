package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.ProgramPersistence;

public class AccessPrograms {
    private ProgramPersistence programPersistence;
    private List<Program> programs;
    private Program program;
    private int currentProgram;

    public AccessPrograms(){
        programPersistence = Services.getProgramPersistence();
        programs = null;
        program = null;
        currentProgram = 0;
    }

    public List<Program> getPrograms(){
        programs = programPersistence.getProgramsSequential();
        return programs;
    }

    public Program getSequential(){
        if (programs == null){
            programs = programPersistence.getProgramsSequential();
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
