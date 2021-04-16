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
import comp3350.umhub.business.IAccessTutors;
import comp3350.umhub.objects.TutorEntry;
import comp3350.umhub.presentation.adapters.ProgramAdapter;
import comp3350.umhub.presentation.adapters.TutorAdapter;

public class TutorsActivity extends AppCompatActivity {
    private List<TutorEntry> tutorEntryList;
    private static TutorEntry tutorEntrySelected = null;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tutors);
        setContentView(R.layout.fragment_emp_list);

        IAccessTutors accessTutors = Services.getAccessTutors();
        try{
            tutorEntryList = accessTutors.getTutorEntriesByCourse(CoursesActivity.getCourseSelected());

            listView = (ListView) findViewById(R.id.list_view);
//            listView.setEmptyView(findViewById(R.id.empty));
            TutorAdapter adapter = new TutorAdapter(this, tutorEntryList);
            adapter.notifyDataSetChanged();
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                    tutorEntrySelected = tutorEntryList.get(position);
                    Intent modify_intent = new Intent(getApplicationContext(), RateTutorsActivity.class);
                    startActivity(modify_intent);

                }
            });
//
//            tutorEntryList = accessTutors.getTutorEntriesByCourse(CoursesActivity.getCourseSelected());
//            ArrayAdapter<TutorEntry> tutorArrayAdapter = new ArrayAdapter<TutorEntry>(this,android.R.layout.simple_list_item_activated_2,android.R.id.text1, tutorEntryList){
//                @Override
//                public View getView(int position, View convertView, ViewGroup parent) {
//                    View view = super.getView(position, convertView, parent);
//
//                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
//                    TextView text2 = (TextView) view.findViewById(android.R.id.text2);
//
//                    TutorEntry entry =  tutorEntryList.get(position);
//                    String text1_str = String.format("%s, %s",entry.getName(),entry.getType());
//                    String text2_str = String.format("Contact: %s, Rating %f",entry.getEmail(),accessTutors.getAverageRating(entry));
//                    text1.setText(text1_str);
//                    text2.setText(text2_str);
////                    text1.setText(tutorEntryList.get(position).displayName());
////                    text2.setText(tutorEntryList.get(position).displaySub());
//                    return view;
//                }
//            };
//            final ListView listView = (ListView)findViewById(R.id.listTutors);
//            listView.setAdapter(tutorArrayAdapter);
//
//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    tutorEntrySelected = tutorEntryList.get(position);
//                    Intent courseIntent = new Intent(TutorsActivity.this, RateTutorsActivity.class);
//                    startActivity(courseIntent);
//                }
//            });
        }
        catch (final NullPointerException e){
            Messages.fatalError(this,e.getMessage());
        }

    }

    public void buttonGoBack(View view){
        Intent coursesIntent = new Intent(TutorsActivity.this, CoursesActivity.class);
        TutorsActivity.this.startActivity(coursesIntent);
    }

    public static TutorEntry getTutorEntrySelected(){
        return tutorEntrySelected;
    }
}
