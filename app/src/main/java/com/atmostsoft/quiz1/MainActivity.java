package com.atmostsoft.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etNumber,etPassword;
    Button btnEnter,btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNumber.getText().toString().isEmpty())
                    etNumber.setError("number is required");
                if (etPassword.getText().toString().isEmpty())
                    etPassword.setError("password is required");
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,com.atmostsoft.quiz1.SignUp.class);
//                startActivityForResult(intent,ACTIVITY_SI);
            }
        });
    }
    public void init()
    {
        etNumber = findViewById(R.id.number);
        etPassword = findViewById(R.id.password);
        btnEnter = findViewById(R.id.btnEnter);
        btnSignUp = findViewById(R.id.signUp);
    }
}