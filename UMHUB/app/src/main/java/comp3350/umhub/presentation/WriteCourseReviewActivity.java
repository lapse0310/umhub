package comp3350.umhub.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessCourseReviews;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.User;
import comp3350.umhub.persistence.sqlite.CourseReviewSQLDB;

public class WriteCourseReviewActivity extends AppCompatActivity {
    private User currentUser;
    private Course course;

    IAccessCourseReviews accessCourseReviews;

    EditText reviewEditText;
    EditText reviewScoreEditText;

/*    @Override
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


    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

/*    public void buttonSubmitCourseReviewOnClick(View view){
        String review = reviewEditText.getText().toString();
        int reviewScore = Integer.parseInt(reviewScoreEditText.getText().toString());

        CourseReview courseReview = new CourseReview(currentUser,course,reviewScore,review);
        accessCourseReviews.addReview(courseReview);


        Intent WriteCourseReviewIntent = new Intent(WriteCourseReviewActivity.this, CourseReviewsActivity.class);
        WriteCourseReviewActivity.this.startActivity(WriteCourseReviewIntent);
    }*/

    private CourseReviewSQLDB courseReviewSQLDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_coursereview_input);

//        Intent intent = getIntent();
//        courseID = intent.getStringExtra("courseID");

        courseReviewSQLDB = Services.getCourseReviewSQLDB(this);
        //courseReviewSQLDB = new CourseReviewSQLDB(this);

        try{
            reviewEditText = (EditText) findViewById(R.id.reviewEditText);
            reviewScoreEditText = (EditText) findViewById(R.id.reviewScoreEditTextNumber);
        }
        catch (final Exception e){
            Messages.fatalError(this,e.getMessage());
        }


    }

    public void buttonSubmitCourseReviewOnClick(View view){
        String courseID = CoursesActivity.getCourseSelected().getId();
        String userID = Services.getCurrentUser().getUsername();
        String review = reviewEditText.getText().toString();
        int reviewScore = Integer.parseInt(reviewScoreEditText.getText().toString());
        courseReviewSQLDB.insert(courseID,userID,review,reviewScore);
        returnHome();

    }

    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), CourseReviewsActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}