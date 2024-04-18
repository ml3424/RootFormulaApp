package com.example.rootformulaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 7777;
    EditText eTA, eTB, eTC;
    Button btnRnd, btnCal2;
    TextView tV1;

    double a,b,c = 0;
    String result, inputA, inputB, inputC;
    Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTA = findViewById(R.id.eTA);
        eTB = findViewById(R.id.eTB);
        eTC = findViewById(R.id.eTC);
        tV1 = findViewById(R.id.textView76);

        btnCal2 = findViewById(R.id.btnCal2);
        btnRnd = findViewById(R.id.btnRnd);

    }


    public void clickRnd(View view) {
        a = Double.valueOf(rnd.nextInt(100) - 50);
        b = Double.valueOf(rnd.nextInt(100) - 50);
        c = Double.valueOf(rnd.nextInt(100) - 50);

        eTA.setText(String.valueOf(a));
        eTB.setText(String.valueOf(b));
        eTC.setText(String.valueOf(c));
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

                if(input.charAt(1) >= '0' && input.charAt(1) <= '9')
                {
                    return true;
                }
                else
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
            }
        }
        return false;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MainActivity.RESULT_OK) {
                if (data != null) {
                    result = data.getStringExtra("result");
                    tV1.setText("last result was: \n" + result);
                }
            }
        }
    }

    public void calResult(View view) {
        inputA = String.valueOf(eTA.getText());
        inputB = String.valueOf(eTB.getText());
        inputC = String.valueOf(eTC.getText());

        if(checkInput(inputA) && checkInput(inputB) && checkInput(inputC)) {
            a = Double.valueOf(inputA);
            b = Double.valueOf(inputB);
            c = Double.valueOf(inputC);

            Intent si = new Intent(this, ResultActivity.class);
            si.putExtra("a", a);
            si.putExtra("b", b);
            si.putExtra("c", c);
            startActivityForResult(si,REQUEST_CODE);
        }
    }
}