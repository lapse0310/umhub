package comp3350.umhub.presentation;

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

    private TextView courseName;
    private TextView courseDescription;
    private ListView reviewListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_coursereview_overview);
        IAccessCourseReviews accessCourseReviews = Services.getAccessCourseReviews();

        course = CoursesActivity.getCourseSelected();

        System.out.println(course);

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


            courseName = (TextView) findViewById(R.id.courseName);
            courseName.setText(course.getName());

            courseDescription = (TextView) findViewById(R.id.courseDescription);
            courseDescription.setText(course.getDescription());

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
