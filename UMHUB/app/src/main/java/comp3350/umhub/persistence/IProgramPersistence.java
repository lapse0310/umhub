package comp3350.umhub.persistence;

import java.util.List;

import comp3350.umhub.objects.Program;

public interface IProgramPersistence {
    List<Program> getProgramSequential();
}
