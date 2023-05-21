package com.fitorbit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class steps extends AppCompatActivity {

    ProgressBar steps;
    TextView stepsTxtPro,stepsTxt,calTxt;
    int stepsVal = 8754;
    double calVal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);

        steps = findViewById(R.id.steps_ProBar);
        stepsTxtPro = findViewById(R.id.steps_ProBar_Txt);
        stepsTxt = findViewById(R.id.steps_Txt);
        calTxt = findViewById(R.id.calories_Txt);

        calVal =  stepsVal*0.04;
        steps.setMax(10000);
        steps.setProgress(stepsVal);
        stepsTxt.setText(stepsVal+"\nSteps");
        calTxt.setText(calVal+"\nCalories");



    }
}