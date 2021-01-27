package com.example.recycleview;

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

public class MyAdapterAttraction extends RecyclerView.Adapter<MyAdapterAttraction.MyViewHolder>{

    String attraction[], visitor[], todo[], recommend[], destination[];
    Button btnguide;
    int images[];
    Context context;

    public MyAdapterAttraction(Context ct, String s1[], String s2[], String s3[], String s4[], String s5[],
                               int img[], Button btn1){
        context = ct;
        attraction = s1;
        visitor = s2;
        todo = s3;
        recommend = s4;
        destination = s5;
        images = img;
        btnguide = btn1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.attraction_profile, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.attraction.setText(attraction[position]);
        holder.visitor.setText(visitor[position]);
        holder.todo.setText(todo[position]);
        holder.recommend.setText(recommend[position]);
        holder.attraction_destination.setText(destination[position]);
        holder.myImage.setImageResource(images[position]);

        holder.btndirections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    //When google maps is installed
                    //Initialise uri
                    Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + "Your Location" + "/" + (destination[position]));

                    //Initialise intent with action view
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    //Set package
                    intent.setPackage("com.google.android.apps.maps");
                    //Set flag
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //Start activity
                    context.startActivity(intent);
                }catch (ActivityNotFoundException e){
                    //When google map is not installed
                    //Initialise uri
                    Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
                    //Initialise intent with action view
                    Intent intent = new  Intent(Intent.ACTION_VIEW,uri);
                    //Set flag
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //Start activity
                    context.startActivity(intent);
                }
            }


        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView attraction, visitor, todo, recommend, attraction_destination;
        ImageView myImage;
        Button btndirections;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            attraction = itemView.findViewById(R.id.attractionTitle);
            visitor = itemView.findViewById(R.id.txtvisitor);
            todo = itemView.findViewById(R.id.txttodo);
            recommend = itemView.findViewById(R.id.txtrecommend);
            attraction_destination = itemView.findViewById(R.id.txtDestination);
            myImage = itemView.findViewById(R.id.imgattraction);
            btndirections = itemView.findViewById(R.id.btnDirections);

        }
    }
}