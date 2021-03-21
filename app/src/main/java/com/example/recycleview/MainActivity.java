package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

//This Java Class creates an array list and builds the RecyclerView, enabling the implementation the RecyclerView feature.
//Based on "Coding in FLow" Youtube lectures, however the code has been manipulated and styled to suit my solution.
//This is the link to the playlist of videos - https://www.youtube.com/watch?v=Nw9JF55LDzE&list=PLrnPJCHvNZuBtTYUuc5Pyo4V7xZ2HNtf4

public class MainActivity extends AppCompatActivity {
    private ArrayList<Province_Item> provinceItem;

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createProvinceList();
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
        ArrayList<Province_Item> filteredList = new ArrayList<>();

        //Filters by "starts with"
        for (Province_Item item : provinceItem) {
            if (item.getText1().toLowerCase().startsWith(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        //Passing filtered list to adapter
        mAdapter.filterList(filteredList);
    }

    //Creating array list
    private void createProvinceList() {
        provinceItem = new ArrayList<>();
        provinceItem.add(new Province_Item(R.drawable.rsz_udivisit, "", ""));
        provinceItem.add(new Province_Item(R.drawable.rsz_ireland, "Ireland", "Éire"));
        provinceItem.add(new Province_Item(R.drawable.rsz_munster, "Munster", "Mhumhain"));
        provinceItem.add(new Province_Item(R.drawable.rsz_leinster, "Leinster", "Laighin"));
        provinceItem.add(new Province_Item(R.drawable.rsz_connacht, "Connacht", "Connachta"));
        provinceItem.add(new Province_Item(R.drawable.rsz_ulster, "Ulster", "Ulaidh"));

    }

    //Initialising RecyclerView
    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(provinceItem);

        //Layout manager aligns the items in the arraylist
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}