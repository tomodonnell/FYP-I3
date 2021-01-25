package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Cork extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = {R.drawable.rsz_place, R.drawable.rsz_garisland, R.drawable.rsz_loughhyne, R.drawable.rsz_donwildlife,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cork);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.cork);
        s2 = getResources().getStringArray(R.array.cork_description);

        MyAdapterM myAdapter = new MyAdapterM(this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}