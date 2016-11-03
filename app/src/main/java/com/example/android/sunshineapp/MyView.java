package com.example.android.sunshineapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Gabe on 2016-11-01.
 */
public class MyView extends View{


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int hSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int hSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int myHeight = hSpecSize;

        if (hSpecMode == MeasureSpec.EXACTLY){
            myHeight = hSpecMode;
        } else if (hSpecMode == MeasureSpec.AT_MOST){
            myHeight = hSpecMode; // wrap_content
        }

        int wSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int wSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int myWidth = wSpecSize;

        if (wSpecMode == MeasureSpec.EXACTLY){
            myWidth = wSpecSize;
        } else if (wSpecMode == MeasureSpec.AT_MOST){
            myWidth = wSpecMode; // wrap_content
        }

        setMeasuredDimension(myWidth, myHeight);
    }

    private int mAngle;
    private int mSpeed;

    protected void setAngle(int angle) {
        mAngle = angle;
    }
    protected void setSpeed(int speed) {
        mSpeed = speed > 100 ? 100: speed;
    }
    protected void setAngleSpeed (int angle, int speed) {
        mAngle = angle;
        mSpeed = speed > 100 ? 100: speed;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int myHeigth = canvas.getHeight();
        int myWidth = canvas.getWidth();
        int myMaxLen;
        int myLen;
        Paint myPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        myPaint.setColor(0xff101010);
        myPaint.setAntiAlias(true);
        myPaint.setStrokeWidth(1+myWidth/15);
        if (myHeigth>myWidth)
            myMaxLen=myWidth;
        else
            myMaxLen=myHeigth;

        myLen = myMaxLen * (mSpeed / 100);

        int myWCenter = myWidth/2;
        int myHCenter = myHeigth/2;

        canvas.drawLine(myWCenter,myHCenter,myWCenter-myLen,myHCenter,myPaint);
        canvas.rotate(mAngle,myWCenter,myHCenter);
    }
}
