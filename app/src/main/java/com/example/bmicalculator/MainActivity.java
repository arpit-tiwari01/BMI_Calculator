package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight,edtHeightFT,edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight= findViewById(R.id.edtWeight);
        edtHeightFT=findViewById(R.id.edtHeightFT);
        edtHeightIn=findViewById(R.id.edtHeightIN);
        btnCalculate=findViewById(R.id.btnCalculate);
        txtResult=findViewById(R.id.txtResult);
        llMain=findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int wt = Integer.parseInt(edtWeight.getText().toString());
               int ft = Integer.parseInt(edtHeightFT.getText().toString());
               int in = Integer.parseInt(edtHeightIn.getText().toString());

               int totalIn = ft*12 + in;
               double totalCm = totalIn*2.53;
               double totalM = totalCm/100;
               double bmi = wt/(totalM*totalM);

               if(bmi>25){
                   txtResult.setText("You'r Overwight");
                   llMain.setBackgroundColor(getResources().getColor(R.color.red));
               } else if (bmi<18) {
                   txtResult.setText("You'r Underweight");
                   llMain.setBackgroundColor(getResources().getColor(R.color.yellow));
               }else {
                 txtResult.setText("You'r Healthy");
                   llMain.setBackgroundColor(getResources().getColor(R.color.green));
               }
            }
        });
    }
}