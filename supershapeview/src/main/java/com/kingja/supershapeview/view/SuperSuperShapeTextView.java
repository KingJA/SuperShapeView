package com.kingja.supershapeview.view;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.kingja.supershapeview.core.ISuperShape;
import com.kingja.supershapeview.core.SuperManager;

/**
 * Description:TODO
 * Create Time:2017/6/26 10:32
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class SuperSuperShapeTextView extends AppCompatTextView implements ISuperShape {

    private SuperManager superManager;

    public SuperSuperShapeTextView(Context context) {
        super(context);
    }

    public SuperSuperShapeTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initSuperShapeView(attrs);
    }


    public SuperSuperShapeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
