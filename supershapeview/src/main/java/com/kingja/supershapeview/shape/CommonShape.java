package com.kingja.supershapeview.shape;

import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.View;

import com.kingja.supershapeview.core.SuperConfig;

/**
 * Description:TODO
 * Create Time:2018/3/12 16:08
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class CommonShape implements IBuilder {
    private static final String TAG = "CommonShape";
    private final View view;
    private SuperConfig superConfig;

    public CommonShape(View view) {
        this.view = view;
    }

    @Override
    public void buildShape(Canvas canvas) {
        GradientDrawable mGradientDrawable = new GradientDrawable();
        Log.e(TAG, "buildShape: " + superConfig.getCornerRadius());
        mGradientDrawable.setColor(superConfig.getSolidColor());
        mGradientDrawable.setStroke(superConfig.getStrokeWidth(), superConfig.getStrokeColor(), superConfig
                .getDashWidth(), superConfig.getDashGap());
        float[] radius = {superConfig.getTopLeftRadius(), superConfig.getTopLeftRadius(), superConfig
                .getTopRightRadius(), superConfig.getTopRightRadius(), superConfig.getBottomRightRadius(),
                superConfig.getBottomRightRadius(), superConfig.getBottomLeftRadius(), superConfig
                .getBottomLeftRadius()};
        if (superConfig.getCornerRadius() == SuperConfig.DEFAULT_CORNER_RADIUS) {
            mGradientDrawable.setCornerRadii(radius);
        } else {
            mGradientDrawable.setCornerRadius(superConfig.getCornerRadius());
        }
        view.setBackground(mGradientDrawable);
    }

    @Override
    public void setSuperConfig(SuperConfig superConfig) {
        this.superConfig = superConfig;
    }

    @Override
    public void modifyAttr() {
        Log.e(TAG, "modifyAttr: ");
        buildShape(null);
    }

}
