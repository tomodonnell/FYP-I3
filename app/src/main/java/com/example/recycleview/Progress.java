package com.example.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

    //Variables for our shared preferences
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String PROGRESS_PERCENTAGE_AS_STRING = "text";
    public static final String GAR = "gar";
    public static final String LOUGH = "lough";
    public static final String DON = "don";
    public static final String LISMORE = "lismore";

    //Variables to display the shared preferences after reopening the app.
    public String stored_progress_percentage_value;
    public boolean stored_gar_value;
    public boolean stored_lough_value;
    public boolean stored_don_value;
    public boolean stored_lismore_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        progressBar = findViewById(R.id.progress_bar);
        percent = findViewById(R.id.txtpercent);
        garBox = findViewById(R.id.GarBox);
        loughBox = findViewById(R.id.LoughBox);
        donBox = findViewById(R.id.DonBox);
        lismoreBox = findViewById(R.id.LismoreBox);
        save_attraction = findViewById(R.id.save);

        save_attraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                Toast.makeText(getBaseContext(), "Your Progress has been Updated!" , Toast.LENGTH_SHORT ).show();
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

        //Reloading user data on start up
        loadData();
        updateTheScreenWhenAppReOpens();

    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //putting value of the textview and checkboxes into the shared preferences
        editor.putString(PROGRESS_PERCENTAGE_AS_STRING, percent.getText().toString());
        editor.putBoolean(GAR, garBox.isChecked());
        editor.putBoolean(LOUGH, loughBox.isChecked());
        editor.putBoolean(DON, donBox.isChecked());
        editor.putBoolean(LISMORE, lismoreBox.isChecked());

        editor.apply();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        //Assign the stored values to these variables
        stored_progress_percentage_value = sharedPreferences.getString(PROGRESS_PERCENTAGE_AS_STRING, "0");
        stored_gar_value = sharedPreferences.getBoolean(GAR, false);
        stored_lough_value = sharedPreferences.getBoolean(LOUGH, false);
        stored_don_value = sharedPreferences.getBoolean(DON, false);
        stored_lismore_value = sharedPreferences.getBoolean(LISMORE, false);

    }

    public void updateTheScreenWhenAppReOpens(){

        //Assign the shared preference values (from above in loadData) to the actual controls on the GUI
        percent.setText(stored_progress_percentage_value);
        garBox.setChecked(stored_gar_value);
        loughBox.setChecked(stored_lough_value);
        donBox.setChecked(stored_don_value);
        lismoreBox.setChecked(stored_lismore_value);
    }

    //Saving data when the app gets closed

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
        updateTheScreenWhenAppReOpens();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveData();
    }
}


