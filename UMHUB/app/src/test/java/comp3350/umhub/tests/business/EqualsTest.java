package comp3350.umhub.tests.business;

import comp3350.umhub.business.Equals;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.objects.User;
import comp3350.umhub.objects.Utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class EqualsTest {

    @Test
    public void testIsEqualMajor(){
        System.out.println("\nStarting test testIsEqualMajor");
        Major major1 = new Major("Test major");
        Major major2 = new Major("Test major");
        assertTrue(Equals.isEqual(major1,major2));
        System.out.println("Finished test testIsEqualMajor");
    }

    @Test
    public void testIsNotEqualMajor(){
        System.out.println("\nStarting test testIsNotEqualMajor");
        Major major1 = new Major("Test major");
        Major major2 = new Major("Test wrong major");
        assertFalse(Equals.isEqual(major1,major2));
        System.out.println("Finished test testIsNotEqualMajor");

    }

    @Test
    public void testIsEqualProgram(){
        System.out.println("\nStarting test testIsEqualProgram");
        Major major1 = new Major("Test major");
        Major major2 = new Major("Test major");
        Program program1 = new Program("Test program",major1);
        Program program2 = new Program("Test program",major2);
        assertTrue(Equals.isEqual(program1,program2));
        System.out.println("Finished test testIsEqualProgram");
    }

    @Test
    public void testIsNotEqualProgram(){
        System.out.println("\nStarting test testIsNotEqualProgram");
        Program program1 = new Program("Test program");
        Program program2 = new Program("Test wrong program");
        Program sameProgram = new Program("Test program");
        assertFalse(Equals.isEqual(program1,program2));
        assertTrue(Equals.isEqual(program1, sameProgram));
        System.out.println("Finished test testIsNotEqualProgram");

    }

    @Test
    public void testIsEqualUserList(){
        System.out.println("\nStarting test testIsEqualUserList");
        User u1 = new User("u1");
        User u2 = new User("u2");

        List<User> list1 = new ArrayList<>();
        list1.add(u1);
        list1.add(u2);

        List<User> list2 = new ArrayList<>();
        list2.add(u1);
        list2.add(u2);

        assertTrue(Equals.isEqual(list1,list2));
        System.out.println("Finished test testIsEqualUserList");

    }

    @Test
    public void testIsEqualCourseList(){
        System.out.println("\nStarting test testIsEqualCourseList");

        Major major1 = new Major("Computer Science");
        Major major2 = new Major("Mathematics");
        Course course1 = new Course("Software Engineering","COMP 3350","Random description",3,major1);
        Course course2 = new Course("Operating Systems","COMP 3430","Random description",3,major2);

        List<Course> list1 = new ArrayList<>();
        list1.add(course1);
        list1.add(course2);
        System.out.println(Utils.listToString(list1,"list1"));

        List<Course> list2 = new ArrayList<>();
        list2.add(course1);
        list2.add(course2);
        System.out.println(Utils.listToString(list2, "list2"));

        assertTrue(Equals.isEqual(list1,list2));
        System.out.println("Finished test testIsEqualCourseList");

    }

    @Test
    public void testIsEqualMajorList(){
        System.out.println("\nStarting test testIsEqualMajorList");

        Major major1a = new Major("Computer Science");
        Major major2a = new Major("Mathematics");
        Major major1b = new Major("Computer Science");
        Major major2b = new Major("Mathematics");

        List<Major> list1 = new ArrayList<>();
        list1.add(major1a);
        list1.add(major2a);
        System.out.println(Utils.listToString(list1,"list1"));

        List<Major> list2 = new ArrayList<>();
        list2.add(major1b);
        list2.add(major2b);
        System.out.println(Utils.listToString(list2,"list2"));

        assertTrue(Equals.isEqual(list1,list2));
        System.out.println("Finished test testIsEqualMajorList");

    }

    @Test
    public void testIsEqualProgramList(){
        System.out.println("\nStarting test testIsEqualProgramList");

        Major major1 = new Major("Computer Science");
        Major major2 = new Major("Mathematics");

        Program program1 = new Program("Computer Science General",major1);
        Program program2 = new Program("Computer Science - Math Joint Honors",major1);
        Program program3 = new Program("Physics - Math Joint Honors",major2);
        Program program4 = new Program("Math is fun program",major2);

        List<Program> list1 = new ArrayList<>();
        list1.add(program1);
        list1.add(program2);
        list1.add(program3);
        list1.add(program4);
        System.out.println(Utils.listToString(list1,"list1"));

        List<Program> list2 = new ArrayList<>();
        list2.add(program1);
        list2.add(program2);
        list2.add(program3);
        list2.add(program4);
        System.out.println(Utils.listToString(list2,"list2"));

        assertTrue(Equals.isEqual(list1,list2));
        System.out.println("Finished test testIsEqualProgramList");

    }

    @Test
    public void testIsEqualCourseReviewList(){
        System.out.println("\nStarting test testIsEqualCourseReviewList");

        Course comp2160 = new Course("COMP 2160");
        User u1 = new User("u1");
        int currId = 1;
        CourseReview review1 = new CourseReview(currId++, u1,comp2160,5,"First");
        CourseReview review2 = new CourseReview(currId++, u1,comp2160, 5,"Second");
        CourseReview review3 = new CourseReview(currId++, u1,comp2160,5,"Third");

        List<CourseReview> list1 = new ArrayList<>();
        list1.add(review1);
        list1.add(review2);
        list1.add(review3);
        System.out.println(Utils.listToString(list1,"list1"));

        List<CourseReview> list2 = new ArrayList<>();
        list2.add(review1);
        list2.add(review2);
        list2.add(review3);
        System.out.println(Utils.listToString(list2,"list2"));

        assertTrue(Equals.isEqual(list1,list2));

        List<CourseReview> list3 = new ArrayList<>();
        list3.add(review1);
        list3.add(review2);
        System.out.println(Utils.listToString(list3,"list3"));
        assertFalse("Incomplete list should not be equal to original",Equals.isEqual(list1,list3));

        list3 = new ArrayList<>();
        list3.add(review1);
        list3.add(review3);
        list3.add(review2);
        System.out.println(Utils.listToString(list3,"list3"));
        assertFalse("Wrong ordered list should not be equal to original", Equals.isEqual(list1,list3));

        list3 = new ArrayList<>();
        list3.add(review1);
        list3.add(review2);
        list3.add(review3);
        list3.add(review1);
        System.out.println(Utils.listToString(list3,"list3"));
        assertFalse("Modified list should not be equal to original", Equals.isEqual(list1,list3));


        System.out.println("Finished test testIsEqualCourseReviewList");

    }


}
