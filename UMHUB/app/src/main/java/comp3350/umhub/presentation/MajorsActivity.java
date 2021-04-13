package comp3350.umhub.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessMajors;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.User;
import comp3350.umhub.presentation.adapters.MajorAdapter;


public class MajorsActivity extends AppCompatActivity {
    private ListView listView;
    private List<Major> majorList;
    private static Major majorSelected;
    private IAccessMajors accessMajors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_emp_list);

        User user = Services.getCurrentUser();
        if (user != null)
            setTitle("Welcome " + user.getUsername());
        else
            setTitle("Welcome, Guest");


        try
        {
            accessMajors = Services.getAccessMajors(this);
            majorList = accessMajors.getAllMajors();

            listView = (ListView) findViewById(R.id.list_view);
            listView.setEmptyView(findViewById(R.id.empty));
            MajorAdapter adapter = new MajorAdapter(this, majorList);
            adapter.notifyDataSetChanged();
            listView.setAdapter(adapter);

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

    @Override
    public void onBackPressed() {
        LogOut();
    }

    public void LogOut(){
        Services.logOut();
        String display = "Logged out successfully. See you again soon!";
        if (Services.getCurrentUser() != null){
            display = "Something went wrong.";
        }
        System.out.println(display);
        Toast.makeText(getApplicationContext(),display,Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    }
}