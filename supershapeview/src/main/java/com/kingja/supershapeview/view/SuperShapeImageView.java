package com.kingja.supershapeview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
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
public class SuperShapeImageView extends AppCompatImageView implements ISuperShape {

    private static final String TAG = "SuperShapeImageView";
    private SuperManager superManager;

    public SuperShapeImageView(Context context) {
        super(context);
    }

    public SuperShapeImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initSuperShapeView(attrs);
    }

    public SuperShapeImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initSuperShapeView(attrs);
    }

    private void initSuperShapeView(AttributeSet attrs) {
        Log.e(TAG, "initSuperShapeView: ");
        superManager = new SuperManager(attrs, this);
        superManager.beSuperImageView();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.e(TAG, "onDraw: ");
        superManager.buildShape(canvas);
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
