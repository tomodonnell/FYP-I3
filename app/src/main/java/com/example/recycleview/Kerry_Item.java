package com.example.recycleview;

//This Java Class creates a custom object which helps implement the RecyclerView feature.
//Based on "Coding in FLow" Youtube lectures, however the code has been manipulated and styled to suit my solution.
//This is the link to the playlist of videos - https://www.youtube.com/watch?v=Nw9JF55LDzE&list=PLrnPJCHvNZuBtTYUuc5Pyo4V7xZ2HNtf4


public class Kerry_Item {
    private int mImageResource1;
    private int mImageResource2;
    private String mText1;
    private String mText2;
    private String mText3;
    private String mText4;
    private String mText5;
    private String mText6;
    private String mText7;
    private String mText8;
    private String mText9;

    //Creating constructor for Attraction_Item, passing arguments into it and setting equal to variables
    public Kerry_Item(int imageResource1, int imageResource2, String text1, String text2,
                          String text3, String text4, String text5, String text6, String text7,
                          String text8, String text9) {

        mImageResource1 = imageResource1;
        mImageResource2 = imageResource2;
        mText1 = text1;
        mText2 = text2;
        mText3 = text3;
        mText4 = text4;
        mText5 = text5;
        mText6 = text6;
        mText7 = text7;
        mText8 = text8;
        mText9 = text9;
    }

    //Creating get methods to return above items
    public int getImageResource1() {
        return mImageResource1;
    }

    public int getImageResource2() {
        return mImageResource2;
    }

    public String getText1() {
        return mText1;
    }

    public String getText2() {
        return mText2;
    }

    public String getText3() {
        return mText3;
    }

    public String getText4() {
        return mText4;
    }

    public String getText5() {
        return mText5;
    }

    public String getText6() {
        return mText6;
    }

    public String getText7() {
        return mText7;
    }

    public String getText8() {
        return mText8;
    }

    public String getText9() {
        return mText9;
    }

}

