package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Attraction extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[], s3[], s4[], s5[];
    int images[] = {R.drawable.garisland, R.drawable.loughhyne, R.drawable.donwildlife,};
    Button btnDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.attraction);
        s2 = getResources().getStringArray(R.array.visitorinfo);
        s3 = getResources().getStringArray(R.array.todoinfo);
        s4 = getResources().getStringArray(R.array.recommendinfo);
        s5 = getResources().getStringArray(R.array.attraction_destination);

        MyAdapterAttraction myAdapter = new MyAdapterAttraction(this, s1, s2, s3, s4, s5, images, btnDestination );
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}