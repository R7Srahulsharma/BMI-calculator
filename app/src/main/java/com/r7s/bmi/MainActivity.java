package com.r7s.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    EditText edtWeight, edtHeightFt, edtHeightIn;
    Button btnCalculate;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWeight = findViewById(R.id.edtweight);
        edtHeightFt = findViewById(R.id.edtheightFt);
        edtHeightIn = findViewById(R.id.edtheightIn);
        btnCalculate = findViewById(R.id.btncalculate);
        txtResult = findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = ft * 12 + in;
                double totalCm = totalIn * 2.54; // corrected conversion factor from 2.53 to 2.54 (1 inch = 2.54 cm)
                double total = totalCm / 100;
                double bmi = wt / (total * total); // corrected totalCm to total

                if (bmi > 25) {
                    txtResult.setText("You are overweight");
                } else if (bmi < 18) {
                    txtResult.setText("You are underweight");
                } else {
                    txtResult.setText("You are healthy");
                }
            }
        });
    }
}
