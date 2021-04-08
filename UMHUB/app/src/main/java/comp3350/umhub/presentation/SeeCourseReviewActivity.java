package comp3350.umhub.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.persistence.ICourseReviewPersistence;

public class SeeCourseReviewActivity extends AppCompatActivity {

    ICourseReviewPersistence courseReviewSQLDB;
    TextView reviewTextView;
    TextView usernameTextView;
    TextView scoreTextView;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_see_review);
        courseReviewSQLDB = Services.getCourseReviewSQLDB(this);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);

        CourseReview courseReview = courseReviewSQLDB.getCourseReview(id);

        try{
            usernameTextView = (TextView) findViewById(R.id.username_3);
            scoreTextView = (TextView) findViewById(R.id.review_score_3);
            reviewTextView = (TextView) findViewById(R.id.review_string_3);

            usernameTextView.setText(courseReview.getUser());
            scoreTextView.setText(String.valueOf(courseReview.getScore()));
            reviewTextView.setText(courseReview.getReview());
        }
        catch (final Exception e){
            Messages.fatalError(this,e.getMessage());
        }


    }
}
