package com.atmostsoft.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SignUp extends AppCompatActivity {

    EditText etName,etNumber,etPassword,etCPassword;
    Button btnBack,btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation())
                {
                    try {
                        FileWriter fileWriter = new FileWriter("SIGNUP.txt",true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                        bufferedWriter.write(etName+","+etNumber+","+etPassword+"\n");
                        bufferedWriter.close();
                        fileWriter.close();

                        Intent intent = new Intent(com.atmostsoft.quiz1.SignUp.this,com.atmostsoft.quiz1.StartScreen.class);
                        startActivity(intent);
                        finish();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    public boolean validation()
    {
        boolean flag = true;
        if (etName.getText().toString().isEmpty()) {
            etName.setError("name is required");
            flag = false;
        }
        if (etNumber.getText().toString().isEmpty()) {
            etNumber.setError("number is required");
            flag = false;
        }
        if (etPassword.getText().toString().isEmpty()) {
            etPassword.setError("password is required ");
            if (etCPassword.getText().toString().isEmpty())
                etCPassword.setError("confirm password is required");
            if (etCPassword.getText().toString().equals(etCPassword.getText().toString()))
            {
                etCPassword.setError("check the password");
            }
            flag = false;
        }

        return flag;

    }

    public void init()
    {
        etName = findViewById(R.id.signUpName);
        etNumber = findViewById(R.id.signUpNumber);
        etPassword = findViewById(R.id.signUpPassword);
        etCPassword = findViewById(R.id.signUpCPassword);
        btnBack = findViewById(R.id.SignUpBack);
        btnSignUp = findViewById(R.id.signupSubmit);
    }
}