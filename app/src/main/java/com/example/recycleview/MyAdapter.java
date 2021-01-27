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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ExampleViewHolder>{

    private ArrayList<Province_Item> mProvince_Item;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

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

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    final Intent intent;
                    switch (getAdapterPosition()){
                        case 0:
                            intent = new Intent(context, Munster.class);
                            break;

                        case 1:
                            intent = new Intent(context, Cork.class);
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

    public MyAdapter(ArrayList<Province_Item> provinceitem) {
        mProvince_Item = provinceitem;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Province_Item currentItem = mProvince_Item.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mProvince_Item.size();
    }

    public void filterList(ArrayList<Province_Item> filteredList){
        mProvince_Item = filteredList;
        notifyDataSetChanged();
    }

    }

