//checks if two majors or programs are equal
package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.objects.User;

public class Equals{
    public static boolean isEqual(Major major1, Major major2) {
        return major1.getName().equals(major2.getName());
    }
    public static boolean isEqual(Program program1, Program program2) {
        return program1.getName().equals(program2.getName());
    }

    public static boolean isEqual(Course course1, Course course2){
        return course1.getId().equals(course2.getId());
    }

    public static boolean isEqual(CourseReview c1, CourseReview c2){
        return c1.getId() == c2.getId();
    }

    public static boolean isEqual(User c1, User c2){
        return c1.getUsername().equals(c2.getUsername());
    }

    public static boolean isEqual(List list1, List list2){
        boolean equal = true;
        if (list1 != null && list2 != null && list1.size() == list2.size()){
            for (int i = 0; i < list1.size() && equal; i++) {
                if (!Equals.isEqual(list1.get(i),list2.get(i)))
                    equal = false;
            }
        }
        else equal = false;
        return equal;
    }

    private static boolean isEqual(Object o1, Object o2) {
        if (o1 instanceof Course && o2 instanceof Course)
            return Equals.isEqual((Course) o1, (Course) o2) ;
        else if (o1 instanceof Program && o2 instanceof Program)
            return Equals.isEqual((Program) o1, (Program) o2) ;
        else if (o1 instanceof Major && o2 instanceof Major)
            return Equals.isEqual((Major) o1, (Major) o2) ;
        else if (o1 instanceof CourseReview && o2 instanceof CourseReview)
            return Equals.isEqual((CourseReview) o1, (CourseReview) o2) ;
        else if (o1 instanceof User && o2 instanceof User)
            return Equals.isEqual((User) o1, (User) o2) ;
        else return false;
    }
}
