package com.atmostsoft.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class StartScreen extends AppCompatActivity {

    Button btnAddDriver,btnLocation,btnDriverNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

    }

    public void init()
    {
        btnAddDriver = findViewById(R.id.btnAddDriver);
        btnLocation = findViewById(R.id.btnLocation);
        btnDriverNumber = findViewById(R.id.btnDriverNumber);
    }
}