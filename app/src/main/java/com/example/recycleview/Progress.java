package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        progressStatus = 0;
        progressBar = findViewById(R.id.progress_bar);
        percent = findViewById(R.id.txtpercent);
        garBox = findViewById(R.id.GarBox);
        loughBox = findViewById(R.id.LoughBox);


        garBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (garBox.isChecked()) {
                    progressStatus += 10;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");
                }

                else {
                    progressStatus -= 10;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");
                }

            }
        });

        loughBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (loughBox.isChecked()) {
                    progressStatus += 10;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");
                }

                else {
                    progressStatus -= 10;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");
                }

            }
        });

    }

}
