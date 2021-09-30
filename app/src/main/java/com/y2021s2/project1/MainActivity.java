package com.y2021s2.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double value1;
    double value2;
    double result;

    public boolean parseEditText(EditText editText1, EditText editText2) {
        try {
            value1 = Double.parseDouble(editText1.getText().toString());
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Cannot parse Value 1 to number",Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            value2 = Double.parseDouble(editText2.getText().toString());
            return true;
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Cannot parse Value 2 to number", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public String printResult(String operator) {
        DecimalFormat df  = new DecimalFormat("#.######");

        return df.format(value1) + " " + operator + " " + df.format(value2) + " \n= " + df.format(result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextVal1 = findViewById(R.id.editTextValue1);
        EditText editTextVal2 = findViewById(R.id.editTextValue2);

        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonMin = findViewById(R.id.buttonMinus);
        Button buttonMul = findViewById(R.id.buttonMultiplied);
        Button buttonDiv = findViewById(R.id.buttonDivision);

        TextView textViewResult = findViewById(R.id.textViewResult);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseEditText(editTextVal1,editTextVal2);

                result = value1 + value2;

                textViewResult.setText(printResult("+"));
            }
        });

        buttonMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseEditText(editTextVal1,editTextVal2);

                result = value1 - value2;

                textViewResult.setText(printResult("-"));
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseEditText(editTextVal1,editTextVal2);

                result = value1 * value2;

                textViewResult.setText(printResult("*"));
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseEditText(editTextVal1,editTextVal2);

                if (value2 == 0.0) {
                    Toast.makeText(getApplicationContext(),"Cannot Divide with 0",Toast.LENGTH_SHORT).show();
                    textViewResult.setText("Error");
                }
                else {
                    result = value1 / value2;
                    textViewResult.setText(printResult("/"));
                }
            }
        });
    }
}