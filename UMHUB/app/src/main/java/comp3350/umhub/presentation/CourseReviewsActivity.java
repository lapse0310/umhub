package comp3350.umhub.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
import comp3350.umhub.presentation.adapters.ReviewAdapter;

public class CourseReviewsActivity extends AppCompatActivity {
    private Course courseSelected;
    private TextView courseName;
    private TextView courseDescription;

    private ListView listView;
    private IAccessCourseReviews accessCourseReviews;
    private List<CourseReview> courseReviewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.overview_2);
        courseSelected = CoursesActivity.getCourseSelected();
        setTitle(courseSelected.getId());

        courseName = (TextView) findViewById(R.id.courseName);
        courseName.setText(courseSelected.getName());

        courseDescription = (TextView) findViewById(R.id.courseDescription);
        courseDescription.setText(courseSelected.getDescription());

//        setContentView(R.layout.fragment_emp_list);

        accessCourseReviews = Services.getAccessCourseReviews();
        courseReviewList = accessCourseReviews.getCourseReviewByCourse(courseSelected);

//        listView = (ListView) findViewById(R.id.list_view);
//        listView.setEmptyView(findViewById(R.id.empty));

        int itemLimit = 3;

        listView = (ListView) findViewById(R.id.reviewListView);
        listView.setEmptyView(findViewById(R.id.empty));
        ReviewAdapter adapter = new ReviewAdapter(this,courseReviewList);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {

                //CourseReview c = courseReviewList.get(position);
                CourseReview c = (CourseReview) adapter.getItem(position);
                Intent modify_intent = new Intent(getApplicationContext(), SeeCourseReviewActivity.class);
                modify_intent.putExtra("id", c.getId());
                startActivity(modify_intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.add_record) {

            try {
                Services.getCurrentUser();
                courseSelected = CoursesActivity.getCourseSelected();
                Intent add_mem = new Intent(this, WriteCourseReviewActivity.class);
                add_mem.putExtra("courseID", CoursesActivity.getCourseSelected().getId());
                startActivity(add_mem);
            } catch (UserException e) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Please log in to leave a review",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();            }


        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void buttonWriteCourseReviewOnClick(View view) {
        Intent WriteCourseReviewIntent = new Intent(CourseReviewsActivity.this, WriteCourseReviewActivity.class);
        CourseReviewsActivity.this.startActivity(WriteCourseReviewIntent);
    }

    public void buttonViewTutors(View view) {
        Intent viewTutors = new Intent(CourseReviewsActivity.this, TutorsActivity.class);
        CourseReviewsActivity.this.startActivity(viewTutors);
    }
}

