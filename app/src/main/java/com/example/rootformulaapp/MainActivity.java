package com.example.rootformulaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    EditText eTA, eTB, eTC;
    Button btnA, btnB, btnC, btnRnd, btnCal;
    double a,b,c;
    Random rnd = new Random();

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

    public void clickA(View view)
    {
        String input = String.valueOf(eTA.getText());
        if(checkInput(input))
        {
            a = Double.valueOf(input);
        }
    }

    public void clickB(View view) {
        String input = String.valueOf(eTB.getText());
        if(checkInput(input))
        {
            b = Double.valueOf(input);
        }
    }

    public void clickC(View view) {
        String input = String.valueOf(eTC.getText());
        if(checkInput(input))
        {
            c = Double.valueOf(input);
        }
    }

    public void clickRnd(View view) {
        a = Double.valueOf(rnd.nextInt(100) - 50);
        b = Double.valueOf(rnd.nextInt(100) - 50);
        c = Double.valueOf(rnd.nextInt(100) - 50);

        eTA.setText(String.valueOf(a));
        eTB.setText(String.valueOf(b));
        eTC.setText(String.valueOf(c));
    }

    public void clickCal(View view) {
    }


    public boolean checkInput(String input)
    {
        if(!input.isEmpty())
        {
            if(input.length() == 1)
            {
                if(input.charAt(0) >= '0' && input.charAt(0) <= '9')
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(input.equals("-.") || input.equals("+."))
                {
                    return false;
                }
            }
        }
        return false;
    }

}