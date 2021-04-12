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
import comp3350.umhub.business.IAccessPrograms;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.presentation.adapters.ProgramAdapter;

public class ProgramsActivity extends AppCompatActivity {

    private IAccessPrograms accessPrograms;
    private ListView listView;
    private List<Program> programList;
    private static Program programSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_emp_list);

        accessPrograms = Services.getAccessPrograms(this);
        Major major = MajorsActivity.getMajorSelected();
        if (major== null) programList = accessPrograms.getAllPrograms();
        else  programList = accessPrograms.getProgramsByMajor(major);

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

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);

        IAccessPrograms accessProgram = Services.getAccessPrograms();

        try
        {
            Major majorSelected = MajorsActivity.getMajorSelected();
            programList = accessProgram.getPrograms(majorSelected);
            ArrayAdapter<Program> programArrayAdapter = new ArrayAdapter<Program>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, programList) {

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {

                    View view = super.getView(position, convertView, parent);

                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);

                    text1.setText(programList.get(position).getName());
                    text1.setTextColor(Color.BLACK);

                    return view;

                }
            };

            final ListView listView = (ListView)findViewById(R.id.listPrograms);
            listView.setAdapter(programArrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    programSelected = programList.get(position);
                    Intent courseIntent = new Intent(ProgramsActivity.this, CoursesActivity.class);
                    startActivity(courseIntent);
                }
            });


        }
        catch (final NullPointerException e)
        {
            Messages.fatalError(this, e.getMessage());
        }

    }
*/

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

}

