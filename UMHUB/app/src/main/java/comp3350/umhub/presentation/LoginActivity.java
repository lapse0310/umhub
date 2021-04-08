package comp3350.umhub.presentation;

//import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.security.auth.login.LoginException;

import comp3350.umhub.application.Main;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.Login;

import comp3350.umhub.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText eName;                      /* A user interface for entering/modifying the text */
    private EditText ePassword;
    private Button eLogin;
    private Button eSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        copyDatabaseToDevice();


        eName = findViewById(R.id.etUserName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);
        eSignUp = findViewById(R.id.btnSignUp);

        /* Handle the click on login button */
        eLogin.setOnClickListener(this);
        eSignUp.setOnClickListener(this);
    }



    //@RequiresApi(api = Build.VERSION_CODES.M)
    /*public void setKeyboardVisibility(boolean show) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if(show){
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }else{
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        }
    }*/

    //@RequiresApi(api = Build.VERSION_CODES.M)
    public void onClick(View view) {

        switch ( view.getId() ){
            case R.id.btnLogin:
                //login has been clicked
                //setKeyboardVisibility(false);
                String[] inputValues = getInputValues(this.eName,this.ePassword);
                try
                {
                    Services.userLogin().login(inputValues);
                    startActivity(new Intent(this , HomeActivity.class));
                }
                catch(LoginException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Please enter valid credentials!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
                break;
            case R.id.btnSignUp:
                startActivity(new Intent(this, SignUpActivity.class));
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

    private void copyDatabaseToDevice() {
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            Main.setDBPathName(dataDirectory.toString() + "/" + Main.getDBPathName());

        } catch (final IOException ioe) {
            Messages.warning(this, "Unable to access application data: " + ioe.getMessage());
        }
    }

    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];

            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }
}
