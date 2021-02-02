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

//This Java Class is used as an adapter to help implement the RecyclerView feature (a bridge between the array list and the recycler view)
//Based on "Coding in FLow" Youtube lectures, however the code has been manipulated and styled to suit my solution.
//This is the link to the playlist of videos - https://www.youtube.com/watch?v=Nw9JF55LDzE&list=PLrnPJCHvNZuBtTYUuc5Pyo4V7xZ2HNtf4

public class MyAdapterMunster extends RecyclerView.Adapter<MyAdapterMunster.ExampleViewHolder> {

    //Creating variable to contain list, allowing us to pass to adapter
    private ArrayList<Munster_Item> mMunster_Item;

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

                        default:
                            intent = new Intent(context, Attraction.class);
                            break;
                    }
                    context.startActivity(intent);
                }
            });
        }
    }

    //Passing data from array list into adapter by passing in constructor
    public MyAdapterMunster(ArrayList<Munster_Item> munsteritem) {
        mMunster_Item = munsteritem;
    }

    @NonNull
    @Override
    //Passing layout from xml file
    public MyAdapterMunster.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        MyAdapterMunster.ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.recycleview.MyAdapterMunster.ExampleViewHolder holder, int position) {
        Munster_Item currentItem = mMunster_Item.get(position);

        //Passing values to our variables by setting equal to items from Province_Item.java
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    //Returns number of items in the list
    public int getItemCount() {
        return mMunster_Item.size();
    }

    //Creating filter list method
    public void filterList(ArrayList<Munster_Item> filteredList) {
        mMunster_Item = filteredList;
        notifyDataSetChanged();

    }

}

