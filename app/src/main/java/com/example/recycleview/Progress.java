package com.example.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

//This Java Class creates an array list and builds the RecyclerView, enabling the implementation the RecyclerView feature.
//Based on "Coding in FLow" Youtube lectures, however the code has been manipulated and styled to suit my solution.
//This is the link to the playlist of videos - https://www.youtube.com/watch?v=Nw9JF55LDzE&list=PLrnPJCHvNZuBtTYUuc5Pyo4V7xZ2HNtf4

public class Progress extends AppCompatActivity {

    public ProgressBar progressBar;
    public int progressStatus;
    public TextView percent;
    public CheckBox garBox;
    public CheckBox loughBox;
    public CheckBox donBox;
    public CheckBox lismoreBox;
    public Button save_attraction;

    FirebaseDatabase database;
    DatabaseReference reference;
    Member update;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        reference = database.getInstance().getReference().child("viewed");
        update = new Member();

        progressStatus = 0;
        progressBar = findViewById(R.id.progress_bar);
        percent = findViewById(R.id.txtpercent);
        garBox = findViewById(R.id.GarBox);
        loughBox = findViewById(R.id.LoughBox);
        donBox = findViewById(R.id.DonBox);
        lismoreBox = findViewById(R.id.LismoreBox);
        save_attraction = findViewById(R.id.save);

        garBox.setChecked(Update("CHECK_1"));
        loughBox.setChecked(Update("CHECK_2"));
        donBox.setChecked(Update("CHECK_3"));
        lismoreBox.setChecked(Update("CHECK_4"));

        String a1 = "Garnish";
        String a2 = "Lough";
        String a3 = "Don";
        String a4 = "Lismore";

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    i = (int) dataSnapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        save_attraction.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (garBox.isChecked()) {
                    update.setAttraction1(a1);
                    reference.child(String.valueOf(i + 1)).setValue(update);
                    SaveChecked("CHECK_1", garBox.isChecked());
                } else {
                    SaveChecked("CHECK_1", false);
                }

                if (loughBox.isChecked()) {
                    update.setAttraction2(a2);
                    reference.child(String.valueOf(i + 1)).setValue(update);
                    SaveChecked("CHECK_2", loughBox.isChecked());

                } else {
                    SaveChecked("CHECK_2", false);

                }

                if (donBox.isChecked()) {
                    update.setAttraction3(a3);
                    reference.child(String.valueOf(i + 1)).setValue(update);
                    SaveChecked("CHECK_3", donBox.isChecked());
                } else {
                    SaveChecked("CHECK_3", false);

                }

                if (lismoreBox.isChecked()) {
                    update.setAttraction4(a4);
                    reference.child(String.valueOf(i + 1)).setValue(update);
                    SaveChecked("CHECK_4", lismoreBox.isChecked());
                } else {
                    SaveChecked("CHECK_4", false);
                }
            }


        });


        garBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (garBox.isChecked()) {
                    progressStatus += 25;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 25;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        loughBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (loughBox.isChecked()) {
                    progressStatus += 25;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 25;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        donBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (donBox.isChecked()) {
                    progressStatus += 25;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 25;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        lismoreBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lismoreBox.isChecked()) {
                    progressStatus += 25;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 25;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

    }

    private void SaveChecked(String key, boolean value) {
        SharedPreferences sp = getSharedPreferences("SAVE_CHECK", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    private boolean Update(String key) {
        SharedPreferences sp = getSharedPreferences("SAVE_CHECK", MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

}
