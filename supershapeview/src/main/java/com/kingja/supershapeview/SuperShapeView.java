package com.kingja.supershapeview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Description:TODO
 * Create Time:2017/6/26 10:32
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class SuperShapeView extends AppCompatTextView {
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
    private static final String TAG = "SuperShapeView";
    private GradientDrawable mGradientDrawable;
    private Drawable mTextDrawable;
    private int mDrawableWidth;
    private int mDrawableHeight;
    private int mDrawableGravity;
    private int mHeight;
    private int mDrawablePadding;

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
        float mCornerRadius = typedArray.getDimension(R.styleable.SuperShapeView_super_cornerRadius,
                DEFAULT_CORNER_RADIUS);
        int mStrokeColor = typedArray.getColor(R.styleable.SuperShapeView_super_strokeColor, DEFAULT_STROKE_COLOR);
        int mSolidColor = typedArray.getColor(R.styleable.SuperShapeView_super_solidColor, DEFAULT_SOLID_COLOR);
        int mStrokeWidth = (int) typedArray.getDimension(R.styleable.SuperShapeView_super_strokeWidth,
                DEFAULT_STROKE_WIDTH);

        float mDashWidth =typedArray.getDimension(R.styleable.SuperShapeView_super_dashWidth, DEFAULT_DASHWIDTH);
        float mDashGap = typedArray.getDimension(R.styleable.SuperShapeView_super_dashGap, DEFAULT_DASHGAP);

        float mTopLeftRadius =typedArray.getDimension(R.styleable.SuperShapeView_super_topLeftRadius,
                DEFAULT_TOP_LEFT_RADIUS);
        float mTopRightRadius = typedArray.getDimension(R.styleable.SuperShapeView_super_topRightRadius,
                DEFAULT_TOP_RIGHT_RADIUS);
        float mBottomLeftRadius = typedArray.getDimension(R.styleable.SuperShapeView_super_bottomLeftRadius,
                DEFAULT_BOTTOM_LEFT_RADIUS);
        float mBottomRightRadius =typedArray.getDimension(R.styleable.SuperShapeView_super_bottomRightRadius,
                DEFAULT_BOTTOM_IGHT_RADIUS);


        mTextDrawable = typedArray.getDrawable(R.styleable.SuperShapeView_super_drawable);
        mDrawableGravity = typedArray.getInt(R.styleable.SuperShapeView_super_drawableGravity, 1);
        mDrawablePadding = typedArray.getDimensionPixelOffset(R.styleable.SuperShapeView_super_drawablePadding,
                0);
        mDrawableWidth = typedArray.getDimensionPixelOffset(R.styleable.SuperShapeView_super_drawableWidth, 0);
        mDrawableHeight =  typedArray.getDimensionPixelOffset(R.styleable.SuperShapeView_super_drawableHeight, 0);
        Log.e(TAG, " mDrawableWidth: " + mDrawableWidth);
        Log.e(TAG, " mDrawableHeight: " + mDrawableHeight);
        Log.e(TAG, " mDrawableWidth: " + mDrawableWidth);
        Log.e(TAG, " mDrawableHeight: " + mDrawableHeight);

        typedArray.recycle();

        setupGradientDrawable(mCornerRadius, mStrokeColor, mSolidColor, mStrokeWidth, mDashWidth, mDashGap,
                mTopLeftRadius, mTopRightRadius, mBottomLeftRadius, mBottomRightRadius);

    }

    private void setupGradientDrawable(float mCornerRadius, int mStrokeColor, int mSolidColor, int mStrokeWidth, float
            mDashWidth, float mDashGap, float mTopLeftRadius, float mTopRightRadius, float mBottomLeftRadius, float
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

    /*  private int dp2px(float dp) {
          return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
      }*/
    private int dp2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawStateDrawable(canvas);
        canvas.save();
        Log.e(TAG, "getPaddingLeft(): "+getPaddingLeft() );
        canvas.translate(mDrawableWidth+mDrawablePadding, 0);
        super.onDraw(canvas);
        canvas.restore();

    }

    private int[] mDrawableBounds = new int[4];

    private void drawStateDrawable(Canvas canvas) {
        if (mTextDrawable != null) {
            getDrawableBounds();
            mTextDrawable.setBounds(mDrawableBounds[0], mDrawableBounds[1], mDrawableBounds[2], mDrawableBounds[3]);
            mTextDrawable.draw(canvas);
        }
    }

    private void getDrawableBounds() {
        switch (mDrawableGravity) {
            case 1://left
                mDrawableBounds[0] = getPaddingLeft();
                mDrawableBounds[1] = (int) (mHeight / 2f - mDrawableHeight / 2f);
                Log.e(TAG, "mDrawableBounds[1]: "+mDrawableBounds[1] );
                mDrawableBounds[2] = mDrawableBounds[0] + mDrawableWidth;
                mDrawableBounds[3] = mDrawableBounds[1] + mDrawableHeight;
                break;
            case 2://right
                break;

        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int newWidth = getMeasuredWidth() + mDrawableWidth + mDrawablePadding ;
        int newHeight = Math.max(getMeasuredHeight(), mDrawableHeight+getPaddingTop()+getPaddingBottom()) ;
        setMeasuredDimension(newWidth, newHeight);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = getMeasuredHeight();
        Log.e(TAG, "mHeight: "+mHeight );
    }
}
