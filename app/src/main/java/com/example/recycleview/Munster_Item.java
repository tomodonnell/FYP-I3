package com.example.recycleview;

//This Java Class creates a custom object which helps implement the RecyclerView feature.
//Based on "Coding in FLow" Youtube lectures, however the code has been manipulated and styled to suit my solution.
//This is the link to the playlist of videos - https://www.youtube.com/watch?v=Nw9JF55LDzE&list=PLrnPJCHvNZuBtTYUuc5Pyo4V7xZ2HNtf4


public class Munster_Item {
    private int mImageResource;
    private String mText1;
    private String mText2;

    //Creating constructor for Munster_Item, passing arguments into it and setting equal to variables
    public Munster_Item(int imageResource, String text1, String text2) {
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
    }

    //Creating get methods to return above items
    public int getImageResource() {
        return mImageResource;
    }

    public String getText1() {
        return mText1;
    }

    public String getText2() {
        return mText2;
    }
}
