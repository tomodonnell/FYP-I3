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

public class MyAdapterMunster extends RecyclerView.Adapter<MyAdapterMunster.ExampleViewHolder> {

    private ArrayList<Munster_Item> mMunster_Item;

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

    public MyAdapterMunster(ArrayList<Munster_Item> munsteritem) {
        mMunster_Item = munsteritem;
    }

    @NonNull
    @Override
    public MyAdapterMunster.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        MyAdapterMunster.ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.recycleview.MyAdapterMunster.ExampleViewHolder holder, int position) {
        Munster_Item currentItem = mMunster_Item.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mMunster_Item.size();
    }

    public void filterList(ArrayList<Munster_Item> filteredList) {
        mMunster_Item = filteredList;
        notifyDataSetChanged();

    }

}

