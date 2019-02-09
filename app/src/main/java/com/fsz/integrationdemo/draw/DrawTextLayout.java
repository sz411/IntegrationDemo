package com.fsz.integrationdemo.draw;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by fsz on 2019/2/3.
 */

public class DrawTextLayout extends View {

    public DrawTextLayout(Context context) {
        super(context);
    }

    public DrawTextLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawTextLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
