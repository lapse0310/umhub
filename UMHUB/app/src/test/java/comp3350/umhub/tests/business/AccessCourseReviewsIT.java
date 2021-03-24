package comp3350.umhub.tests.business;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.business.AccessCourseReviews;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.objects.User;
import comp3350.umhub.objects.Utils;
import comp3350.umhub.persistence.stubs.CourseReviewPersistenceStub;
import comp3350.umhub.tests.utils.TestUtils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessCourseReviewsIT {
    private AccessCourseReviews accessCourseReviews;
    private CourseReviewPersistenceStub courseReviewPersistence;


    @Test
    public void getCourseReviewTest(){
        /*Needs separating into multiple sub tests*/
        System.out.println("\nStarting AccessCourseReviewsIT integration test - getCourseReviewTest");

        courseReviewPersistence =  new CourseReviewPersistenceStub();
        assertNotNull("courseReviewPersistence should not be null", courseReviewPersistence);

        List<CourseReview> allCourseReviews = courseReviewPersistence.getCourseReviewsSequential();
        assertNotNull("allCourseReviews should not be null", allCourseReviews);
        assertNotNull("allCourseReviews[0] should not be null", allCourseReviews.get(0));

        assertTrue("1st item should have id 1" , allCourseReviews.get(0).getId() == 1);

        Course comp3350 = new Course("COMP 3350");
        List<CourseReview> courseReviewList1 = courseReviewPersistence.getCourseReviewsSequential(comp3350);
        assertNotNull("courseReviewList1 should not be null", courseReviewList1);
        assertTrue("courseReviewList should not be empty", courseReviewList1.size() > 0);
        assertTrue("1st review id should be 1", courseReviewList1.get(0).getId() == 1);
        assertTrue("1st review id should be COMP 3350", courseReviewList1.get(0).getCourse().getId().equals("COMP 3350"));


        accessCourseReviews = new AccessCourseReviews(courseReviewPersistence);
        assertNotNull("AccessCourseReviews should not be null",accessCourseReviews);

        List<CourseReview> allCourseReviews2 = accessCourseReviews.getCourseReviews();
        assertNotNull("allCourseReviews2 should not be null", allCourseReviews2);
        assertTrue("allCourseReviews2.size should equal allCourseReviews.size", allCourseReviews.size() == allCourseReviews2.size());
        for (int i =0; i < allCourseReviews2.size(); i++){
            assertTrue("Item in allCourseReviews2 should match allCourseReviews",allCourseReviews2.get(i).getId() == allCourseReviews.get(i).getId());
        }

        List<CourseReview> courseReviewList2 = accessCourseReviews.getCourseReviews(comp3350);
        assertNotNull("courseReviewList2 should not be null", courseReviewList2);
        assertTrue("courseReviewList should not be empty", courseReviewList1.size() > 0);
        assertTrue("1st review id should be 1", courseReviewList2.get(0).getId() == 1);
        assertTrue("1st review id should be COMP 3350", courseReviewList2.get(0).getCourse().getId().equals("COMP 3350"));

        System.out.println("Finished AccessCourseReviewsIT integration test - getCourseReviewTest");
//        System.out.println(Utils.listToString(courseReviewList2));


    }



    @Test
    public void addCourseReviewTest(){
        System.out.println("\nStarting AccessCourseReviewsIT integration test - addCourseReviewTest");
        courseReviewPersistence = new CourseReviewPersistenceStub();

        List<CourseReview> allCourseReviews = courseReviewPersistence.getCourseReviewsSequential();
        assertNotNull("allCourseReviews should not be null", allCourseReviews);
        assertNotNull("allCourseReviews[0] should not be null", allCourseReviews.get(0));
        assertTrue("1st item should have id 1" , allCourseReviews.get(0).getId() == 1);
        System.out.println(Utils.listToString(allCourseReviews,null));

        Course comp2160 = new Course("COMP 2160");
        User u1 = new User("u1");
        CourseReview review = new CourseReview(allCourseReviews.size()+1, u1,comp2160,5,"New Review!");
        courseReviewPersistence.insertCourseReview(review);

        List<CourseReview> allCourseReviews3 = courseReviewPersistence.getCourseReviewsSequential(comp2160);
        assertNotNull("allCourseReviews2 should not be null", allCourseReviews3);
        assertNotNull("allCourseReviews2[-1] should not be null", allCourseReviews3.get(0));
        assertTrue("last item should have course id = COMP 2160" , allCourseReviews3.get(0).getCourse().getId() == "COMP 2160");
        System.out.println(Utils.listToString(allCourseReviews3,null));

        List<CourseReview> allCourseReviews2 = courseReviewPersistence.getCourseReviewsSequential();
        assertNotNull("allCourseReviews2 should not be null", allCourseReviews2);
        assertNotNull("allCourseReviews2[-1] should not be null", allCourseReviews2.get(allCourseReviews.size()-1));
        assertTrue("last item should have course id = COMP 2160" , allCourseReviews2.get(allCourseReviews.size()-1).getCourse().getId() == "COMP 2160");
        System.out.println(Utils.listToString(allCourseReviews2,null));



        System.out.println("Finished AccessCourseReviewsIT integration test - addCourseReviewTest");

    }

    @Test
    public void addInvalidCourseReviewTest(){
        System.out.println("\nStarting AccessCourseReviewsIT integration test - addCourseReviewTest");
        courseReviewPersistence = new CourseReviewPersistenceStub();

        List<CourseReview> allCourseReviews = courseReviewPersistence.getCourseReviewsSequential();
        assertNotNull("allCourseReviews should not be null", allCourseReviews);
        assertNotNull("allCourseReviews[0] should not be null", allCourseReviews.get(0));
        assertTrue("1st item should have id 1" , allCourseReviews.get(0).getId() == 1);
        System.out.println(Utils.listToString(allCourseReviews,null));

        Course comp2160 = new Course("COMP 2160");
        User u1 = new User("u1");
        int currId = allCourseReviews.size()+1;

        CourseReview review1 = new CourseReview(currId++, null,comp2160,5,"This should not be in the list!");
        courseReviewPersistence.insertCourseReview(review1);
        List<CourseReview> allCourseReviews2 = courseReviewPersistence.getCourseReviewsSequential();
        assertTrue(allCourseReviews2.size() == allCourseReviews.size());
        assertTrue(allCourseReviews2.get(allCourseReviews.size()-1).getId() == 12);

        CourseReview review2 = new CourseReview(currId++, u1,null,5,"This should not be in the list!");
        CourseReview review3 = new CourseReview(currId++, u1,comp2160, -1,"This should not be in the list!");
        CourseReview review4 = new CourseReview(currId++, u1,comp2160,10,"This should not be in the list!");
        CourseReview review5 = new CourseReview(currId++, u1,comp2160,5,null);

        courseReviewPersistence.insertCourseReview(review2);
        courseReviewPersistence.insertCourseReview(review3);
        courseReviewPersistence.insertCourseReview(review4);
        courseReviewPersistence.insertCourseReview(review5);





        List<CourseReview> allCourseReviews3 = courseReviewPersistence.getCourseReviewsSequential(comp2160);
        assertNotNull("allCourseReviews2 should not be null", allCourseReviews3);
        assertNotNull("allCourseReviews2[-1] should not be null", allCourseReviews3.get(0));
        assertTrue("last item should have course id = COMP 2160" , allCourseReviews3.get(0).getCourse().getId() == "COMP 2160");
        System.out.println(Utils.listToString(allCourseReviews3,null));

        allCourseReviews2 = courseReviewPersistence.getCourseReviewsSequential();
        assertNotNull("allCourseReviews2 should not be null", allCourseReviews2);
        assertNotNull("allCourseReviews2[-1] should not be null", allCourseReviews2.get(allCourseReviews.size()-1));
        assertTrue("last item should have course id = COMP 2160" , allCourseReviews2.get(allCourseReviews.size()-1).getCourse().getId() == "COMP 2160");
        System.out.println(Utils.listToString(allCourseReviews2,null));



        System.out.println("Finished AccessCourseReviewsIT integration test - addCourseReviewTest");

    }


}
