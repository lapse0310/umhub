package comp3350.umhub.presentation;

import android.annotation.SuppressLint;
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
import comp3350.umhub.application.UserException;
import comp3350.umhub.business.IAccessCourseReviews;
import comp3350.umhub.objects.User;

public class RateCourseActivity extends AppCompatActivity{
    IAccessCourseReviews accessCourseReviews;
    TextView rateCount;
    EditText editText;
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

        textView = findViewById(R.id.textView);
        textView3 = findViewById(R.id.textView3);
        rateCount = findViewById(R.id.rateCount);
        ratingBar = findViewById(R.id.ratingBar);
        submit = findViewById(R.id.submitBtn1);
        editText = findViewById(R.id.reviewEditText2);

        setTitle("Course Review");
        textView3.setText(String.format("User Review"));
        editText.setTextSize(22);
        textView.setText(String.format("How would you rate this course"));
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rateValue = ratingBar.getRating();
                if (rateValue <= 1) {
                    editText.setText("Awful course. Would not recommend >:(");
                } else if (rateValue <= 2) {
                    editText.setText("Meh course :|");
                } else if (rateValue <= 3) {
                    editText.setText("Course was alright :)");
                } else if (rateValue <= 4) {
                    editText.setText("Good Course. Would recommend it! ( ^.^ )");
                } else if (rateValue <= 5) {
//                    rateCount.setText("Excellent tutorEntry "+rateValue+"/5");
                    editText.setText("This course is awesome. 10/10 (\\ ˚▽˚ /)");
                }
                rateCount.setText(String.format("%1.1f/%1.1f", (float)rateValue, 5f));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    currentUser = Services.getCurrentUser();
                    String courseID = CoursesActivity.getCourseSelected().getId();
                    String userID = currentUser.getUsername();
                    String review = editText.getText().toString();
                    int score = (int) rateValue;
                    accessCourseReviews.add(courseID, userID, review, score);
                    System.out.println("--Success");
                    startActivity(new Intent(getApplicationContext(),AllCourseReviewsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                } catch (UserException e) {
                    e.printStackTrace();
                }
            }
        });

    }



}
