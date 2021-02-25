package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.objects.Major;

//get list of majors available. and return a major if selected
public interface IAccessMajors {
    public List<Major> getMajors();
    public Major getMajorSelected();

}
