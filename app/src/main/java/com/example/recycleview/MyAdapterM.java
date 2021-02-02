package com.example.recycleview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//This Java Class helps acts as an adapter to help implement a RecyclerView, which is populated by an array list. The code is based on a series of free YouTube tutorials
//available through the page "Coding in FLow". These lectures have been used as a basis to implement the recyclerview feature,
//however the code has been manipulated and styled to suit my solution.
//This is the link to the playlist of videos - https://www.youtube.com/watch?v=Nw9JF55LDzE&list=PLrnPJCHvNZuBtTYUuc5Pyo4V7xZ2HNtf4

public class MyAdapterM extends RecyclerView.Adapter<MyAdapterM.ExampleViewHolder> {

    private ArrayList<Cork_Item> mCork_Item;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        private final Context context;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.myImageView);
            mTextView1 = itemView.findViewById(R.id.myText1);
            mTextView2 = itemView.findViewById(R.id.myText2);
            context = itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
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

    public MyAdapterM(ArrayList<Cork_Item> corkitem) {
        mCork_Item = corkitem;
    }

    @NonNull
    @Override
    public MyAdapterM.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        MyAdapterM.ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.recycleview.MyAdapterM.ExampleViewHolder holder, int position) {
        Cork_Item currentItem = mCork_Item.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mCork_Item.size();
    }

    public void filterList(ArrayList<Cork_Item> filteredList) {
        mCork_Item = filteredList;
        notifyDataSetChanged();

    }

}