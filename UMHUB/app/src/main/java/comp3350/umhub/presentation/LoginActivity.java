package comp3350.umhub.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import javax.security.auth.login.LoginException;

import comp3350.umhub.application.Services;

import comp3350.umhub.R;
import comp3350.umhub.application.SignUpException;
import comp3350.umhub.business.ILogin;

public class LoginActivity extends AppCompatActivity {

    private ILogin iLogin;
    private EditText eName;                      /* A user interface for entering/modifying the text */
    private EditText ePassword;
    private Button eLogin;
    private Button eSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        iLogin = Services.getILogin();

        eName = findViewById(R.id.etUserName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);
        eSignUp = findViewById(R.id.btnSignUp);

        /* Handle the click on login button */
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    String username = eName.getText().toString();
                    String password = ePassword.getText().toString();
                    iLogin.login(username,password);
                    String previous = getIntent().getStringExtra("previous");
                    if (previous != null){
                        if (previous.equals(CourseActivity.class.toString()))
                            startActivity(new Intent(getApplicationContext(), CourseActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    }
                    else
                        startActivity(new Intent(getApplicationContext(), MajorsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

                }
                catch(LoginException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Please enter valid credentials!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            }
        });
        eSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String username = eName.getText().toString();
                    String password = ePassword.getText().toString();
                    iLogin.signUp(username,password);
                    Toast toast = Toast.makeText(getApplicationContext(),"New user successfully created! Now you can log in using the credentials", Toast.LENGTH_SHORT);
                    toast.show();
                } catch (SignUpException e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            e.getMessage(), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            }
        });
    }

    protected void onDestroy(){
        super.onDestroy();
    }

}
