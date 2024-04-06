package com.example.rootformulaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText eTA, eTB, eTC;
    Button btnA, btnB, btnC, btnRnd, btnCal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTA = findViewById(R.id.eTA);
        eTB = findViewById(R.id.eTB);
        eTC = findViewById(R.id.eTC);

        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnCal = findViewById(R.id.btnCal);
        btnRnd = findViewById(R.id.btnRnd);
    }
}