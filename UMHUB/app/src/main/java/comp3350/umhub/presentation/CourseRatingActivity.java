package comp3350.umhub.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessCourseReviews;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.objects.User;

public class CourseRatingActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_rateitem);
        accessCourseReviews = Services.getAccessCourseReviews();

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        CourseReview courseReview = accessCourseReviews.getCourseReview(id);

        textView = findViewById(R.id.textView);
        textView3 = findViewById(R.id.textView3);
        rateCount = findViewById(R.id.rateCount);
        ratingBar = findViewById(R.id.ratingBar);
        submit = findViewById(R.id.submitBtn1);
        showRating = findViewById(R.id.reviewEditText2);

        setTitle("Course Review");
        textView.setText(String.format("Review Score"));
        ratingBar.setRating(courseReview.getScore());
        ratingBar.setIsIndicator(true);
        textView3.setText(String.format("User Review"));
        rateCount.setText(String.format("%1.1f/%1.1f", (float)courseReview.getScore(), 5f));
        showRating.setText(courseReview.getReview());
        showRating.setFocusable(false);
        submit.setVisibility(View.GONE);
    }
}
