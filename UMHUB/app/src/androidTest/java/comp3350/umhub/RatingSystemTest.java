package comp3350.umhub;

import android.view.View;
import android.widget.RatingBar;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.umhub.presentation.LoginActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RatingSystemTest {
    @Rule
    public ActivityTestRule<LoginActivity> activityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void reviewCourse() {
        onView(withId(R.id.etUserName)).perform(typeText("admin"));
        onView(withId(R.id.etPassword)).perform(typeText("123456"));
        onView(withId(R.id.etPassword)).perform(closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.button)).perform(click());
        onView(withText("Computer Science")).perform(click());
        onView(withText("Computer Science General")).perform(click());
        onView(withText("MATH1500")).perform(click());
        onView(withId(R.id.viewTutors)).perform(click());
        onView(withText("TA Awesome")).perform(click());
        onView(withId(R.id.ratingBar)).perform();

        onView(withId(R.id.reviewEditText)).perform(typeText("Test review"));
        onView(withId(R.id.reviewEditText)).perform(closeSoftKeyboard());
        onView(withId(R.id.radioButton4)).perform(click());
        onView(withId(R.id.button2)).perform(click());

        /*

        // add the new course
        onView(withId(R.id.editCourseID)).perform(typeText("4050"));
        onView(withId(R.id.editCourseName)).perform(typeText("Project Management"));
        onView(withId(R.id.buttonCourseCreate)).perform(click());
        closeSoftKeyboard();

        // verify that it was added
        pressBack();
        onView(withId(R.id.buttonCourses)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listCourses)).atPosition(0).perform(click());
        onView(withId(R.id.editCourseName)).check(matches(withText("Project Management")));
*/

    }
}

final class SetRating implements ViewAction {

    @Override
    public Matcher<View> getConstraints() {
        org.hamcrest.Matcher<View> isRatingBarConstraint = ViewMatchers.isAssignableFrom(RatingBar.class);
        return isRatingBarConstraint;
    }

    @Override
    public String getDescription() {
        return "Custom view action to set rating.";
    }

    @Override
    public void perform(UiController uiController, View view) {
        RatingBar ratingBar = (RatingBar) view;
        ratingBar.setRating(3);
    }
}