package comp3350.umhub.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessCourseReviews;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;

public class CourseReviewsActivity extends Activity {
    private Course course;
    private List<CourseReview> courseReviewList;
    private static CourseReview courseReviewSelected;

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

            final ListView listView = (ListView) findViewById(R.id.listReviews);
            listView.setAdapter(courseReviewArrayAdapter);
        }
        catch (final Exception e){
            Messages.fatalError(this,e.getMessage());
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void buttonAllCourseReviewsOnClick(View view){
        Intent courseReviewIntent = new Intent(CourseReviewsActivity.this, null);
        CourseReviewsActivity.this.startActivity(courseReviewIntent);
    }
}
