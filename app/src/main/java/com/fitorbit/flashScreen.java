package com.fitorbit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class flashScreen extends AppCompatActivity {
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        fAuth = FirebaseAuth.getInstance();

    }
    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser user = fAuth.getCurrentUser();
        if(user != null){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), Widgets.class));
                }
            }, 3000);

        }
        else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }, 3000);
        }
    }
}