package com.example.recycleview;

//This Java Class is used as an adapter to help implement the RecyclerView feature (a bridge between the array list and the recycler view, cannot load all items at once)
//Based on "Coding in FLow" Youtube lectures, however the code has been manipulated and styled to suit my solution.
//This is the link to the playlist of videos - https://www.youtube.com/watch?v=Nw9JF55LDzE&list=PLrnPJCHvNZuBtTYUuc5Pyo4V7xZ2HNtf4


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterW extends RecyclerView.Adapter<MyAdapterW.ExampleViewHolder> {

    //Creating variable to contain list, allowing us to pass to adapter
    private ArrayList<Waterford_Item> mWaterford_Item;

    //Creating a viewholder to group multiple items in a list
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView1;
        public ImageView mImageView2;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public TextView mTextView4;
        public TextView mTextView5;
        public TextView mTextView6;
        public TextView mTextView7;
        public TextView mTextView8;
        public TextView mTextView9;
        public Button mButton;
        public Button mButton2;

        private final Context context;

        //Assigning variables to view ids from xml layout
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView1 = itemView.findViewById(R.id.image1);
            mImageView2 = itemView.findViewById(R.id.image2);
            mTextView1 = itemView.findViewById(R.id.text1);
            mTextView2 = itemView.findViewById(R.id.text2);
            mTextView3 = itemView.findViewById(R.id.text3);
            mTextView4 = itemView.findViewById(R.id.text4);
            mTextView5 = itemView.findViewById(R.id.text5);
            mTextView6 = itemView.findViewById(R.id.text6);
            mTextView7 = itemView.findViewById(R.id.text7);
            mTextView8 = itemView.findViewById(R.id.edittext1);
            mTextView9 = itemView.findViewById(R.id.edittext2);
            mButton = itemView.findViewById(R.id.button1);
            mButton2 = itemView.findViewById(R.id.button2);
            context = itemView.getContext();


            //Setting onclick to bring provide user with directions to selected attraction
            //Based on tutorial from YouTube page "Android Coding"
            //Link available at - https://www.youtube.com/watch?v=VR8RKM9LTyA&t
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        //When google maps is installed
                        //Initialise uri
                        Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + mTextView8.getText() + "/" + mTextView9.getText());

                        //Initialise intent with action view
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        //Set package
                        intent.setPackage("com.google.android.apps.maps");
                        //Set flag
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        //Start activity
                        context.startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        //When google map is not installed
                        //Initialise uri
                        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
                        //Initialise intent with action view
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        //Set flag
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        //Start activity
                        context.startActivity(intent);
                    }
                }
            });

            //Setting onclick to open share option within device, with custom text
            //Based on tutorial from YouTube page "Sabith Pkc Mnr"
            //Link available at - https://www.youtube.com/watch?v=NdtE_1u0cq4
            mButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(Intent.ACTION_SEND);
                    myIntent.setType("text/plain");
                    String shareBody = "I visited " + mTextView9.getText() + " today! It was beautiful! " +
                            "Check out the 'Undiscovered Ireland' app on the Google Play Store if you want to discover " +
                            "unique areas from every county in Ireland!";
                    String shareSub = "It was really fun";
                    myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                    myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    context.startActivity(Intent.createChooser(myIntent, "Share Your Visit Using"));
                }
            });

        }

    }

    //Passing data from array list into adapter by passing in constructor
    public MyAdapterW(ArrayList<Waterford_Item> waterforditem) {
        mWaterford_Item = waterforditem;
    }

    @NonNull
    @Override
    //Passing layout from xml file
    public MyAdapterW.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.attraction_profile, parent, false);
        MyAdapterW.ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.recycleview.MyAdapterW.ExampleViewHolder holder, int position) {

        //Passing values to our variables by setting equal to items from Province_Item.java
        Waterford_Item currentItem = mWaterford_Item.get(position);
        holder.mImageView1.setImageResource(currentItem.getImageResource1());
        holder.mImageView2.setImageResource(currentItem.getImageResource2());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
        holder.mTextView3.setText(currentItem.getText3());
        holder.mTextView4.setText(currentItem.getText4());
        holder.mTextView5.setText(currentItem.getText5());
        holder.mTextView6.setText(currentItem.getText6());
        holder.mTextView7.setText(currentItem.getText7());
        holder.mTextView8.setText(currentItem.getText8());
        holder.mTextView9.setText(currentItem.getText9());

    }

    @Override
    //Returns number of items in the list
    public int getItemCount() {
        return mWaterford_Item.size();
    }

    //Creating filter list method
    public void filterList(ArrayList<Waterford_Item> filteredList) {
        mWaterford_Item = filteredList;
        notifyDataSetChanged();

    }

}