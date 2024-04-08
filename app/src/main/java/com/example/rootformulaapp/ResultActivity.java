package com.example.rootformulaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    ImageView iV;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        iV = findViewById(R.id.iV);
        resultText = findViewById(R.id.result);


    }


    public void calResult(double a, double b, double c)
    {
        double inRoot = b*b - 4*a*c;
        if(inRoot > 0)
        {
            resultText.setText("First result: "+ String.valueOf((0-b + Math.sqrt(inRoot))/(2*a)) + "\nSec result: "+ String.valueOf((0-b - Math.sqrt(inRoot))/(2*a)));
        }
        else if(inRoot == 0)
        {
            resultText.setText("Result: "+ String.valueOf(0-b/2*a));
        }
        else
        {
            resultText.setText("No results");
        }

    }
}