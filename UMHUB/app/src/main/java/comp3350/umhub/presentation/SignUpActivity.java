package comp3350.umhub.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.application.SignUpException;
import comp3350.umhub.business.ILogin;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private ILogin iLogin;
    private EditText eName;                      /* A user interface for entering/modifying the text */
    private EditText ePassword;
    private Button eSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        iLogin = Services.getILogin(this);

        eName = findViewById(R.id.etUserName);
        ePassword = findViewById(R.id.etPassword);
        eSignUp = findViewById(R.id.btnSignUp);

        /* Handle the click on signUp button */
        eSignUp.setOnClickListener(this);
    }

    public String[] getInputValues(EditText name, EditText password) {
        String[] values = new String[2];

        values[0] = name.getText().toString();
        values[1] = password.getText().toString();

        return values;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignUp:
                //login has been clicked
                //setKeyboardVisibility(false);
                String[] inputValues = getInputValues(this.eName, this.ePassword);
                try {
                    iLogin.signUp(inputValues);
                    startActivity(new Intent(this, LoginActivity.class));
                } catch (SignUpException e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            e.getMessage(), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
                break;
        }
    }
}

