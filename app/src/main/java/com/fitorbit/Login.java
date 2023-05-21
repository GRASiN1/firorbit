package com.fitorbit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText mEmail, mPassword;
    Button mLoginBtn;
    TextView mSignUp;
    ProgressBar mLogProBar;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail= findViewById(R.id.email);
        mPassword = findViewById(R.id.passWord);
        mLoginBtn = findViewById(R.id.logInBtn);
        mSignUp = findViewById(R.id.signUpTxt);
        mLogProBar = findViewById(R.id.logProBar);
        fAuth = FirebaseAuth.getInstance();


        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLogProBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(getApplicationContext(), SignUp.class));
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(password) && password.length() < 6 ){
                    mPassword.setError("Password is required and length >= 6 Characters");
                    return;
                }

                mLogProBar.setVisibility(View.VISIBLE);
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Widgets.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            mLogProBar.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });

    }


}