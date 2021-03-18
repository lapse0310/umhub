package comp3350.umhub.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.IProgramPersistence;

public class ProgramPersistenceStub implements IProgramPersistence {
    List<Program> programs;

    public ProgramPersistenceStub(){
        this.programs = new ArrayList<>();
        Major major1 = new Major("Computer Science");
        Major major2 = new Major("Engineering");
        Major major3 = new Major("Mathematics");
        Major major4 = new Major ("Accounting");
        programs.add(new Program("Computer Science General",major1));
        programs.add(new Program("Computer Science - Math Joint Honors",major1));
        programs.add(new Program("Computer Science - Physics Joint Honors",major1));
        programs.add(new Program("Computer Science - Philosophy Joint Honors",major1));
        programs.add(new Program("Computer Science Honors, Coop",major1));
        programs.add(new Program("Physics - Math Joint Honors",major3));
        programs.add(new Program("Math is fun program",major3));
        programs.add(new Program("Math is not fun program",major3));
        programs.add(new Program("Civil Engineering",major2));
        programs.add(new Program("Mechanical Engineering",major2));
        programs.add(new Program("Engineering program 3",major2));
        programs.add(new Program("Engineering program 4",major2));
        programs.add(new Program("Accounting program 1",major4));
        programs.add(new Program("Accounting program 2",major4));
        programs.add(new Program("Accounting program 3",major4));

    }

    @Override
<<<<<<< Updated upstream
    public List<Program> getProgramsSequential() {
        return Collections.unmodifiableList(programs);
=======
    public List<Program> getProgramSequential() {
        return null;
    }

    @Override
    public List<Program> getProgramRandom(Program currentProgram) {
        return null;
>>>>>>> Stashed changes
    }
}
