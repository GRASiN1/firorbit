package com.fitorbit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText mFullName, mEmail, mPassWord;
    Button mRegisterBtn;
    TextView mLogin;
    ProgressBar mSignUpProBar;

    FirebaseFirestore fStore;
    String userId;
    FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFullName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.emailId);
        mPassWord = findViewById(R.id.passWord);
        mRegisterBtn = findViewById(R.id.btnSignUp);
        mLogin = findViewById(R.id.logInTxt);
        mSignUpProBar = findViewById(R.id.signUpProBar);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), Widgets.class));
            finish();
        }

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSignUpProBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = mEmail.getText().toString().trim();
                String password = mPassWord.getText().toString().trim();
                final String fullName = mFullName.getText().toString();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(password) && password.length() < 6){
                    mPassWord.setError("Password is required and Length >= 6 Character");
                    return;
                }

                if(TextUtils.isEmpty(fullName)){
                    mFullName.setError("Name is required");
                    return;
                }

                mSignUpProBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser fUser = fAuth.getCurrentUser();
                            fUser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getApplicationContext(), "Register Successfull", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"OnFailure: Email not sent" + e.getMessage());
                                }
                            });

                            Toast.makeText(getApplicationContext(),"User Created",Toast.LENGTH_SHORT).show();
                            userId = fAuth.getCurrentUser().getUid();
                            DocumentReference docRef = fStore.collection("user").document(userId);
                            Map<String, Object> user = new HashMap<>();
                            user.put("fName", fullName);
                            user.put("email",email);
                            docRef.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG,"OnSuccess : User profile is created for"+ userId);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"OnFailure: " + e.toString());
                                }
                            });

                            startActivity(new Intent(getApplicationContext(), Widgets.class));

                        }
                        else{
                            Toast.makeText(SignUp.this,"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            mSignUpProBar.setVisibility(View.GONE);
                        }

                    }
                });


            }
        });


    }
}