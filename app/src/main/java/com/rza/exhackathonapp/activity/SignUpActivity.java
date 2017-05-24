package com.rza.exhackathonapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.rza.exhackathonapp.R;
import com.rza.exhackathonapp.model.User;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);


        Button button = (Button) findViewById(R.id.buttonSignup);
        final EditText editTextEmail = (EditText) findViewById(R.id.your_email_address);
        final EditText editTextPass = (EditText) findViewById(R.id.your_password);
        final EditText editTextRepeatPass = (EditText) findViewById(R.id.repeat_pass);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextPass.getText().toString().equals(editTextRepeatPass.getText().toString())) {
                    final User user;
                    user = new User(1, editTextEmail.getText().toString(), editTextPass.getText().toString());
                    user.save();


                    Toast.makeText(SignUpActivity.this, "Successfully " + user.toString() + " registered", Toast.LENGTH_SHORT).show();
                    Log.i("dbINFO", user.toString() + " added to DB");
                    Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(SignUpActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                    editTextPass.setText("");
                    editTextRepeatPass.setText("");
                }
            }
        });



    }
}
