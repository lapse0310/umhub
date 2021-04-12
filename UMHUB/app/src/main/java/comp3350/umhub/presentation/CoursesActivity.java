package comp3350.umhub.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessCourses;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.sqlite.CourseSQLDB;
import comp3350.umhub.presentation.adapters.CourseAdapter;

public class CoursesActivity extends AppCompatActivity {
    private CourseSQLDB coursesSQLDB;
    private ListView listView;
    private List<Course> courseList;
    private IAccessCourses accessCourses;
    private static Course courseSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_emp_list);

        accessCourses = Services.getAccessCourses(this);
        Program program = ProgramsActivity.getProgramSelected();
        if (program== null)
            courseList = accessCourses.getAllCourses();
        else
            courseList = accessCourses.getCoursesByProgram(program);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));
        CourseAdapter adapter = new CourseAdapter(this, courseList);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                setCourseSelected(courseList.get(position));
                Intent modify_intent = new Intent(getApplicationContext(), CourseReviewsActivity.class);
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

            Intent add_mem = new Intent(this, CourseReviewsActivity.class);
            startActivity(add_mem);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        ProgramsActivity.setProgramSelected(null);
        super.onBackPressed();
    }

    public static Course getCourseSelected() {
        return courseSelected;
    }

    public static void setCourseSelected(Course courseSelected) {
        CoursesActivity.courseSelected = courseSelected;
    }
}
