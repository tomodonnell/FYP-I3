package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {

    //Creating button to open new activity, based on guidance available on Android Developers, https://developer.android.com/training/basics/firstapp/starting-activity

    private ImageButton imageButtonProvince;
    private ImageButton imageButtonProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        imageButtonProvince = findViewById(R.id.ibtnMap);
        imageButtonProgress = findViewById(R.id.ibtnProgress);

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