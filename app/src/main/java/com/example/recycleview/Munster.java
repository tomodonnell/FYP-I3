package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SearchView;

import java.util.ArrayList;

//This Java Class creates an array list and builds the RecyclerView, enabling the implementation the RecyclerView feature.
//Based on "Coding in FLow" Youtube lectures, however the code has been manipulated and styled to suit my solution.
//This is the link to the playlist of videos - https://www.youtube.com/watch?v=Nw9JF55LDzE&list=PLrnPJCHvNZuBtTYUuc5Pyo4V7xZ2HNtf4

public class Munster extends AppCompatActivity {

    private ArrayList<Munster_Item> munsterItem;

    private RecyclerView mRecyclerView;
    private MyAdapterMunster mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);

        createMunsterList();
        buildRecyclerView();

        //Reference to edittext in xml file, listener takes note of changes in the textbox
        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

    }

    //Creating filter method, will be called every time the textbox is updated
    private void filter(String text) {
        //Creates a new array list based on what has been inputted into textbox
        ArrayList<Munster_Item> filteredList = new ArrayList<>();

        //Filters by "starts with"
        for (Munster_Item item : munsterItem) {
            if (item.getText1().toLowerCase().startsWith(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        //Passing filtered list to adapter
        mAdapter.filterList(filteredList);
    }
    //Creating array list
    private void createMunsterList() {
        munsterItem = new ArrayList<>();
        munsterItem.add(new Munster_Item(R.drawable.rsz_place, "", ""));
        munsterItem.add(new Munster_Item(R.drawable.rsz_cork, "Cork", "Corcaigh"));
        munsterItem.add(new Munster_Item(R.drawable.rsz_waterford, "Waterford", "Port Láirge"));
        munsterItem.add(new Munster_Item(R.drawable.rsz_kerry, "Kerry", "Chiarraí"));
        munsterItem.add(new Munster_Item(R.drawable.rsz_tipp, "Tipperary", "Thiobraid Árann"));
        munsterItem.add(new Munster_Item(R.drawable.rsz_limerick, "Limerick", "Luimneach"));
        munsterItem.add(new Munster_Item(R.drawable.rsz_clare, "Clare", "Chláir"));
    }

    //Initialising RecyclerView
    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapterMunster(munsterItem);

        //Layout manager aligns the items in the arraylist
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
