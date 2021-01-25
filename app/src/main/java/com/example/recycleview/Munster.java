package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Munster extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = {R.drawable.rsz_place, R.drawable.rsz_cork, R.drawable.rsz_kerry, R.drawable.rsz_waterford, R.drawable.rsz_tipp,
            R.drawable.rsz_limerick, R.drawable.rsz_clare,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_munster);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.munster);
        s2 = getResources().getStringArray(R.array.munster_description);

        MyAdapterM myAdapterM = new MyAdapterM(this, s1, s2, images);
        recyclerView.setAdapter(myAdapterM);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}