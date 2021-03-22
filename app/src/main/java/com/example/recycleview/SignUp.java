package com.example.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    //This Java class is used to implement sign up functionality, using a Firebase Database
    //It is based on an "EasyLearn" Youtube tutorial - //www.youtube.com/watch?v=V0ZrnL-i77Q

    EditText emailID, password;
    Button btnSignUp;
    TextView loginIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Getting instance for firebase authentication
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailID = findViewById(R.id.signUpEmail);
        password = findViewById(R.id.signUpPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        loginIn = findViewById(R.id.txtlogin);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailID.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()){
                    emailID.setError("Please enter your email address");
                    emailID.requestFocus();
                }

                else if (pwd.isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                }

                else if (email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(SignUp.this, "Please fill in the required fields", Toast.LENGTH_SHORT).show();
                }

                else if (!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(SignUp.this, "Sign Up unsuccessful, please try again", Toast.LENGTH_SHORT).show();
                            }

                            else {
                                startActivity(new Intent(SignUp.this, HomePage.class));
                            }
                        }
                    });
                }

                else {
                    Toast.makeText(SignUp.this, "Error, please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ToLogin = new Intent (SignUp.this,Login.class);
                startActivity(ToLogin);
            }
        });

    }
}