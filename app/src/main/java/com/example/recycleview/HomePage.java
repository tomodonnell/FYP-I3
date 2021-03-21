package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {

    //Creating button to open new activity, based on guidance available on Android Developers, https://developer.android.com/training/basics/firstapp/starting-activity

    private ImageButton imageButtonProvince;
    private ImageButton imageButtonProgress;
    Button btnLogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        imageButtonProvince = findViewById(R.id.ibtnMap);
        imageButtonProgress = findViewById(R.id.ibtnProgress);
        btnLogout = findViewById(R.id.btnlogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             FirebaseAuth.getInstance().signOut();
             Intent intToLogin = new Intent (HomePage.this, Login.class);
             startActivity(intToLogin);
                Toast.makeText(HomePage.this, "You have successfully logged out", Toast.LENGTH_SHORT).show();
            }
        });

        imageButtonProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                movetToProvince();

            }
        });

        imageButtonProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                movetToProgress();

            }
        });

    }

    private void movetToProvince() {
        Intent intent = new Intent (HomePage.this, MainActivity.class);
        startActivity(intent);
    }

    private void movetToProgress(){
        Intent intent = new Intent (HomePage.this, Progress. class);
        startActivity(intent);
    }


    //Image button activity ends.

}