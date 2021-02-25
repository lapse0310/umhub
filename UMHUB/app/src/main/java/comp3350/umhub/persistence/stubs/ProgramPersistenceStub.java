package comp3350.umhub.persistence.stubs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.IProgramPersistence;

public class ProgramPersistenceStub implements IProgramPersistence {
    List<Program> programs;

    public ProgramPersistenceStub(){
        this.programs = new ArrayList<>();
        programs.add(new Program("Computer Science - Math Joint Honors"));
        programs.add(new Program("Computer Science - Physics Joint Honors"));
        programs.add(new Program("Computer Science - Philosophy Joint Honors"));
        programs.add(new Program("Computer Science Honors, Coop"));
        programs.add(new Program("Natural Science"));
        programs.add(new Program("Physics - Math Joint Honors"));
        programs.add(new Program("Civil Engineering"));
        programs.add(new Program("Mechanical Engineering"));
    }

    @Override
    public List<Program> getProgramsSequential() {
        return Collections.unmodifiableList(programs);
    }
}
