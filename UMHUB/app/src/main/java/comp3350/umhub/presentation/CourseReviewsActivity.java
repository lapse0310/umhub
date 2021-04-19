package comp3350.umhub.presentation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.application.UserException;
import comp3350.umhub.business.IAccessCourseReviews;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.objects.User;
import comp3350.umhub.presentation.adapters.ReviewAdapter;

public class CourseReviewsActivity extends AppCompatActivity {
    private Course courseSelected;
    private TextView courseName;
    private TextView courseDescription;

    private ListView listView;
    private IAccessCourseReviews accessCourseReviews;
    private List<CourseReview> courseReviewList;
    private Button tutorsButton;
    private Button writeReviewButton;
    private User currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_coursereview_overview);
        courseSelected = CoursesActivity.getCourseSelected();
        setTitle(courseSelected.getId());

        courseName = (TextView) findViewById(R.id.courseName);
        courseName.setText(courseSelected.getName());

        courseDescription = (TextView) findViewById(R.id.courseDescription);
        courseDescription.setText(courseSelected.getDescription());

        accessCourseReviews = Services.getAccessCourseReviews();
        courseReviewList = accessCourseReviews.getCourseReviewByCourse(courseSelected);

        listView = (ListView) findViewById(R.id.reviewListView);
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
        });

        tutorsButton = findViewById(R.id.viewTutors);
        if (Services.getAccessTutors().getTutorEntriesByCourse(courseSelected).isEmpty()){
            tutorsButton.setEnabled(false);
            tutorsButton.setText("No Tutors Available for This Course");
        }
        else{
            tutorsButton.setEnabled(true);
            tutorsButton.setText("Tutors Are Available for This Course");
        }

        writeReviewButton = findViewById(R.id.writeReviewButton);
        try{
            currentUser = Services.getCurrentUser();
            writeReviewButton.setText("Write A Review");
            writeReviewButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent add_mem = new Intent(CourseReviewsActivity.this, WriteCourseReviewActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    add_mem.putExtra("previous",CourseReviewsActivity.class.toString());
                    startActivity(add_mem);
                }
            });
        }catch (UserException e){
            writeReviewButton.setText("Log In To Write A Review");
            writeReviewButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent add_mem = new Intent(CourseReviewsActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    add_mem.putExtra("previous",CourseReviewsActivity.class.toString());
                    startActivity(add_mem);
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    public void buttonViewTutors(View view) {
//        if (!Services.getAccessTutors().getTutorEntriesByCourse(courseSelected).isEmpty()){
            Intent viewTutors = new Intent(CourseReviewsActivity.this, TutorsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            CourseReviewsActivity.this.startActivity(viewTutors);
//        }

    }


}

