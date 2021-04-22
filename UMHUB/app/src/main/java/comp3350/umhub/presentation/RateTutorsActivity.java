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

import androidx.appcompat.app.AppCompatActivity;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.application.UserException;
import comp3350.umhub.business.IAccessTutors;
import comp3350.umhub.objects.TutorEntry;
import comp3350.umhub.objects.TutorRating;
import comp3350.umhub.objects.User;
import comp3350.umhub.presentation.fragments.LoginFragment;

public class RateTutorsActivity extends AppCompatActivity {

    TutorEntry tutorEntry = AllTutorsActivity.getTutorEntrySelected(); //tutorEntry currently being rated
    TextView rateCount;
    EditText showRating;
    Button submit;
    RatingBar ratingBar;
    float rateValue;

    IAccessTutors iAccessTutors;
    TutorRating tutorRating;
    User currentUser;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rateitem);
        textView = findViewById(R.id.textView);
        rateCount = findViewById(R.id.rateCount);
        ratingBar = findViewById(R.id.ratingBar);
        submit = findViewById(R.id.submitBtn1);
        showRating = findViewById(R.id.reviewEditText2);

        setTitle("Rate Tutor");
        try {
            textView.setText(String.format("How would you rate %s as a %s", tutorEntry.getName(), tutorEntry.getType()));

//            ratingBar.setClickable(false);
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

                @SuppressLint({"SetTextI18n", "DefaultLocale"})
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                    rateValue = ratingBar.getRating();
                    if (rateValue <= 1) {
                        showRating.setText("Awful Tutor >: (");
                    } else if (rateValue <= 2) {
                        showRating.setText("Meh Tutor : |");
                    } else if (rateValue <= 3) {
                        showRating.setText("Decent Tutor : )");
                    } else if (rateValue <= 4) {
                        showRating.setText("Good Tutor ( ^.^ )");
                    } else if (rateValue <= 5) {
//                    rateCount.setText("Excellent tutorEntry "+rateValue+"/5");
                        showRating.setText("Rob we know it's you in disguise (\\ ˚▽˚ /)");
                    }
                    rateCount.setText(String.format("%.1f/%.1f", rateValue, 5f));

                }
            });
        } catch (NullPointerException e) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Something went wrong. Could not locate Tutor entry", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            onBackPressed();
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    currentUser = Services.getCurrentUser();
                    iAccessTutors = Services.getAccessTutors();
                    tutorRating = iAccessTutors.getTutorRatingsByUser(tutorEntry, currentUser);
                    if (tutorRating != null) {
                        tutorRating.setRating(rateValue);
                        iAccessTutors.updateTutorRating(tutorRating);
                    } else {
                        iAccessTutors.addTutorRating(tutorEntry, currentUser, rateValue);
                    }
                    Toast toast = Toast.makeText(getApplicationContext(),"Thank you for your feedback", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                    startActivity(new Intent(RateTutorsActivity.this, AllTutorsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

                } catch (UserException e) {
                    LoginFragment loginFragment = new LoginFragment();
                    loginFragment.show(getSupportFragmentManager(),"LoginFragment");
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void buttonUpdateRating(View view) {


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void buttonGoBack(View view) {
        Intent tutorIntent = new Intent(RateTutorsActivity.this, AllTutorsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        RateTutorsActivity.this.startActivity(tutorIntent);
    }


}
