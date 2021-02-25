package comp3350.umhub.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import comp3350.umhub.R;
import comp3350.umhub.objects.Program;

public class ProgramsActivity extends AppCompatActivity {

    public static Program getProgramSelected() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);
    }
}