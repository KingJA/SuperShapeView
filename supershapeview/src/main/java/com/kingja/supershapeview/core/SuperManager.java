package com.kingja.supershapeview.core;

import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.kingja.supershapeview.R;

/**
 * Description:TODO
 * Create Time:2017/7/7 15:49
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class SuperManager implements ISuperShape {
    private static final float DEFAULT_CORNER_RADIUS = 0f;
    private static final float DEFAULT_STROKE_WIDTH = 0f;
    private static final int DEFAULT_STROKE_COLOR = 0;
    private static final int DEFAULT_SOLID_COLOR = 0;
    private static final float DEFAULT_DASHWIDTH = 0f;
    private static final float DEFAULT_DASHGAP = 0f;
    private static final float DEFAULT_TOP_LEFT_RADIUS = 0f;
    private static final float DEFAULT_TOP_RIGHT_RADIUS = 0f;
    private static final float DEFAULT_BOTTOM_LEFT_RADIUS = 0f;
    private static final float DEFAULT_BOTTOM_IGHT_RADIUS = 0f;
    private View view;
    private SuperConfig superConfig;

    public void beSuperView(AttributeSet attrs, View view) {
        this.view = view;
        obtainAttrs(attrs);
        setupGradientDrawable();
    }

    private void obtainAttrs(AttributeSet attrs) {
        TypedArray typedArray = view.getContext().obtainStyledAttributes(attrs, R.styleable.SuperShapeView);
        superConfig = new SuperConfig();
        superConfig.setCornerRadius(typedArray.getDimension(R.styleable.SuperShapeView_super_cornerRadius,
                DEFAULT_CORNER_RADIUS));
        superConfig.setStrokeColor(typedArray.getColor(R.styleable.SuperShapeView_super_strokeColor,
                DEFAULT_STROKE_COLOR));
        superConfig.setSolidColor(typedArray.getColor(R.styleable.SuperShapeView_super_solidColor,
                DEFAULT_SOLID_COLOR));
        superConfig.setStrokeWidth((int) typedArray.getDimension(R.styleable.SuperShapeView_super_strokeWidth,
                DEFAULT_STROKE_WIDTH));
        superConfig.setDashWidth(typedArray.getDimension(R.styleable.SuperShapeView_super_dashWidth,
                DEFAULT_DASHWIDTH));
        superConfig.setDashGap(typedArray.getDimension(R.styleable.SuperShapeView_super_dashGap, DEFAULT_DASHGAP));
        superConfig.setTopLeftRadius(typedArray.getDimension(R.styleable.SuperShapeView_super_topLeftRadius,
                DEFAULT_TOP_LEFT_RADIUS));
        superConfig.setTopRightRadius(typedArray.getDimension(R.styleable.SuperShapeView_super_topRightRadius,
                DEFAULT_TOP_RIGHT_RADIUS));
        superConfig.setBottomLeftRadius(typedArray.getDimension(R.styleable.SuperShapeView_super_bottomLeftRadius,
                DEFAULT_BOTTOM_LEFT_RADIUS));
        superConfig.setBottomRightRadius(typedArray.getDimension(R.styleable.SuperShapeView_super_bottomRightRadius,
                DEFAULT_BOTTOM_IGHT_RADIUS));
        typedArray.recycle();
    }

    private void setupGradientDrawable() {
        GradientDrawable mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(superConfig.getSolidColor());
        mGradientDrawable.setStroke(superConfig.getStrokeWidth(), superConfig.getStrokeColor(), superConfig
                .getDashWidth(), superConfig.getDashGap());
        float[] radius = {superConfig.getTopLeftRadius(), superConfig.getTopLeftRadius(), superConfig
                .getTopRightRadius(), superConfig.getTopRightRadius(), superConfig.getBottomRightRadius(),
                superConfig.getBottomRightRadius(), superConfig.getBottomLeftRadius(), superConfig
                .getBottomLeftRadius()};
        if (superConfig.getCornerRadius() == DEFAULT_CORNER_RADIUS) {
            mGradientDrawable.setCornerRadii(radius);
        } else {
            mGradientDrawable.setCornerRadius(superConfig.getCornerRadius());
        }
        view.setBackground(mGradientDrawable);
    }

    private int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, view.getContext().getResources()
                .getDisplayMetrics());
    }

    @Override
    public void setSolidColor(int solidColor) {
        superConfig.setSolidColor(solidColor);
        setupGradientDrawable();
    }

    @Override
    public void setStrokeColor(int strokeColor) {
        superConfig.setStrokeColor(strokeColor);
        setupGradientDrawable();
    }

    @Override
    public void setStrokeWidth(int strokeWidth) {
        superConfig.setStrokeWidth(dp2px(strokeWidth));
        setupGradientDrawable();
    }

    @Override
    public void setCorner(float corner) {
        superConfig.setCornerRadius(dp2px(corner));
        setupGradientDrawable();
    }

    @Override
    public void setCorner(int topLeftRadius, int topRightRadius, int bottomRightRadius, int bottomLeftRadius) {
        superConfig.setTopLeftRadius(topLeftRadius);
        superConfig.setTopRightRadius(topRightRadius);
        superConfig.setBottomLeftRadius(bottomLeftRadius);
        superConfig.setBottomRightRadius(bottomRightRadius);
        setupGradientDrawable();
    }

    private void restore(SuperConfig superConfig) {
        this.superConfig = superConfig;
        setupGradientDrawable();
    }

    public Parcelable onSaveInstanceState(Parcelable superState) {
        SavedState ss = new SavedState(superState);
        ss.superConfig = superConfig;
        return ss;
    }

    public Parcelable onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        restore(ss.superConfig);
        return ss.getSuperState();
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
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }
}
