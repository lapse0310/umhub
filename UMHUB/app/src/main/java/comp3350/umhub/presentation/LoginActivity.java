package comp3350.umhub.presentation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import comp3350.umhub.business.Login;

import comp3350.umhub.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText eName;                      /* A user interface for entering/modifying the text */
    private EditText ePassword;
    private Button eLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eName = findViewById(R.id.etUserName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);

        /* Handle the click on login button */
        eLogin.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setKeyboardVisibility(boolean show) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if(show){
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }else{
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onClick(View view) {

        switch ( view.getId() ){
            case R.id.btnLogin:
                //login has been clicked
                setKeyboardVisibility(false);
                String[] inputValues = getInputValues(this.eName,this.ePassword);
                try{
                    Login login = new Login(inputValues);
                    startActivity(new Intent(this , HomeActivity.class));
                }catch(Login.LoginException e){
                    Toast toast= Toast.makeText(getApplicationContext(),
                            "Please enter valid credentials!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP| Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
                break;
        }

    }

    public String[] getInputValues(EditText email,EditText password){
        String[] values = new String[2];

        values[0] = email.getText().toString();
        values[1] = password.getText().toString();

        return values;
    }

    protected void onDestroy(){
        super.onDestroy();
    }
}
