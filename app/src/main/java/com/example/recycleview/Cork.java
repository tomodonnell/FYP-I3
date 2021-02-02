package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

//This Java Class creates an array list and builds the RecyclerView, enabling the implementation the RecyclerView feature.
//Based on "Coding in FLow" Youtube lectures, however the code has been manipulated and styled to suit my solution.
//This is the link to the playlist of videos - https://www.youtube.com/watch?v=Nw9JF55LDzE&list=PLrnPJCHvNZuBtTYUuc5Pyo4V7xZ2HNtf4

public class Cork extends AppCompatActivity {

    private ArrayList<Cork_Item> corkItem;

    private RecyclerView mRecyclerView;
    private MyAdapterM mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_munster);

        createCorkList();
        buildRecyclerView();

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

    private void filter(String text) {
        ArrayList<Cork_Item> filteredList = new ArrayList<>();

        for (Cork_Item item : corkItem) {
            if (item.getText1().toLowerCase().startsWith(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
    }

    private void createCorkList(){
        corkItem = new ArrayList<>();
        corkItem.add(new Cork_Item(R.drawable.rsz_place, "", ""));
        corkItem.add(new Cork_Item(R.drawable.rsz_garisland, "Garnish Island", "Garinis"));
        corkItem.add(new Cork_Item(R.drawable.rsz_loughhyne, "Lough Hyne", "Loch Oighinn"));
        corkItem.add(new Cork_Item(R.drawable.rsz_donwildlife, "Doneraile Park", "Páirc Dún ar Aill"));
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapterM(corkItem);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}