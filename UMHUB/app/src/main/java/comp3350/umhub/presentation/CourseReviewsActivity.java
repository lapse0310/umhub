package comp3350.umhub.presentation;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.persistence.sqlite.CourseReviewSQLDB;

public class CourseReviewsActivity extends AppCompatActivity {
    private Course course;
    private TextView courseName;
    private TextView courseDescription;
    private ListView listView;
    private CourseReviewSQLDB courseReviewSQLDB;
    private List<CourseReview> courseReviewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_coursereview_overview);

        courseReviewSQLDB = Services.getCourseReviewSQLDB(this);
        courseReviewList = courseReviewSQLDB.getCourseReviewsSequential(CoursesActivity.getCourseSelected().getId());

        courseName = (TextView) findViewById(R.id.courseName);
        courseName.setText(CoursesActivity.getCourseSelected().getName());

        courseDescription = (TextView) findViewById(R.id.courseDescription);
        courseDescription.setText(CoursesActivity.getCourseSelected().getDescription());

        listView = (ListView) findViewById(R.id.reviewListView);
        listView.setEmptyView(findViewById(R.id.empty));

        ReviewAdapter adapter = new ReviewAdapter(this,courseReviewList);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
/*                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView titleTextView = (TextView) view.findViewById(R.id.title);
                TextView descTextView = (TextView) view.findViewById(R.id.desc);

                String id = idTextView.getText().toString();
                String title = titleTextView.getText().toString();
                String desc = descTextView.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), ModifyCourseReviewActivity.class);
                modify_intent.putExtra("title", title);
                modify_intent.putExtra("desc", desc);
                modify_intent.putExtra("id", id);

                startActivity(modify_intent);*/
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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

            Intent add_mem = new Intent(this, WriteCourseReviewActivity.class);
            add_mem.putExtra("courseID",CoursesActivity.getCourseSelected().getId());
            startActivity(add_mem);

        }
        return super.onOptionsItemSelected(item);
    }

    public void buttonWriteCourseReviewOnClick(View view){
        Intent WriteCourseReviewIntent = new Intent(CourseReviewsActivity.this, WriteCourseReviewActivity.class);
        CourseReviewsActivity.this.startActivity(WriteCourseReviewIntent);
    }




    /*    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_coursereview_overview);
        IAccessCourseReviews accessCourseReviews = Services.getAccessCourseReviews();

        course = CoursesActivity.getCourseSelected();

        System.out.println(course);

        try{
            courseReviewList = accessCourseReviews.getCourseReviews(course);
           ArrayAdapter<CourseReview> courseReviewArrayAdapter = new ArrayAdapter<CourseReview>(this, android.R.layout.simple_selectable_list_item,android.R.id.text1,courseReviewList) {

                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);

                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);

                    text1.setText(courseReviewList.get(position).getReview());
                    return view;
                }
            };

            ReviewAdapter courseReviewArrayAdapter = new ReviewAdapter(this,courseReviewList);

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


    }*/
}
