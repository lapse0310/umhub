package comp3350.umhub.presentation;

import comp3350.umhub.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    protected void onDestroy(){
        super.onDestroy();
    }


    public void buttonMajorsOnClick(View view) {
        Intent majorsIntent = new Intent(HomeActivity.this, MajorsActivity.class);
        HomeActivity.this.startActivity(majorsIntent);
    }
}
