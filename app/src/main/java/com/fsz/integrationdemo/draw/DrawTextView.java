package com.fsz.integrationdemo.draw;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by fangsaizhang734 on 2019/1/31.
 */

public class DrawTextView extends TextView {

    public DrawTextView(Context context) {
        this(context,null);
    }

    public DrawTextView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public DrawTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private float preX;
    private float preY;

    private void init() {

    }

    private void stretchViewLeft(float left){
//        ViewGroup.LayoutParams params = getLayoutParams();
//        params.width = (int) (getWidth() - left);
//        Log.e("fsz","width:" + params.width );
//        setLayoutParams(params);

        Log.e("fsz","----------------------------" + left);
        layout((int) (getLeft() + left),getTop(),getRight(),getBottom());
    }

    private void stretchViewRight(float right){
//        ViewGroup.LayoutParams params = getLayoutParams();
//        params.width = (int) (getWidth() + right);
//        Log.e("fsz","width:" + params.width );
//        setLayoutParams(params);

        Log.e("fsz","----------------------------" + right);
        layout(getLeft(), getTop(), (int) (getRight() + right),getBottom());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float left = getX();
        float right =  left + getWidth();
        float touchX = event.getRawX();

        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(x - preX);
                float dy = Math.abs(y - preY);
                Log.e("fsz","----------------------------");
//                if (dx >= 5){
                    if (touchX > (left - 30) && touchX < (left + 30)){
                        stretchViewLeft(x - preX);
                    }
                    if (touchX > (right - 30) && touchX < (right + 30)){
                        stretchViewRight(x - preX);
                    }
                    preX = x;
                    preY = y;
//                }
                break;
        }
        return true;
    }

}
