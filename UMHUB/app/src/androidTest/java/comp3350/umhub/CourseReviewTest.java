package comp3350.umhub;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import comp3350.umhub.application.Services;
import comp3350.umhub.persistence.old.ICoursePersistence;
import comp3350.umhub.presentation.HomeActivity;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CourseReviewTest {
    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Before
    public void setUpDatabase(){
        ICoursePersistence coursePersistence = Services.getCoursePersistence();

    }
}
