package comp3350.umhub.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.application.UserException;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.objects.TutorEntry;
import comp3350.umhub.objects.User;
import comp3350.umhub.presentation.fragments.LoginFragment;
import comp3350.umhub.presentation.fragments.ReviewItemFragment;
import comp3350.umhub.presentation.fragments.TutorItemFragment;

public class CourseActivity extends AppCompatActivity {
    private Course courseSelected;
    private TextView courseName;
    private TextView courseDescription;
    private List<TutorEntry> tutors;
    private List<CourseReview> courseReviews;
    float avgRating;
    private Button tutorsButton;
    private Button writeReviewButton;
    private User currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_course_overview);
        courseSelected = CoursesActivity.getCourseSelected();
        setTitle(courseSelected.getId());

        courseName = (TextView) findViewById(R.id.courseName);
        courseName.setText(courseSelected.getName());

        courseDescription = (TextView) findViewById(R.id.courseDescription);
        courseDescription.setText(courseSelected.getDescription());

        avgRating = Services.getAccessCourseReviews().getAverageRating(courseSelected);
        TextView avgRatingText = findViewById(R.id.averageRating);
        avgRatingText.setText(String.format("%1.1f",avgRating));

        courseReviews = Services.getAccessCourseReviews().getCourseReviewByCourse(courseSelected);
        tutors = Services.getAccessTutors().getTutorEntriesByCourse(courseSelected);

        TextView seeReviews = findViewById(R.id.userReviewsText);
        TextView seeTutors = findViewById(R.id.tutorsText);
        seeReviews.setText(String.format("User Reviews (%d)", courseReviews.size()));
        seeTutors.setText(String.format("Tutors (%d)",tutors.size()));

        int review_frags[] = {R.id.review_item1,R.id.review_item2,R.id.review_item3};
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < courseReviews.size() && i < review_frags.length ; i++) {
            ReviewItemFragment reviewItem = ReviewItemFragment.newInstance(courseReviews.get(i));
            transaction.replace(review_frags[i],reviewItem);
        }
        transaction.commit();

        int tutor_frags[] = {R.id.tutor_item1,R.id.tutor_item2,R.id.tutor_item3};
        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < tutors.size() && i < tutor_frags.length ; i++) {
            TutorItemFragment tutorItem = TutorItemFragment.newInstance(tutors.get(i));
            transaction1.replace(tutor_frags[i],tutorItem);
        }
        transaction1.commit();

        tutorsButton = findViewById(R.id.all_tutors);
        tutorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AllTutorsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });


        writeReviewButton = findViewById(R.id.all_reviews);
        writeReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AllCourseReviewsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    public void buttonViewTutors(View view) {
//        if (!Services.getAccessTutors().getTutorEntriesByCourse(courseSelected).isEmpty()){
            Intent viewTutors = new Intent(CourseActivity.this, AllTutorsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            CourseActivity.this.startActivity(viewTutors);
//        }

    }

    /*        listView = (ListView) findViewById(R.id.reviewListView);
        listView.setEmptyView(findViewById(R.id.empty));
        ReviewAdapter adapter = new ReviewAdapter(this,courseReviewList);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {

                CourseReview c = (CourseReview) adapter.getItem(position);
                Intent modify_intent = new Intent(getApplicationContext(), SeeCourseReviewActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                modify_intent.putExtra("id", c.getId());
                startActivity(modify_intent);
            }
        });*/

    //        if (Services.getAccessTutors().getTutorEntriesByCourse(courseSelected).isEmpty()){
//            tutorsButton.setEnabled(false);
//            tutorsButton.setText("No Tutors Available for This Course");
//        }
//        else{
//            tutorsButton.setEnabled(true);
//            tutorsButton.setText("Tutors Are Available for This Course");
//        }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

