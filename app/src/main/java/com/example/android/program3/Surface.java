package com.example.android.program3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class Surface extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder holder = null;
    private Paint paint = null;
    private float x, y = 0;
    private String title;
    private String xAxis;
    private String yAxis;
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public Surface(Context context){
        super(context);
        holder = getHolder();
        paint = new Paint();
        paint.setColor(Color.RED);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder){

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int left, int top, int i){

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder){
        paint = null;
    }

    public void drawBrick() {
        holder = getHolder();
        Canvas canvas = holder.lockCanvas();


        // Draw the rectangle.
        canvas.drawRect(x, y, x + 200, y + 200, paint);

        holder.unlockCanvasAndPost(canvas);

    }
    public void drawBall(){

        holder = getHolder();
        Canvas canvas = holder.lockCanvas();
        for(int i=0;i<50;i++){
            canvas.drawCircle(100, 100, 10, paint);
        }


        holder.unlockCanvasAndPost(canvas);
    }
}
