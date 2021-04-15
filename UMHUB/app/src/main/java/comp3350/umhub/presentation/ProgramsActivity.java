package comp3350.umhub.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessPrograms;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.presentation.adapters.ProgramAdapter;

public class ProgramsActivity extends AppCompatActivity {

    private IAccessPrograms iAccessPrograms;
    private ListView listView;
    private List<Program> programList;
    private static Program programSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_emp_list);

        iAccessPrograms = Services.getAccessPrograms();
        Major major = MajorsActivity.getMajorSelected();
        if (major== null)
            programList = iAccessPrograms.getAllPrograms();
        else
            programList = iAccessPrograms.getProgramsByMajor(major);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));
        ProgramAdapter adapter = new ProgramAdapter(this, programList);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                programSelected = programList.get(position);
                Intent modify_intent = new Intent(getApplicationContext(), CoursesActivity.class);
                startActivity(modify_intent);

            }
        });
    }
    
    public void buttonCoursesOnClick(View view) {
        Intent majorsIntent = new Intent(ProgramsActivity.this, CoursesActivity.class);
        ProgramsActivity.this.startActivity(majorsIntent);
    }

    //DSO
    public static Program getProgramSelected(){
        return programSelected;
    }

    public static void setProgramSelected(Program programSelected) {
        ProgramsActivity.programSelected = programSelected;
    }

    @Override
    public void onBackPressed() {
        MajorsActivity.setMajorSelected(null);
        super.onBackPressed();
    }


}

