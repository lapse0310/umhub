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
import comp3350.umhub.business.IAccessMajors;
import comp3350.umhub.objects.Major;
import comp3350.umhub.presentation.adapters.MajorAdapter;


public class MajorsActivity extends AppCompatActivity {
    private ListView listView;
    private List<Major> majorList;
    private static Major majorSelected;
    private IAccessMajors accessMajors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_majors);
        setContentView(R.layout.fragment_emp_list);

        try
        {
            accessMajors = Services.getAccessMajors(this);
            majorList = accessMajors.getAllMajors();

            listView = (ListView) findViewById(R.id.list_view);
            listView.setEmptyView(findViewById(R.id.empty));
            MajorAdapter adapter = new MajorAdapter(this, majorList);
            adapter.notifyDataSetChanged();
            listView.setAdapter(adapter);

/*            ArrayAdapter<Major> majorArrayAdapter = new ArrayAdapter<Major>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, majorList) {

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);

                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                    text1.setText(majorList.get(position).getName());
                    text1.setTextColor(Color.BLACK);

                    return view;
                }
            };

            final ListView listView = (ListView)findViewById(R.id.listMajors);
            listView.setAdapter(majorArrayAdapter);*/

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                    majorSelected = majorList.get(position);
                    Intent modify_intent = new Intent(getApplicationContext(), ProgramsActivity.class);

                    startActivity(modify_intent);
                }
            });

        }
        catch (final NullPointerException e)
        {
            Messages.fatalError(this, e.getMessage());
        }

    }

    public static Major getMajorSelected() {
        return majorSelected;
    }

    public static void setMajorSelected(Major majorSelected) {
        MajorsActivity.majorSelected = majorSelected;
    }
}