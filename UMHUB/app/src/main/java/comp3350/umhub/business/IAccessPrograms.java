package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;

//get list of programs available.
public interface IAccessPrograms {
    List<Program> getPrograms(Major major);
}