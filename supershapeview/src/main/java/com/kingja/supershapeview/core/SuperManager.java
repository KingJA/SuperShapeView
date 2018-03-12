package com.kingja.supershapeview.core;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.kingja.supershapeview.shape.CommonShape;
import com.kingja.supershapeview.shape.ImageShape;
import com.kingja.supershapeview.R;
import com.kingja.supershapeview.shape.IBuilder;

/**
 * Description:TODO
 * Create Time:2017/7/7 15:49
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class SuperManager implements ISuperShape {
    private static final String TAG = "SuperManager";
    private View view;
    private SuperConfig superConfig;
    private IBuilder builder;

    public SuperManager(AttributeSet attrs, View view) {
        this.view = view;
        obtainAttrs(attrs);
    }

    public void beSuperView() {
        builder = new CommonShape(view);
        setSuperConfig(superConfig);
    }

    public void beSuperImageView() {
        builder = new ImageShape(view);
        setSuperConfig(superConfig);
    }

    private void obtainAttrs(AttributeSet attrs) {
        TypedArray typedArray = view.getContext().obtainStyledAttributes(attrs, R.styleable.SuperShapeView);
        superConfig = new SuperConfig();
        superConfig.setCornerRadius(typedArray.getDimension(R.styleable.SuperShapeView_super_cornerRadius,
                SuperConfig.DEFAULT_CORNER_RADIUS));
        superConfig.setStrokeColor(typedArray.getColor(R.styleable.SuperShapeView_super_strokeColor,
                SuperConfig.DEFAULT_STROKE_COLOR));
        superConfig.setSolidColor(typedArray.getColor(R.styleable.SuperShapeView_super_solidColor,
                SuperConfig.DEFAULT_SOLID_COLOR));
        superConfig.setStrokeWidth((int) typedArray.getDimension(R.styleable.SuperShapeView_super_strokeWidth,
                SuperConfig.DEFAULT_STROKE_WIDTH));
        superConfig.setDashWidth(typedArray.getDimension(R.styleable.SuperShapeView_super_dashWidth,
                SuperConfig.DEFAULT_DASHWIDTH));
        superConfig.setDashGap(typedArray.getDimension(R.styleable.SuperShapeView_super_dashGap, SuperConfig
                .DEFAULT_DASHGAP));
        superConfig.setTopLeftRadius(typedArray.getDimension(R.styleable.SuperShapeView_super_topLeftRadius,
                SuperConfig.DEFAULT_TOP_LEFT_RADIUS));
        superConfig.setTopRightRadius(typedArray.getDimension(R.styleable.SuperShapeView_super_topRightRadius,
                SuperConfig.DEFAULT_TOP_RIGHT_RADIUS));
        superConfig.setBottomLeftRadius(typedArray.getDimension(R.styleable.SuperShapeView_super_bottomLeftRadius,
                SuperConfig.DEFAULT_BOTTOM_LEFT_RADIUS));
        superConfig.setBottomRightRadius(typedArray.getDimension(R.styleable.SuperShapeView_super_bottomRightRadius,
                SuperConfig.DEFAULT_BOTTOM_IGHT_RADIUS));
        typedArray.recycle();
    }


    private int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, view.getContext().getResources()
                .getDisplayMetrics());
    }

    @Override
    public void setSolidColor(int solidColor) {
        superConfig.setSolidColor(solidColor);
        builder.modifyAttr();
    }

    @Override
    public void setStrokeColor(int strokeColor) {
        superConfig.setStrokeColor(strokeColor);
        builder.modifyAttr();
    }

    @Override
    public void setStrokeWidth(int strokeWidth) {
        superConfig.setStrokeWidth(dp2px(strokeWidth));
        builder.modifyAttr();
    }

    @Override
    public void setCorner(float corner) {
        superConfig.setCornerRadius(dp2px(corner));
        builder.modifyAttr();
    }

    @Override
    public void setCorner(int topLeftRadius, int topRightRadius, int bottomRightRadius, int bottomLeftRadius) {
        superConfig.setTopLeftRadius(topLeftRadius);
        superConfig.setTopRightRadius(topRightRadius);
        superConfig.setBottomLeftRadius(bottomLeftRadius);
        superConfig.setBottomRightRadius(bottomRightRadius);
        builder.modifyAttr();
    }

    private void restore(SuperConfig superConfig) {
        this.superConfig = superConfig;
        setSuperConfig(superConfig);
//        buildShape(canvas);
    }

    public Parcelable onSaveInstanceState(Parcelable superState) {
        SavedState ss = new SavedState(superState);
        ss.superConfig = superConfig;
        Log.e(TAG, "onSaveInstanceState: " + ss.superConfig.getCornerRadius());
        return ss;
    }

    public Parcelable onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        Log.e(TAG, "onRestoreInstanceState: " + ss.superConfig.getCornerRadius());
        restore(ss.superConfig);
        return ss.getSuperState();
    }

    public void buildShape(Canvas canvas) {
        builder.buildShape(canvas);
    }

    public void setSuperConfig(SuperConfig superConfig) {
        builder.setSuperConfig(superConfig);
    }

    static class SavedState extends View.BaseSavedState {
        SuperConfig superConfig;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            superConfig = (SuperConfig) in.readSerializable();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeSerializable(superConfig);
        }

        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            @Override
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }
}
