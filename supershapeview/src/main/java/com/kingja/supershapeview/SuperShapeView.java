package com.kingja.supershapeview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;

/**
 * Description:TODO
 * Create Time:2017/6/26 10:32
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class SuperShapeView extends AppCompatTextView {
    private static final float DEFAULT_CORNER_RADIUS = 0f;
    private static final int DEFAULT_STROKE_COLOR = 0;
    private static final int DEFAULT_SOLID_COLOR = 0;
    private static final float DEFAULT_STROKE_WIDTH = 0f;

    private static final float DEFAULT_DASHWIDTH = 0f;
    private static final float DEFAULT_DASHGAP = 0f;

    private static final float DEFAULT_TOP_LEFT_RADIUS = 0f;
    private static final float DEFAULT_TOP_RIGHT_RADIUS = 0f;
    private static final float DEFAULT_BOTTOM_LEFT_RADIUS = 0f;
    private static final float DEFAULT_BOTTOM_IGHT_RADIUS = 0f;
    private GradientDrawable mGradientDrawable;

    public SuperShapeView(Context context) {
        super(context);
    }

    public SuperShapeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initSuperShapeView(attrs);
    }


    public SuperShapeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initSuperShapeView(attrs);
    }


    private void initSuperShapeView(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.SuperShapeView);
        int mCornerRadius = dp2px(typedArray.getDimension(R.styleable.SuperShapeView_super_cornerRadius,
                DEFAULT_CORNER_RADIUS));
        int mStrokeColor = typedArray.getColor(R.styleable.SuperShapeView_super_strokeColor, DEFAULT_STROKE_COLOR);
        int mSolidColor = typedArray.getColor(R.styleable.SuperShapeView_super_solidColor, DEFAULT_SOLID_COLOR);
        int mStrokeWidth = dp2px(typedArray.getDimension(R.styleable.SuperShapeView_super_strokeWidth,
                DEFAULT_STROKE_WIDTH));

        int mDashWidth = dp2px(typedArray.getDimension(R.styleable.SuperShapeView_super_dashWidth, DEFAULT_DASHWIDTH));
        int mDashGap = dp2px(typedArray.getDimension(R.styleable.SuperShapeView_super_dashGap, DEFAULT_DASHGAP));

        int mTopLeftRadius = dp2px(typedArray.getDimension(R.styleable.SuperShapeView_super_topLeftRadius,
                DEFAULT_TOP_LEFT_RADIUS));
        int mTopRightRadius = dp2px(typedArray.getDimension(R.styleable.SuperShapeView_super_topRightRadius,
                DEFAULT_TOP_RIGHT_RADIUS));
        int mBottomLeftRadius = dp2px(typedArray.getDimension(R.styleable.SuperShapeView_super_bottomLeftRadius,
                DEFAULT_BOTTOM_LEFT_RADIUS));
        int mBottomRightRadius = dp2px(typedArray.getDimension(R.styleable.SuperShapeView_super_bottomRightRadius,
                DEFAULT_BOTTOM_IGHT_RADIUS));
        typedArray.recycle();

        setupGradientDrawable(mCornerRadius, mStrokeColor, mSolidColor, mStrokeWidth, mDashWidth, mDashGap,
                mTopLeftRadius, mTopRightRadius, mBottomLeftRadius, mBottomRightRadius);

    }

    private void setupGradientDrawable(int mCornerRadius, int mStrokeColor, int mSolidColor, int mStrokeWidth, int
            mDashWidth, int mDashGap, int mTopLeftRadius, int mTopRightRadius, int mBottomLeftRadius, int
            mBottomRightRadius) {
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(mSolidColor);
        mGradientDrawable.setStroke(mStrokeWidth, mStrokeColor, mDashWidth, mDashGap);
        float[] radius = {mTopLeftRadius, mTopLeftRadius, mTopRightRadius, mTopRightRadius, mBottomRightRadius,
                mBottomRightRadius, mBottomLeftRadius, mBottomLeftRadius};

        if (mCornerRadius == DEFAULT_CORNER_RADIUS) {
            mGradientDrawable.setCornerRadii(radius);
        } else {
            mGradientDrawable.setCornerRadius(mCornerRadius);
        }
        setBackgroundDrawable(mGradientDrawable);
    }

    protected int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }
}
