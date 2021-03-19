package comp3350.umhub.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessCourses;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Program;

public class CoursesActivity extends AppCompatActivity {

    private List<Course> courseList;
    private static Course courseSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        IAccessCourses accessCourses = Services.getAccessCourses();

        try
        {
            Program programSelected = ProgramsActivity.getProgramSelected();
            courseList = accessCourses.getCourses(programSelected);
            System.out.println(courseList.get(0).getName());
            ArrayAdapter<Course> courseArrayAdapter = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, courseList) {


                @Override
                public View getView(int position, View convertView, ViewGroup parent) {

                    View view = super.getView(position, convertView, parent);

                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                    TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                    text1.setText(courseList.get(position).getId());
                    text2.setText(courseList.get(position).getName());


                    return view;

                }
            };

            final ListView listView = (ListView)findViewById(R.id.listCourses);
            listView.setAdapter(courseArrayAdapter);




        }
        catch (final Exception e)
        {
            Messages.fatalError(this, e.getMessage());
        }

    }

    //DSO
    public static Course getCourseSelected(){
        return courseSelected;
    }



}

