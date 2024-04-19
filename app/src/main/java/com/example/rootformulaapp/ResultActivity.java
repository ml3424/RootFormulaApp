package com.example.rootformulaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    ImageView iV;
    TextView resultText;
    Button btnBack;
    Intent gi;

    double a,b,c;
    String result;
    double inRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        iV = findViewById(R.id.iV);
        resultText = findViewById(R.id.result);
        btnBack = findViewById(R.id.btnBack);

        gi = getIntent();
        a = gi.getDoubleExtra("a",-888.0);
        b = gi.getDoubleExtra("b",-888.0);
        c = gi.getDoubleExtra("c",-888.0);
        result = calResult(a,b,c);

        if(inRoot > 0)
        {
            if(a > 0)
            {
                iV.setImageResource(R.drawable.happttwo);
            }
            else
            {
                iV.setImageResource(R.drawable.sadtwo);
            }
        }
        else if(inRoot == 0)
        {
            if(a > 0)
            {
                iV.setImageResource(R.drawable.happyone);
            }
            else
            {
                iV.setImageResource(R.drawable.sadone);
            }
        }
        else
        {
            if(a > 0)
            {
                iV.setImageResource(R.drawable.happynone);
            }
            else
            {
                iV.setImageResource(R.drawable.sadnone);
            }
        }


    }


    public String calResult(double a, double b, double c)
    {
        inRoot = b*b - 4*a*c;
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
        String returnText = resultText.getText().toString();
        return returnText;
    }

    public void clickBack(View view) {
        gi.putExtra("result",result);
        setResult(RESULT_OK,gi);
        finish();
    }
}