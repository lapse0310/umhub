package comp3350.umhub.persistence.stubs;

import java.util.List;

import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.persistence.ICourseReviewPersistence;

public class CourseReviewPersistenceStub implements ICourseReviewPersistence {
    @Override
    public List<CourseReview> getCourseReviewsSequential() {
        return null;
    }
}
