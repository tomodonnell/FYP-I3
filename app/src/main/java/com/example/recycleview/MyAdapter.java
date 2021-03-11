package com.example.recycleview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//This Java Class is used as an adapter to help implement the RecyclerView feature (a bridge between the array list and the recycler view, cannot load all items at once)
//Based on "Coding in FLow" Youtube lectures, however the code has been manipulated and styled to suit my solution.
//This is the link to the playlist of videos - https://www.youtube.com/watch?v=Nw9JF55LDzE&list=PLrnPJCHvNZuBtTYUuc5Pyo4V7xZ2HNtf4

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ExampleViewHolder> {

    //Creating variable to contain list, allowing us to pass to adapter
    private ArrayList<Province_Item> mProvince_Item;

    //Creating a viewholder to group multiple items in a list
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        private final Context context;

        //Assigning variables to view ids from xml layout
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.myImageView);
            mTextView1 = itemView.findViewById(R.id.myText1);
            mTextView2 = itemView.findViewById(R.id.myText2);
            context = itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                //Switch case for onlcikclistener, this brings the user to different activities depending on which option they select
                public void onClick(View v) {
                    final Intent intent;
                    switch (getAdapterPosition()) {
                        case 0:
                            intent = new Intent(context, Attraction.class);
                            break;

                        case 1:
                            intent = new Intent(context, Attraction.class);
                            break;

                        case 2:
                            intent = new Intent(context, Munster.class);
                            break;

                        default:
                            intent = new Intent(context, Munster.class);
                            break;
                    }
                    context.startActivity(intent);
                }
            });
        }
    }

    //Passing data from array list into adapter by passing in constructor
    public MyAdapter(ArrayList<Province_Item> provinceitem) {
        mProvince_Item = provinceitem;
    }

    @NonNull
    @Override
    //Passing layout from xml file
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Province_Item currentItem = mProvince_Item.get(position);

        //Passing values to our variables by setting equal to items from Province_Item.java
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    //Returns number of items in the list
    public int getItemCount() {
        return mProvince_Item.size();
    }

    //Creating filter list method
    public void filterList(ArrayList<Province_Item> filteredList) {
        mProvince_Item = filteredList;
        notifyDataSetChanged();
    }

}

