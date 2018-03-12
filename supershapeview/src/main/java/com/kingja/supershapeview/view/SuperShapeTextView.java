package com.kingja.supershapeview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;

import com.kingja.supershapeview.core.ISuperShape;
import com.kingja.supershapeview.core.SuperManager;

/**
 * Description:TODO
 * Create Time:2017/6/26 10:32
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class SuperShapeTextView extends AppCompatTextView implements ISuperShape {

    private static final String TAG = "SuperShapeTextView";
    private SuperManager superManager;

    public SuperShapeTextView(Context context) {
        super(context);
    }

    public SuperShapeTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initSuperShapeView(attrs);
    }


    public SuperShapeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initSuperShapeView(attrs);
    }

    private void initSuperShapeView(AttributeSet attrs) {
        superManager = new SuperManager(attrs,this);
        superManager.beSuperView();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        superManager.buildShape(null);
        //setBackground后会引起onDraw重绘制，因此不能再onDraw中调用buildShape，避免死循环
    }

    @Override
    public void setSolidColor(int solidColor) {
        superManager.setSolidColor(solidColor);
    }


    @Override
    public void setStrokeColor(int strokeColor) {
        superManager.setStrokeColor(strokeColor);
    }


    @Override
    public void setStrokeWidth(int strokeWidth) {
        superManager.setStrokeWidth(strokeWidth);
    }

    @Override
    public void setCorner(float corner) {
        superManager.setCorner(corner);
    }

    @Override
    public void setCorner(int leftTopCorner, int rightTopCorner, int rightBottomCorner, int leftBottomCorner) {
        superManager.setCorner(leftTopCorner, rightTopCorner, rightBottomCorner, leftBottomCorner);
    }

    @Override
    public Parcelable onSaveInstanceState() {
        return superManager.onSaveInstanceState(super.onSaveInstanceState());
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(superManager.onRestoreInstanceState(state));
    }


}
