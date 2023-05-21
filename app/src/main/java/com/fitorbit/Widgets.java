package com.fitorbit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Widgets extends AppCompatActivity {

    ImageView addGoals, goToFoodTracker, calBurnt, foodTack, heartBeat, goalAchieved, foodrep, stepTrack;
    ProgressBar protein, fats, carbs, fibers;

    int proteinPro = 56, fatsPro = 11, carbsPro = 35, fibersPro = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);

        protein = findViewById(R.id.proteinProBar);
        fats = findViewById(R.id.fatsProBar);
        carbs = findViewById(R.id.carbsProBar);
        fibers = findViewById(R.id.fiberProBar);
        addGoals = findViewById(R.id.addGoal);
        goToFoodTracker = findViewById(R.id.goToFoodTracker);
        calBurnt = findViewById(R.id.calories_burnt_symbol);
        foodTack = findViewById(R.id.food_tracker_symbol);
        heartBeat = findViewById(R.id.heart_beat_symbol);
        goalAchieved = findViewById(R.id.goal_achieved_symbol);
        foodrep = findViewById(R.id.food_recipe_symbol);
        stepTrack = findViewById(R.id.step_tracker_symbol);

        protein.setProgress(proteinPro);
        protein.setMax(100);
        fats.setProgress(fatsPro);
        fats.setMax(100);
        carbs.setProgress(carbsPro);
        carbs.setMax(100);
        fibers.setProgress(fibersPro);
        fibers.setMax(100);

        addGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),goals.class));
            }
        });

        goToFoodTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),foodTracker.class));
            }
        });

        calBurnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),calories.class));
            }
        });

        foodTack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),foodTracker.class));
            }
        });

        heartBeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),heartBeatCon.class));
            }
        });

        goalAchieved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),goals.class));
            }
        });
        foodrep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),foodRecipe.class));
            }
        });
        stepTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), steps.class));
            }
        });
    }
}