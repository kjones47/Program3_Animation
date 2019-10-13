package com.example.android.program3;

import android.graphics.Color;
import android.graphics.ColorSpace;

public class Brick {

    boolean show;
    int color = Color.GREEN;
    int leftX;
    int rightX;
    int topY;
    int bottomY;

    public Brick(){
        show = true;
        color = Color.BLUE;
    }

    public void setColor(int c){
        color = c;
    }

    public void makeBrick(){
        show = true;
    }

    public void breakBrick(int c){
        show = false;
    }
    public boolean showBrick(){
            return show;
    }

}
