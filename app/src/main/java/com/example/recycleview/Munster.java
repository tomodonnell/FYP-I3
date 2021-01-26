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

public class Munster extends AppCompatActivity {

    private ArrayList<Munster_Item> munsterItem;

    private RecyclerView mRecyclerView;
    private MyAdapterMunster mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createMunsterList();
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
                ArrayList<Munster_Item> filteredList = new ArrayList<>();

                for (Munster_Item item : munsterItem) {
                    if (item.getText1().toLowerCase().startsWith(text.toLowerCase())) {
                        filteredList.add(item);
                    }
                }
                    mAdapter.filterList(filteredList);
                }

         private void createMunsterList(){
            munsterItem = new ArrayList<>();
            munsterItem.add(new Munster_Item(R.drawable.rsz_place, "", ""));
            munsterItem.add(new Munster_Item(R.drawable.rsz_cork, "Cork", "Lovely Place"));
            munsterItem.add(new Munster_Item(R.drawable.rsz_kerry, "Kerry", "Lovely Place"));
            munsterItem.add(new Munster_Item(R.drawable.rsz_waterford, "Waterford", "Lovely Place"));
            munsterItem.add(new Munster_Item(R.drawable.rsz_tipp, "Tipperary", "Lovely Place"));
            munsterItem.add(new Munster_Item(R.drawable.rsz_limerick, "Limerick", "Lovely Place"));
            munsterItem.add(new Munster_Item(R.drawable.rsz_clare, "Clare", "Lovely Place"));
        }

        private void buildRecyclerView() {
            mRecyclerView = findViewById(R.id.recyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new MyAdapterMunster(munsterItem);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
        }
    }
