package com.fitorbit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class calories extends AppCompatActivity {

    ProgressBar caloriesBurnt;
    ImageView add;
    TextView caloriesBurntTxt;
    int caloriesBurntVal = 48;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        caloriesBurnt = findViewById(R.id.calories_burnt_ProBar);
        caloriesBurntTxt = findViewById(R.id.calories_burnt_ProBar_Txt);
        add = findViewById(R.id.addWork);

        caloriesBurnt.setMax(100);
        caloriesBurnt.setProgress(caloriesBurntVal);
        caloriesBurntTxt.setText(caloriesBurntVal+"%");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),workout.class));
            }
        });

    }
}