package com.kingja.supershapeview;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Description:TODO
 * Create Time:2017/6/26 10:32
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class SuperShapeTextView extends AppCompatTextView implements IShape {

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
        superManager = new SuperManager();
        superManager.beSuperView(attrs, this);
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
