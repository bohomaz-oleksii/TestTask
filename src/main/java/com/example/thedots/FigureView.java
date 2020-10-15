package com.example.thedots;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


import java.util.ArrayList;
import java.util.Random;

public class FigureView extends View {



    private Random random = new Random();


    private Paint mPaint = new Paint();

    private Point a, b, c, a1, b1, c1, rand ,nextPoint;
    private Point[] array = new Point[3];
    private Point[] array1 = new Point[3];
    private Boolean isCheck = false;
    private Boolean isAr = true;




    private Boolean mode = true;

    private ArrayList<Integer> floats = new ArrayList<>();

    public void clearDisplay(){
        floats.clear();
        isCheck = false;
    }

    public void setMode(Boolean mode) { this.mode = mode; }
    public Boolean getMode() { return mode; }

    public FigureView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!isCheck){
            a = new Point(random.nextInt(canvas.getWidth()), random.nextInt(canvas.getHeight()));
            a1 = new Point(random.nextInt(canvas.getWidth()), random.nextInt(canvas.getHeight()));
            b = new Point(random.nextInt(canvas.getWidth()), random.nextInt(canvas.getHeight()));
            b1 = new Point(random.nextInt(canvas.getWidth()), random.nextInt(canvas.getHeight()));
            c = new Point(random.nextInt(canvas.getWidth()), random.nextInt(canvas.getHeight()));
            c1 = new Point(random.nextInt(canvas.getWidth()), random.nextInt(canvas.getHeight()));
            rand = new Point(random.nextInt(canvas.getWidth()), random.nextInt(canvas.getHeight()));
            array[0] = a;
            array1[0] = a1;
            array[1] = b;
            array1[1] = b1;
            array[2] = c;
            array1[2] = c1;

            Log.d("TAG", "create Point");
            isCheck = true;
            floats.add(a.x);
            floats.add(a.y);
            floats.add(b.x);
            floats.add(b.y);
            floats.add(c.x);
            floats.add(c.y);
            floats.add(a1.x);
            floats.add(a1.y);
            floats.add(b1.x);
            floats.add(b1.y);
            floats.add(c1.x);
            floats.add(c1.y);
            floats.add(rand.x);
            floats.add(rand.y);
        }

        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(canvas.getWidth()/230);
        mPaint.setStyle(Paint.Style.STROKE);



        float arr[] = new float[floats.size()];
         for(int i = 0; i < floats.size(); i++){
             arr[i] = floats.get(i);
        }
        canvas.drawPoints(arr,mPaint);


        int r = random.nextInt(3);
        //Log.d("TAG", "Random =  "+r);
        Point next;
        if(mode){
            next = array[r];
        }else {
            if (isAr) {
                next = array[r];
                isAr = false;
                Log.d("TAG", "Array 0   ");
            } else {
                next = array1[r];
                isAr = true;
                Log.d("TAG", "Array 1   ");
            }
        }
        //Log.d("TAG", "point"+ next.x + " " + next.y);
            nextPoint = new Point();
            rand.x = (next.x + rand.x) / 2;
            rand.y = (next.y + rand.y) / 2;
            canvas.drawPoint(rand.x, rand.y, mPaint);

            floats.add(rand.x);
            floats.add(rand.y);

    }


}

