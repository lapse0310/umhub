package comp3350.umhub.presentation;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
    private List<CourseReview> courseReviewList;

    private TextView courseName;
    private TextView courseDescription;
    private ListView reviewListView;

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void buttonWriteCourseReviewOnClick(View view){
        Intent WriteCourseReviewIntent = new Intent(CourseReviewsActivity.this, WriteCourseReviewActivity.class);
        CourseReviewsActivity.this.startActivity(WriteCourseReviewIntent);
    }

    private CourseReviewSQLDB courseReviewSQLDB;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[] {CourseReviewSQLDB.SCORE,CourseReviewSQLDB.USERID,CourseReviewSQLDB.REVIEW};

    final int[] to = new int[] {R.id.review_score, R.id.username, R.id.review};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_emp_list);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        courseReviewSQLDB = Services.getCourseReviewSQLDB(this);
        //courseReviewSQLDB = new CourseReviewSQLDB(this);
        Cursor cursor = courseReviewSQLDB.fetch();

        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView reviewScoreTextView = (TextView) view.findViewById(R.id.review_score);
                TextView usernameTextView = (TextView) view.findViewById(R.id.username);
                TextView reviewTextView = (TextView) view.findViewById(R.id.review);

                String id = reviewScoreTextView.getText().toString();
                String title = usernameTextView.getText().toString();
                String desc = reviewTextView.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), WriteCourseReviewActivity.class);
                modify_intent.putExtra("username", title);
                modify_intent.putExtra("review", desc);
                modify_intent.putExtra("id", id);
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

            Intent add_mem = new Intent(this, WriteCourseReviewActivity.class);
            add_mem.putExtra("courseID",CoursesActivity.getCourseSelected().getId());
            startActivity(add_mem);

        }
        return super.onOptionsItemSelected(item);
    }
}
