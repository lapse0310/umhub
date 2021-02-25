package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;

//get list of majors available. and return a major if selected
public interface IAccessPrograms {
    public List<Program> getPrograms();
    public Program getProgramSelected();
    public Program getSequential();
}