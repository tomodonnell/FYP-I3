package com.example.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    public CheckBox ballyBox;
    public CheckBox lismoreBox;
    public CheckBox bunBox;
    public CheckBox comeraghBox;
    public CheckBox coumshinBox;
    public CheckBox dunloeBox;
    public CheckBox gallarusBox;
    public CheckBox skelligBox;
    public CheckBox templeBox;
    public CheckBox athasselBox;
    public CheckBox aherlowBox;
    public CheckBox teraBox;
    public CheckBox gurBox;
    public CheckBox curraghBox;
    public CheckBox doolinBox;
    public CheckBox dromoreBox;
    public CheckBox lahinchBox;
    public Button save_attraction;

    //Variables for our shared preferences
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String PROGRESS_PERCENTAGE_AS_STRING = "text";
    public static final String GAR = "gar";
    public static final String LOUGH = "lough";
    public static final String DON = "don";
    public static final String BALLY = "bally";
    public static final String LISMORE = "lismore";
    public static final String BUN = "bun";
    public static final String COMERAGH = "comeragh";
    public static final String COUMSHIN = "coumshin";
    public static final String DUNLOE = "dunloe";
    public static final String GALLARUS = "gallarus";
    public static final String SKELLIG = "skellig";
    public static final String TEMPLE = "temple";
    public static final String ATHASSEL = "athassel";
    public static final String AHERLOW = "aherlow";
    public static final String TERA = "tera";
    public static final String GUR = "gur";
    public static final String CURRAGH = "curragh";
    public static final String DOOLIN = "doolin";
    public static final String DROMORE = "dromore";
    public static final String LAHINCH = "lahinch";


    //Variables to display the shared preferences after reopening the app.
    public String stored_progress_percentage_value;
    public boolean stored_gar_value;
    public boolean stored_lough_value;
    public boolean stored_don_value;
    public boolean stored_bally_value;
    public boolean stored_lismore_value;
    public boolean stored_bun_value;
    public boolean stored_comeragh_value;
    public boolean stored_coumshin_value;
    public boolean stored_dunloe_value;
    public boolean stored_gallarus_value;
    public boolean stored_skellig_value;
    public boolean stored_temple_value;
    public boolean stored_athassel_value;
    public boolean stored_aherlow_value;
    public boolean stored_tera_value;
    public boolean stored_gur_value;
    public boolean stored_curragh_value;
    public boolean stored_doolin_value;
    public boolean stored_dromore_value;
    public boolean stored_lahinch_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        progressBar = findViewById(R.id.progress_bar);
        percent = findViewById(R.id.txtpercent);
        garBox = findViewById(R.id.GarBox);
        loughBox = findViewById(R.id.LoughBox);
        donBox = findViewById(R.id.DonBox);
        ballyBox = findViewById(R.id.BallcottonBox);
        lismoreBox = findViewById(R.id.LismoreBox);
        bunBox = findViewById(R.id.BunmahonBox);
        comeraghBox = findViewById(R.id.ComeraghBox);
        coumshinBox = findViewById(R.id.CoumshingBox);
        dunloeBox = findViewById(R.id.DunloeBox);
        gallarusBox = findViewById(R.id.GallarusBox);
        skelligBox = findViewById(R.id.SkelligBox);
        templeBox = findViewById(R.id.TemplemoreBox);
        athasselBox = findViewById(R.id.AthasselBox);
        aherlowBox = findViewById(R.id.AherlowBox);
        teraBox = findViewById(R.id.TeranovaBox);
        gurBox = findViewById(R.id.GurBox);
        curraghBox = findViewById(R.id.CurraghBox);
        doolinBox = findViewById(R.id.DoolinBox);
        dromoreBox = findViewById(R.id.DromoreBox);
        lahinchBox = findViewById(R.id.LahinchBox);
        save_attraction = findViewById(R.id.save);

        save_attraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                Toast.makeText(getBaseContext(), "Your Progress has been Updated" , Toast.LENGTH_SHORT ).show();
                moveBackHome();
            }
        });

        garBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (garBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");


                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        loughBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (loughBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        donBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (donBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        ballyBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ballyBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        lismoreBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lismoreBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        comeraghBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (comeraghBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        coumshinBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (coumshinBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        bunBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bunBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        skelligBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (skelligBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        dunloeBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (dunloeBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        gallarusBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (gallarusBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        templeBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (templeBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        athasselBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (athasselBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        aherlowBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (aherlowBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        gurBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (gurBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        curraghBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (curraghBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        teraBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (teraBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        doolinBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (doolinBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        dromoreBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (dromoreBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                }

            }
        });

        lahinchBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lahinchBox.isChecked()) {
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                    percent.setText(progressStatus + "%");

                } else {
                    progressStatus -= 5;
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
        editor.putBoolean(BALLY, ballyBox.isChecked());
        editor.putBoolean(LISMORE, lismoreBox.isChecked());
        editor.putBoolean(COMERAGH, comeraghBox.isChecked());
        editor.putBoolean(COUMSHIN, coumshinBox.isChecked());
        editor.putBoolean(BUN, bunBox.isChecked());
        editor.putBoolean(SKELLIG, skelligBox.isChecked());
        editor.putBoolean(DUNLOE, dunloeBox.isChecked());
        editor.putBoolean(GALLARUS, gallarusBox.isChecked());
        editor.putBoolean(TEMPLE, templeBox.isChecked());
        editor.putBoolean(ATHASSEL, athasselBox.isChecked());
        editor.putBoolean(AHERLOW, aherlowBox.isChecked());
        editor.putBoolean(CURRAGH, curraghBox.isChecked());
        editor.putBoolean(GUR, gurBox.isChecked());
        editor.putBoolean(TERA, teraBox.isChecked());
        editor.putBoolean(DOOLIN, doolinBox.isChecked());
        editor.putBoolean(DROMORE, dromoreBox.isChecked());
        editor.putBoolean(LAHINCH, lahinchBox.isChecked());


        editor.apply();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        //Assign the stored values to these variables
        stored_progress_percentage_value = sharedPreferences.getString(PROGRESS_PERCENTAGE_AS_STRING, "0");
        stored_gar_value = sharedPreferences.getBoolean(GAR, false);
        stored_lough_value = sharedPreferences.getBoolean(LOUGH, false);
        stored_don_value = sharedPreferences.getBoolean(DON, false);
        stored_bally_value = sharedPreferences.getBoolean(BALLY, false);
        stored_lismore_value = sharedPreferences.getBoolean(LISMORE, false);
        stored_comeragh_value = sharedPreferences.getBoolean(COMERAGH, false);
        stored_coumshin_value = sharedPreferences.getBoolean(COUMSHIN, false);
        stored_bun_value = sharedPreferences.getBoolean(BUN, false);
        stored_skellig_value = sharedPreferences.getBoolean(SKELLIG, false);
        stored_dunloe_value = sharedPreferences.getBoolean(DUNLOE, false);
        stored_gallarus_value = sharedPreferences.getBoolean(GALLARUS, false);
        stored_temple_value = sharedPreferences.getBoolean(TEMPLE, false);
        stored_athassel_value = sharedPreferences.getBoolean(ATHASSEL, false);
        stored_aherlow_value = sharedPreferences.getBoolean(AHERLOW, false);
        stored_curragh_value = sharedPreferences.getBoolean(CURRAGH, false);
        stored_gur_value = sharedPreferences.getBoolean(GUR, false);
        stored_tera_value = sharedPreferences.getBoolean(TERA, false);
        stored_doolin_value = sharedPreferences.getBoolean(DOOLIN, false);
        stored_dromore_value = sharedPreferences.getBoolean(DROMORE, false);
        stored_lahinch_value = sharedPreferences.getBoolean(LAHINCH, false);

    }

    public void updateTheScreenWhenAppReOpens(){

        //Assign the shared preference values (from above in loadData) to the actual controls on the GUI
        percent.setText(stored_progress_percentage_value);
        garBox.setChecked(stored_gar_value);
        loughBox.setChecked(stored_lough_value);
        donBox.setChecked(stored_don_value);
        ballyBox.setChecked(stored_bally_value);
        lismoreBox.setChecked(stored_lismore_value);
        comeraghBox.setChecked(stored_comeragh_value);
        coumshinBox.setChecked(stored_coumshin_value);
        bunBox.setChecked(stored_bun_value);
        skelligBox.setChecked(stored_skellig_value);
        dunloeBox.setChecked(stored_dunloe_value);
        gallarusBox.setChecked(stored_gallarus_value);
        templeBox.setChecked(stored_temple_value);
        athasselBox.setChecked(stored_athassel_value);
        aherlowBox.setChecked(stored_aherlow_value);
        curraghBox.setChecked(stored_curragh_value);
        gurBox.setChecked(stored_gur_value);
        teraBox.setChecked(stored_tera_value);
        doolinBox.setChecked(stored_doolin_value);
        dromoreBox.setChecked(stored_dromore_value);
        lahinchBox.setChecked(stored_lahinch_value);
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

    private void moveBackHome(){
        Intent intent = new Intent (Progress.this, HomePage. class);
        startActivity(intent);
    }
}


