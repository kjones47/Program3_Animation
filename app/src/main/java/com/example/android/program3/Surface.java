package com.example.android.program3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Surface extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private float circleX = 0;
    private float circleY = 0;
    private float ballX = 400;
    private float ballY = 400;
    private float paddleX = 0;
    private float paddleY = 0;
    int xdir = 1;
    int ydir = 1;
    int lives = 3;
    private Brick [][] levelOne = new Brick [5][4];

    public Surface(Context context) {
        super(context);

        surfaceHolder = getHolder();

        paint = new Paint();
        paint.setColor(Color.RED);

        // this.getHolder().setFormat(PixelFormat.TRANSLUCENT);
        // paint.setStyle(Style.FILL);
        for(int i = 0; i< levelOne.length;i++){
            for(int j =0; j<levelOne[j].length;j++){
                levelOne[i][j] = new Brick();
            }
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        paint = null;

    }

    /* This method will be invoked to draw a circle in canvas. */
    public void drawBall()
    {
        surfaceHolder = getHolder();

        // Get and lock canvas object from surfaceHolder.
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
        surfaceBackground.setColor(Color.BLACK);
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        // Draw the circle.
        paint.setColor(Color.RED);
      //  canvas.drawCircle(circleX, circleY, 100, paint);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(ballX, ballY, 50, paint);
        //ball movement
        ballX = ballX +1;
        ballY = ballY + 1;

        // Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    /* This method will be invoked to draw a circle in canvas. */
    public void drawRect()
    {
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
        surfaceBackground.setColor(Color.BLUE);
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        // Draw the rectangle.
        canvas.drawRect(circleX, circleY, circleX + 200, circleY + 200, paint);

        surfaceHolder.unlockCanvasAndPost(canvas);
    }
    public void drawPaddle(float x, float y)
    {
        surfaceHolder = getHolder();

        // Get and lock canvas object from surfaceHolder.
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
     //   surfaceBackground.setColor(Color.BLACK);
        // Draw the surfaceview background color.
    //    canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        // Draw the circle.
     //   paint.setColor(Color.WHITE);
      //  canvas.drawCircle(circleX, circleY, 100, paint);
       // canvas.drawCircle(50, 50, 200, paint);

        paint.setColor(Color.RED);
        canvas.drawRect(x - this.getWidth()/4, this.getHeight()-200, x +this.getWidth()/4 + 300, this.getHeight()-125, paint);

        // Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }
    public int getLives(){
        return lives;
    }

    public void drawBricks() {

        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
        surfaceBackground.setColor(Color.BLUE);
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        if (lives > 0) {



            // Draw the rectangle.
            int height = 30;
            int end = this.getHeight() - 100;
            for (int i = 0; i < levelOne.length; i++) {
                for (int j = 0; j < levelOne[i].length; j++) {
                    if (levelOne[i][j].showBrick()) {
                        canvas.drawRect((i) * 200 + 40, (j + 1) * 100 + 40, (i + 1) * 200, (j + 2) * 100, paint);
                        if (j % 2 == 1) {
                            paint.setColor(Color.GREEN);
                        } else {
                            paint.setColor(Color.YELLOW);
                        }
                    }
                }
            }
            //draw paddle
            paint.setColor(Color.RED);
            canvas.drawRect(circleX - this.getWidth() / 8, this.getHeight() - 200, circleX + this.getWidth() / 8, this.getHeight() - 125, paint);

            //draw lives
            paint.setColor(Color.WHITE);
            int offset = 70;
            for (int i = 0; i < lives; i++) {
                canvas.drawCircle(60 + offset * i, 50, 30, paint);
            }

            //draw ball
            paint.setColor(Color.WHITE);
            canvas.drawCircle(ballX, ballY, 40, paint);
            //ball movement

            if (ballX >= this.getWidth() - 20) {
                xdir = -1;
            }
            if (ballX <= 20) {
                xdir = 1;
            }
            if (ballY >= this.getHeight() - 270) {
                if ((ballX > (circleX - this.getWidth() / 8)) && (ballX < circleX + this.getWidth() / 8)) {
                    ydir = -1;
                } else {
                    ballX = 0;
                    ballY = 0;
                    lives--;
                }
            }
            if (ballX <= 20) {
                ydir = 1;
            }
            if (xdir == 1) {
                ballX = ballX + 10;
            } else {
                ballX = ballX - 10;
            }
            if (ydir == 1) {
                ballY = ballY + 10;
            } else {
                ballY = ballY - 10;
            }

        }else{
            surfaceBackground.setColor(Color.BLACK);
            // Draw the surfaceview background color.
            canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);
            paint.setColor(Color.BLUE);
            paint.setTextSize(148f);
            canvas.drawText("You Win", 250,500, paint);
        }
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    public float getCircleX() {
        return circleX;
    }

    public void setCircleX(float circleX) {
        this.circleX = circleX;
    }
    public float getBallX() {
        return ballX;
    }

    public void setBallX(float ballX) {
        this.ballX = ballX;
    }

    public float getCircleY() {
        return circleY;
    }

    public void setCircleY(float circleY) {
        this.circleY = circleY;
    }
    public float getBallY() {
        return ballY;
    }

    public void setBallY(float ballY) {
        this.ballY = ballY;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}