package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

//This Java Class creates an array list and builds the RecyclerView, enabling the implementation the RecyclerView feature.
//Based on "Coding in FLow" Youtube lectures, however the code has been manipulated and styled to suit my solution.
//This is the link to the playlist of videos - https://www.youtube.com/watch?v=Nw9JF55LDzE&list=PLrnPJCHvNZuBtTYUuc5Pyo4V7xZ2HNtf4

public class Attraction extends AppCompatActivity {

    private ArrayList<Attraction_Item> attractionItem;

    private RecyclerView mRecyclerView;
    private MyAdapterAttraction mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_munster);

        createAttractionList();
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
        ArrayList<Attraction_Item> filteredList = new ArrayList<>();

        //Filters by "starts with"
        for (Attraction_Item item : attractionItem) {
            if (item.getText1().toLowerCase().startsWith(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        //Passing filtered list to adapter
        mAdapter.filterList(filteredList);

    }

    //Creating array list
    private void createAttractionList() {
        attractionItem = new ArrayList<>();

        attractionItem.add(new Attraction_Item(R.drawable.maplogo, R.drawable.garisland,
                "Garnish Island, Cork",
                "Visitor Information",
                "Garnish Island, is an island in Glengarriff harbour, part of Bantry Bay in southwest Ireland. " +
                        "The garden, designed by Harold Peto, is renowned for its gardens and architecture. The gardens extend over 37 acres and its " +
                        "structures include a clock tower, a Grecian temple, a Matello Tower, and an Italian casita.",
                "Things To Do",
                "Visitors to Garnish Island, situated in the harbour of Glengarriff in Bantry Bay, Co. Cork can view some of the " +
                        "most spectacular and beautiful scenery the country has to offer by booking a fair through one of several ferry services available. " +
                        "These affordable ferries generally include a tour of the nearby seal colony, before arriving at the famous gardens.",
                "Perfect for?",
                "Perfect for couples looking to spend a day out together, as well as nature-loves who " +
                        "will love the unique green gardens and animal-lovers who can pose for photos with the seal colony.",
                "Your Location",
                "Garnish Island"));


        attractionItem.add(new Attraction_Item(R.drawable.maplogo, R.drawable.garisland,
                "Lough Hyne, Cork",
                "Visitor Infomation",
                "Lough Hyne is a fully marine sea lough in West Cork, Ireland, about 5 km southwest of " +
                        "Skibbereen. It was designated as Ireland's first Marine Nature Reserve in 1981. The lakes small size, creates an unusual " +
                        "habitat of highly oxygenated yet warm seawater that sustains an enormous variety of plants and animals.",
                "Things To Do",
                "Visitors can exhibition on the lough, where gain further information into its " +
                        "importance by visiting the nearby Skibbereen Heritage Centre. There are also many more sites to see, with the " +
                        "ruins of Saint Bridgit's Church are on the shores of the lake, as well as holy wells, Tobarín Súl and Skour Well, " +
                        "on the side of Knockomagh Hill. Castle Island is located in the center of the lake where the ruins of Cloghan Castle, " +
                        "once a fortress of the O'Driscoll clan, are still visible. A nature trail up Knockomagh Hill offers superb views of the " +
                        "lough and the surrounding area.",
                "Perfect for?",
                "Lough Hyne is a beautiful place for visitors who like to kayak and swim. " +
                        "It is also perfect for those looking to get out for some exercise, who can embark on a lovely 7Km level walk.",
                "Your Location",
                "Lough Hyne"));

        attractionItem.add(new Attraction_Item(R.drawable.maplogo, R.drawable.garisland,
                "Doneraile Park, Cork",
                "Visitor Infomation",
                "The Park comprises approximately 166 hectares and is an outstanding " +
                        "example of an 18th century landscaped park in the ‘Capability Brown’ style. " +
                        "Mature groves of deciduous trees, several restored water features and a number of deer herds " +
                        "can be viewed along the many pathways within the Park. The pathways are generally accessible for people with special needs.",
                "Things To Do",
                "Doneraile Court, the former residence of the St. Leger family, " +
                        "is situated within the Park. It is opened to the public following completion of restoration " +
                        "works, there is a Tea Rooms onsite (open 7 days a week) and New Large Children's Playground. " +
                        "There are a number of free guided tours throughout the year.",
                "Perfect for?",
                "Perfect attraction for those looking for a family day out, peaceful and pleasant for the adults,\n" +
                        "with a great playground for the kids as well as plenty of ducks and swans.",
                "Your Location",
                "Doneraile Park"));

        attractionItem.add(new Attraction_Item(R.drawable.maplogo, R.drawable.lismorecastle,
                "Lismore Castle, Waterford",
                "Visitor Infomation",
                "Built as the sister castle to Ardfinnan Castle in 1185 by the Lord of Ireland, Prince John of England to guard the river crossing, " +
                        "the castle site was originally occupied by Lismore Abbey, an important monastery and seat of learning established in the early 7th century. " +
                        "It was still an ecclesiastical centre when King Henry II of England stayed here in 1171. It was largely re-built in the Gothic style during " +
                        "the mid-nineteenth century for The 6th Duke of Devonshire." ,
                "Things To Do",
                "Although Lismore Castle itself is not open to the public, the 3 hectares of ornate and manicured gardens are well worth a visit. Thought to be the " +
                        "oldest landscaped gardens in Ireland, they are divided into the walled Jacobean upper garden and the less formal lower garden, the latter dotted with " +
                        "modern sculpture, including two chunks of the Berlin Wall. Highlights include a splendid yew walk, where Edmund Spenser is said to have written The Faerie Queen.",
                "Perfect for?",
                "Perfect for couples looking to spend a day out together, as well as nature-loves who " +
                        "will love the unique green gardens. Also suitable for families with a park nearby for children. ",
                "Your Location",
                "Lismore Castle"));

    }

    //Initialising RecyclerView
    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapterAttraction(attractionItem);

        //Layout manager aligns the items in the arraylist
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}