package comp3350.umhub.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessCourseReviews;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.User;
import comp3350.umhub.persistence.ICourseReviewPersistence;
import comp3350.umhub.persistence.sqlite.CourseReviewSQLDB;

public class WriteCourseReviewActivity extends AppCompatActivity {
    User currentUser;
    Course courseSelected;
    ICourseReviewPersistence courseReviewSQLDB;
    EditText reviewEditText;
    EditText reviewScoreEditText;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_coursereview_input);

        courseReviewSQLDB = Services.getCourseReviewSQLDB(this);

        try{
            reviewEditText = (EditText) findViewById(R.id.reviewEditText);
            radioGroup = findViewById(R.id.radio_group);
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
        currentUser = Services.getCurrentUser();
        courseSelected = CoursesActivity.getCourseSelected();

        String courseID = courseSelected.getId();
        String userID = currentUser.getUsername();
        String review = reviewEditText.getText().toString();
        int score = getRadioButtonValue();
        courseReviewSQLDB.insert(courseID,userID,review,score);
        returnHome();

    }

    public int getRadioButtonValue(){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        int score = Integer.parseInt(radioButton.getText().toString());
        return score;
    }

    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), CourseReviewsActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }


}