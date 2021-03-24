package comp3350.umhub.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessCourseReviews;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.objects.User;

public class WriteCourseReviewActivity extends AppCompatActivity {
    private User currentUser;
    private Course course;

    IAccessCourseReviews accessCourseReviews;

    EditText reviewEditText;
    EditText reviewScoreEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_coursereview_input);
        accessCourseReviews = Services.getAccessCourseReviews();
        currentUser = Services.getCurrentUser();
        course = CoursesActivity.getCourseSelected();

        try{
            reviewEditText = (EditText) findViewById(R.id.reviewEditText);
            reviewScoreEditText = (EditText) findViewById(R.id.reviewScoreEditTextNumber);
        }
        catch (final Exception e){
            Messages.fatalError(this,e.getMessage());
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void buttonSubmitCourseReviewOnClick(View view){
        String review = reviewEditText.getText().toString();
        int reviewScore = Integer.parseInt(reviewScoreEditText.getText().toString());

        CourseReview courseReview = new CourseReview(currentUser,course,reviewScore,review);
        accessCourseReviews.addReview(courseReview);

        Intent WriteCourseReviewIntent = new Intent(WriteCourseReviewActivity.this, CourseReviewsActivity.class);
        WriteCourseReviewActivity.this.startActivity(WriteCourseReviewIntent);
    }
}