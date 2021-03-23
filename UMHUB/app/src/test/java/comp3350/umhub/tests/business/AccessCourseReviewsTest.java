package comp3350.umhub.tests.business;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.business.AccessCourseReviews;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.persistence.stubs.CourseReviewPersistenceStub;
import comp3350.umhub.tests.utils.TestUtils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessCourseReviewsTest {
    private AccessCourseReviews accessCourseReviews;
    private CourseReviewPersistenceStub courseReviewPersistence;


    @Test
    public void getCourseReviewTest(){
        /*Needs seperating into multiple sub tests*/
        System.out.println("\nStarting Access Course integration test - getCoursesByMajorTest");

        courseReviewPersistence =  (CourseReviewPersistenceStub) Services.getCourseReviewPersistence();
        assertNotNull("courseReviewPersistence should not be null", courseReviewPersistence);

        List<CourseReview> allCourseReviews = courseReviewPersistence.getCourseReviewsSequential();
        assertNotNull("allCourseReviews should not be null", allCourseReviews);
        assertNotNull("allCourseReviews[0] should not be null", allCourseReviews.get(0));

        assertTrue("1st item should have id 1" , allCourseReviews.get(0).getId() == 1);

        Course comp3350 = new Course("COMP 3350");
        List<CourseReview> courseReviewList1 = courseReviewPersistence.getCourseReviewsSequential(comp3350);
        assertNotNull("courseReviewList1 should not be null", courseReviewList1);
        assertTrue("1st review id should be 1", allCourseReviews.get(0).getId() == 1);
        assertTrue("1st review id should be COMP 3350", allCourseReviews.get(0).getCourse().getId().equals("COMP 3350"));


        accessCourseReviews = (AccessCourseReviews) Services.getAccessCourseReviews();
        assertNotNull("AccessCourseReviews should not be null",accessCourseReviews);

        List<CourseReview> allCourseReviews2 = accessCourseReviews.getCourseReviews();
        assertNotNull("allCourseReviews2 should not be null", allCourseReviews2);
        assertTrue("allCourseReviews2.size should equal allCourseReviews.size", allCourseReviews.size() == allCourseReviews2.size());
        for (int i =0; i < allCourseReviews2.size(); i++){
            assertTrue("Item in allCourseReviews2 should match allCourseReviews",allCourseReviews2.get(i).getId() == allCourseReviews.get(i).getId());
        }

        System.out.println("Finished Access Course integration test - getCoursesByMajorTest");

    }
}
