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
import comp3350.umhub.business.IAccessTutors;
import comp3350.umhub.objects.Tutor;

public class TutorsActivity extends AppCompatActivity {
    private List<Tutor> tutorList;
    private static Tutor tutorSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutors);

        IAccessTutors accessTutors = Services.getAccessTutors();
        try{
            tutorList = accessTutors.getTutors(CoursesActivity.getCourseSelected());
            System.out.println(tutorList.size());
            ArrayAdapter<Tutor> tutorArrayAdapter = new ArrayAdapter<Tutor>(this,android.R.layout.simple_list_item_activated_2,android.R.id.text1,tutorList){

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);

                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                    TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                    text1.setText(tutorList.get(position).displayName());
                    text2.setText(tutorList.get(position).displaySub());

                    return view;
                }
            };
            final ListView listView = (ListView)findViewById(R.id.listTutors);
            listView.setAdapter(tutorArrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    tutorSelected = tutorList.get(position);
                    Intent courseIntent = new Intent(TutorsActivity.this, RateTutorsActivity.class);
                    startActivity(courseIntent);
                }
            });
        }
        catch (final NullPointerException e){
            Messages.fatalError(this,e.getMessage());
        }

    }

    public void buttonGoBack(View view){
        Intent coursesIntent = new Intent(TutorsActivity.this, CoursesActivity.class);
        TutorsActivity.this.startActivity(coursesIntent);
    }

    public static Tutor getTutorSelected(){
        return tutorSelected;
    }
}
