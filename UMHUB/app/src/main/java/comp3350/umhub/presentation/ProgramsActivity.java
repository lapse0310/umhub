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
import comp3350.umhub.business.IAccessPrograms;
import comp3350.umhub.objects.Program;

public class ProgramsActivity extends AppCompatActivity {

    private List<Program> programList;
    private static Program programSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);

        IAccessPrograms accessProgram = Services.getAccessPrograms();

        try
        {
            programList = accessProgram.getPrograms();
            ArrayAdapter<Program> programArrayAdapter = new ArrayAdapter<Program>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, programList) {

                // If my major is 'Computer Science', display programs in it using AccessMajors
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {

                    View view = super.getView(position, convertView, parent);

                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);

                    text1.setText(programList.get(position).getName());

                    return view;

                }
            };

            final ListView listView = (ListView)findViewById(R.id.listPrograms);
            listView.setAdapter(programArrayAdapter);

            //CoursesActivity not implemented yet
//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    programSelected = programList.get(position);
//                    Intent programIntent = new Intent(ProgramsActivity.this, CouresActivity.class);
//                    startActivity(programIntent);
//                }
//            });

        }
        catch (final Exception e)
        {
            Messages.fatalError(this, e.getMessage());
        }

    }

    public static Program getProgramSelected() {
        return null;
    }
}

