package comp3350.umhub.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;

public class CoursesActivity extends AppCompatActivity {
    private List<Course> courseList1;
    private List<Course> courseList2;
    private List<Course> courseList3;
    private List<Course> courseList4;
    private static Course courseSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        IAccessCourses accessCourses = Services.getAccessCourses();

        if(ProgramsActivity.getProgramSelected()==null){
            //button from programs
            Major majorSelected = MajorsActivity.getMajorSelected();


            courseList1 = accessCourses.getCoursesByYearMajor(majorSelected,1);
            courseList2 = accessCourses.getCoursesByYearMajor(majorSelected,2);
            courseList3 = accessCourses.getCoursesByYearMajor(majorSelected,3);
            courseList4 = accessCourses.getCoursesByYearMajor(majorSelected,4);
        }
        else {

            Program programSelected = ProgramsActivity.getProgramSelected();
            courseList1 = accessCourses.getCoursesByYearProgram(programSelected, 1);
            courseList2 = accessCourses.getCoursesByYearProgram(programSelected, 2);
            courseList3 = accessCourses.getCoursesByYearProgram(programSelected, 3);
            courseList4 = accessCourses.getCoursesByYearProgram(programSelected, 4);
        }
            try
            {


                if(courseList1.size()!=0){
                    ArrayAdapter<Course> firstYear = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_activated_1, android.R.id.text1, courseList1){
                        public View getView(int position, View convertView, ViewGroup parent) {

                            View view = super.getView(position, convertView, parent);

                            TextView text1 = (TextView) view.findViewById(android.R.id.text1);

                            text1.setText(courseList1.get(position).getId());
                            text1.setTextColor(Color.BLACK);

                            return view;

                        }
                    };

                    final ListView listView1 = (ListView) findViewById(R.id.firstyearcourses);
                    listView1.setAdapter(firstYear);

                    listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            courseSelected = courseList1.get(position);
                            Intent courseDescription = new Intent(CoursesActivity.this, CourseReviewsActivity.class);
                            startActivity(courseDescription);
                        }
                    });
                }

                if(courseList2.size()!=0){
                    ArrayAdapter<Course> secondYear = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_activated_1, android.R.id.text1, courseList2){
                        public View getView(int position, View convertView, ViewGroup parent) {

                            View view = super.getView(position, convertView, parent);

                            TextView text1 = (TextView) view.findViewById(android.R.id.text1);

                            text1.setText(courseList2.get(position).getId());
                            text1.setTextColor(Color.WHITE);

                            return view;

                        }
                    };

                    final ListView listView2 = (ListView) findViewById(R.id.secondyearcourses);
                    listView2.setAdapter(secondYear);

                    listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            courseSelected = courseList2.get(position);
                            Intent courseDescription = new Intent(CoursesActivity.this, CourseReviewsActivity.class);
                            startActivity(courseDescription);
                        }
                    });
                }

                if(courseList3.size()!=0){
                    ArrayAdapter<Course> thirdYear = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_activated_1, android.R.id.text1, courseList3){
                        public View getView(int position, View convertView, ViewGroup parent) {

                            View view = super.getView(position, convertView, parent);

                            TextView text1 = (TextView) view.findViewById(android.R.id.text1);

                            text1.setText(courseList3.get(position).getId());
                            text1.setTextColor(Color.BLACK);

                            return view;

                        }
                    };

                    final ListView listView3 = (ListView) findViewById(R.id.thirdyearcourses);
                    listView3.setAdapter(thirdYear);

                    listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            courseSelected = courseList3.get(position);
                            Intent courseDescription = new Intent(CoursesActivity.this, CourseReviewsActivity.class);
                            startActivity(courseDescription);
                        }
                    });
                }

                if(courseList4.size()!=0) {
                    ArrayAdapter<Course> fourthYear = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_activated_1, android.R.id.text1, courseList4) {
                        public View getView(int position, View convertView, ViewGroup parent) {

                            View view = super.getView(position, convertView, parent);

                            TextView text1 = (TextView) view.findViewById(android.R.id.text1);

                            text1.setText(courseList4.get(position).getId());
                            text1.setTextColor(Color.WHITE);

                            return view;

                        }
                    };

                    final ListView listView4 = (ListView) findViewById(R.id.fourthyearcourses);
                    listView4.setAdapter(fourthYear);

                    listView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            courseSelected = courseList4.get(position);
                            Intent courseDescription = new Intent(CoursesActivity.this, CourseReviewsActivity.class);
                            startActivity(courseDescription);
                        }
                    });
                }


            }
            catch (final NullPointerException e)
            {
                Messages.fatalError(this, e.getMessage());
            }




    }

    //DSO
    public static Course getCourseSelected(){
        return courseSelected;
    }


}


