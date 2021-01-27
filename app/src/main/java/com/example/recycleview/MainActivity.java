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
                ArrayList<Province_Item> filteredList = new ArrayList<>();

                for (Province_Item item : provinceItem) {
                    if (item.getText1().toLowerCase().startsWith(text.toLowerCase())) {
                    filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);

        }

        private void createProvinceList() {
            provinceItem = new ArrayList<>();
            provinceItem.add(new Province_Item(R.drawable.rsz_place, "", ""));
            provinceItem.add(new Province_Item(R.drawable.rsz_ireland, "Ireland", "Éire"));
            provinceItem.add(new Province_Item(R.drawable.rsz_munster, "Munster", "An Mhumhain"));
            provinceItem.add(new Province_Item(R.drawable.rsz_leinster, "Leinster", "Laighin"));
            provinceItem.add(new Province_Item(R.drawable.rsz_connacht, "Connacht", "Connachta"));
            provinceItem.add(new Province_Item(R.drawable.rsz_ulster, "Ulster", "Ulaidh"));

        }

        private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(provinceItem);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}