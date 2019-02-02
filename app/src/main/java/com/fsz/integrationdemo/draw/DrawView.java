package com.fsz.integrationdemo.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fangsaizhang734 on 2019/1/30.
 */

public class DrawView extends View{

    public DrawView(Context context) {
        this(context,null);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Path path;
    private float preX;
    private float preY;
    Canvas cacheCanvas = null;

    private Paint paint;
    List<PointF> pointFS = new ArrayList<>();

    private void init() {
        path = new Path();
        cacheCanvas = new Canvas();

        paint = new Paint(Paint.DITHER_FLAG);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint bmpPaint = new Paint();
        canvas.drawPath(path,paint);
        canvas.save(Canvas.ALL_SAVE_FLAG);
        for (PointF pointF : pointFS){
            Log.e("fsz","x:" + pointF.x + "   y:" + pointF.y);
            Log.e("fsz","**********************************");
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                preX = x;
                preY = y;
                pointFS.add(new PointF(x,y));
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(x - preX);
                float dy = Math.abs(y - preY);
                if (dx >= 30 || dy >= 30){
                    path.quadTo(preX,preY,(x + preX)/2,(y + preY)/2);
                    preX = x;
                    preY = y;
                    pointFS.add(new PointF(x,y));
                }
                break;
            case MotionEvent.ACTION_UP:
                cacheCanvas.drawPath(path,paint);
                path.reset();
                pointFS.add(new PointF(x,y));
                break;
        }
        invalidate();
        return true;
    }
}
