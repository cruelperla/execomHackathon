package com.rza.exhackathonapp.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rza.exhackathonapp.R;
import com.rza.exhackathonapp.model.User;

import java.util.List;


public class LoginActivity extends AppCompatActivity {
    List<User> mockUsers;
    String email;
    String pass;
    TextView textViewSignUp;
    TextView textViewInputEmail;
    TextView textViewInputPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textViewSignUp = (TextView) findViewById(R.id.linkSignup);
        textViewInputEmail = (TextView) findViewById(R.id.input_email);
        textViewInputPass = (TextView) findViewById(R.id.input_pass);

        Button buttonLogin = (Button)findViewById(R.id.buttonLogin);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
       /* mockUsers = User.listAll(User.class);
        for (User u: mockUsers) {
            String log = " email: " + u.getEmail() + " pass: " + u.getPassword();
            Log.i("db", log);
        }

*/









        //click na login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = textViewInputEmail.getText().toString();
                pass = textViewInputPass.getText().toString();
/*
                for (User u: mockUsers) {
                    String log = " email: " + u.getEmail() + " pass: " + u.getPassword();
                    Log.i("db", log);
                }
                */

                if (true) {
                    Intent i = new Intent(LoginActivity.this, ItemsActivity.class);
                    startActivity(i);

                }
                else {
                    Toast.makeText(LoginActivity.this, "No User with such credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //click na signup
        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });


    }
}
