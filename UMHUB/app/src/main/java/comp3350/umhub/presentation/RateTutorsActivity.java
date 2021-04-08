package comp3350.umhub.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import comp3350.umhub.R;
import comp3350.umhub.objects.Tutor;

public class RateTutorsActivity extends AppCompatActivity {

    Tutor tutor = TutorsActivity.getTutorSelected(); //tutor currently being rated
    TextView rateCount, showRating;
    Button submit;
    RatingBar ratingBar;
    float rateValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratetutor);

        rateCount = findViewById(R.id.rateCount);
        ratingBar = findViewById(R.id.ratingBar);
        submit = findViewById(R.id.submitBtn);
        showRating = findViewById(R.id.showRating);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rateValue = ratingBar.getRating();
                if(rateValue<=1){
                    rateCount.setText("Bad tutor"+rateValue+"/5");
                }
                else if(rateValue<=2){
                    rateCount.setText("Okay tutor "+rateValue+"/5");
                }
                else if(rateValue<=3){
                    rateCount.setText("Average tutor "+rateValue+"/5");
                }
                else if(rateValue<=4){
                    rateCount.setText("Good tutor "+rateValue+"/5");
                }
                else if(rateValue<=5){
                    rateCount.setText("Excellent tutor "+rateValue+"/5");
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void buttonUpdateRating(View view){
        tutor.setRating(rateValue);
        showRating.setText("Tutor rating is now "+tutor.getRating());

    }

    public void buttonGoBack(View view){
        Intent tutorIntent = new Intent(RateTutorsActivity.this,TutorsActivity.class);
        RateTutorsActivity.this.startActivity(tutorIntent);
    }
}
