package com.example.mobiledev2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class SimplePaint extends View {
    Path myPath;
    Paint myPaint;


    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        myPaint = new Paint();
        myPath = new Path();

        myPaint.setColor(Color.BLACK);
        myPaint.setStrokeWidth(15);
        myPaint.setAntiAlias(true);
        myPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(myPath, myPaint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                myPath.moveTo(x,y);
                invalidate();
                return(true);
            case MotionEvent.ACTION_MOVE:
                myPath.lineTo(x,y);
                invalidate();
                return(true);
            case MotionEvent.ACTION_UP:
                break;
        }

        invalidate();

        return super.onTouchEvent(event);
    }

    public void clearDrawing(){
        myPath.reset();
        invalidate();
    }
}