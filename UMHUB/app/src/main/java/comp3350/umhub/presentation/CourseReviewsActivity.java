package comp3350.umhub.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessCourseReviews;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;

public class CourseReviewsActivity extends AppCompatActivity {
    private Course course;
    private List<CourseReview> courseReviewList;
    private static CourseReview courseReviewSelected;

    private TextView courseName;
    private TextView courseDescription;
    private ListView reviewListView;
    private Button writeReviewButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_coursereview_overview);
        IAccessCourseReviews accessCourseReviews = Services.getAccessCourseReviews();

        /*Technical debt - needs fixing */
        course = Services.getAccessCourses().getCourse("comp3350");

        try{
            courseReviewList = accessCourseReviews.getCourseReviews(course);
            ArrayAdapter<CourseReview> courseReviewArrayAdapter = new ArrayAdapter<CourseReview>(this, android.R.layout.simple_list_item_activated_2,android.R.id.text1,courseReviewList) {

                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);

                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);

                    text1.setText(courseReviewList.get(position).getReview());
                    return view;
                }
            };

            reviewListView = (ListView) findViewById(R.id.reviewListView);
            reviewListView.setAdapter(courseReviewArrayAdapter);

//            courseName.setText(course.getName());
//            courseDescription.setText(course.getDescription());

            courseName = (TextView) findViewById(R.id.courseName);
            courseName.setText("TEST NAME");

            courseDescription = (TextView) findViewById(R.id.courseDescription);
            courseDescription.setText("LOREM IPSUM");


        }
        catch (final Exception e){
            Messages.fatalError(this,e.getMessage());
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void buttonWriteCourseReviewOnClick(View view){
        Intent WriteCourseReviewIntent = new Intent(CourseReviewsActivity.this, WriteCourseReviewActivity.class);
        CourseReviewsActivity.this.startActivity(WriteCourseReviewIntent);
    }
}
