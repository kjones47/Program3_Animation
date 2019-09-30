package com.example.android.program3;

import android.graphics.Color;
import android.graphics.ColorSpace;

public class Brick {

    boolean hit;
    int color = Color.GREEN;

    public Brick(){
        hit = false;
        color = Color.BLUE;
    }

    public void setColor(int c){
        color = c;
    }

    public void makeBrick(){
        hit = false;
    }

    public void breakBrick(int c){
        hit = true;
    }

}
