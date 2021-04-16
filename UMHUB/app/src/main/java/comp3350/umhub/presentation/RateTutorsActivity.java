package comp3350.umhub.presentation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.application.UserException;
import comp3350.umhub.business.IAccessTutors;
import comp3350.umhub.objects.TutorEntry;
import comp3350.umhub.objects.TutorRating;
import comp3350.umhub.objects.User;

public class RateTutorsActivity extends AppCompatActivity {

    TutorEntry tutorEntry = TutorsActivity.getTutorEntrySelected(); //tutorEntry currently being rated
    TextView rateCount, showRating;
    Button submit;
    RatingBar ratingBar;
    float rateValue;

    IAccessTutors iAccessTutors;
    TutorRating tutorRating;
    User currentUser;

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
                    rateCount.setText("Bad tutorEntry"+rateValue+"/5");
                }
                else if(rateValue<=2){
                    rateCount.setText("Okay tutorEntry "+rateValue+"/5");
                }
                else if(rateValue<=3){
                    rateCount.setText("Average tutorEntry "+rateValue+"/5");
                }
                else if(rateValue<=4){
                    rateCount.setText("Good tutorEntry "+rateValue+"/5");
                }
                else if(rateValue<=5){
                    rateCount.setText("Excellent tutorEntry "+rateValue+"/5");
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void buttonUpdateRating(View view){
        try{
            currentUser = Services.getCurrentUser();
            iAccessTutors = Services.getAccessTutors();
            tutorRating = iAccessTutors.getTutorRatingsByUser(tutorEntry,currentUser);
            if (tutorRating != null){
                tutorRating.setRating(rateValue);
                iAccessTutors.updateTutorRating(tutorRating);
            }
            else{
                iAccessTutors.addTutorRating(tutorEntry,currentUser,rateValue);
            }
//            tutorEntry.setRating(rateValue);
            float avgRating = iAccessTutors.getAverageRating(tutorEntry);
            showRating.setText("TutorEntry rating is now "+ avgRating);
        } catch (UserException e) {
            e.printStackTrace();
        }


    }

    public void buttonGoBack(View view){
        Intent tutorIntent = new Intent(RateTutorsActivity.this,TutorsActivity.class);
        RateTutorsActivity.this.startActivity(tutorIntent);
    }
}
