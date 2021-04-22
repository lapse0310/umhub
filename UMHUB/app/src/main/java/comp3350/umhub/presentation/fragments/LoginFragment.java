package comp3350.umhub.presentation.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import javax.security.auth.login.LoginException;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.application.SignUpException;
import comp3350.umhub.business.ILogin;
import comp3350.umhub.presentation.CourseActivity;
import comp3350.umhub.presentation.MajorsActivity;


public class LoginFragment extends DialogFragment {
    private View view;
    private ILogin iLogin;
    private EditText eName;                      /* A user interface for entering/modifying the text */
    private EditText ePassword;
    private Button eLogin;
    private Button eSignUp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        iLogin = Services.getILogin();
        eName = view.findViewById(R.id.etUserName);
        ePassword = view.findViewById(R.id.etPassword);
        eLogin = view.findViewById(R.id.btnLogin);
        eSignUp = view.findViewById(R.id.btnSignUp);
        eSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    iLogin.signUp(eName.getText().toString(),ePassword.getText().toString());
                    Toast toast = Toast.makeText(view.getContext(),"New user successfully created! Now you can log in using the credentials", Toast.LENGTH_SHORT);
                    toast.show();
                } catch (SignUpException e) {
                    Toast toast = Toast.makeText(view.getContext(),
                            e.getMessage(), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            }
        });
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    iLogin.login(eName.getText().toString(),ePassword.getText().toString());
                    dismiss();
                }
                catch(LoginException e)
                {
                    Toast toast = Toast.makeText(view.getContext(),
                            "Please enter valid credentials!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            }
        });
        System.out.println("--OnCreateView");
        return view;
    }

}
