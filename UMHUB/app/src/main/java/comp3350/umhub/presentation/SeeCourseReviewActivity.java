package comp3350.umhub.presentation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessCourseReviews;
import comp3350.umhub.business.IAccessTutors;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.objects.TutorRating;
import comp3350.umhub.objects.User;
import comp3350.umhub.persistence.interfaces.ICourseReviewPersistence;

public class SeeCourseReviewActivity extends AppCompatActivity {

    IAccessCourseReviews accessCourseReviews;
    TextView rateCount;
    EditText showRating;
    Button submit;
    RatingBar ratingBar;
    float rateValue;
    User currentUser;
    private TextView textView;
    private TextView textView3;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratecourse);
        accessCourseReviews = Services.getAccessCourseReviews();

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        CourseReview courseReview = accessCourseReviews.getCourseReview(id);

        textView = findViewById(R.id.textView);
        textView3 = findViewById(R.id.textView3);
        rateCount = findViewById(R.id.rateCount);
        ratingBar = findViewById(R.id.ratingBar);
        submit = findViewById(R.id.submitBtn);
        showRating = findViewById(R.id.reviewEditText2);

        setTitle("Rate Tutor");
        try {
            textView.setText(String.format("Review Score"));
            ratingBar.setRating(courseReview.getScore());
            ratingBar.setIsIndicator(true);
            textView3.setText(String.format("User Review"));
            rateCount.setText(String.format("%1.1f/%1.1f", (float)courseReview.getScore(), 5f));
            showRating.setTextSize(22);
            showRating.setText(courseReview.getReview());
            showRating.setFocusable(false);
            submit.setVisibility(View.GONE);

        } catch (NullPointerException e) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Something went wrong. Could not locate Tutor entry", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            onBackPressed();
        }

    }
}
