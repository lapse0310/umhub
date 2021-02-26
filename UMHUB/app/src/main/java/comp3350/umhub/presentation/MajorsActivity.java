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
import comp3350.umhub.business.IAccessMajors;
import comp3350.umhub.objects.Major;


public class MajorsActivity extends AppCompatActivity {
    private List<Major> majorList;
    private static Major majorSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_majors);

        IAccessMajors accessMajors = Services.getAccessMajors();

        try
        {
            majorList = accessMajors.getMajors();
            ArrayAdapter<Major> majorArrayAdapter = new ArrayAdapter<Major>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, majorList) {

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);

                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);

                    text1.setText(majorList.get(position).getName());

                    return view;
                }
            };

            final ListView listView = (ListView)findViewById(R.id.listMajors);
            listView.setAdapter(majorArrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    majorSelected = majorList.get(position);
                    Intent programIntent = new Intent(MajorsActivity.this, ProgramsActivity.class);
                    startActivity(programIntent);
                }
            });

        }
        catch (final Exception e)
        {
            Messages.fatalError(this, e.getMessage());
        }

    }

    //DSO
    public static Major getMajorSelected(){
        return majorSelected;
    }
}