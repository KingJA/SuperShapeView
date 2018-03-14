package com.kingja.supershapeview.core;

import java.io.Serializable;

/**
 * Description:TODO
 * Create Time:2018/3/11 17:37
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class SuperConfig implements Serializable {
    public static final float DEFAULT_CORNER_RADIUS = 0f;
    public static final float DEFAULT_STROKE_WIDTH = 0f;
    public static final int DEFAULT_STROKE_COLOR = 0;
    public static final int DEFAULT_SOLID_COLOR = 0;
    public static final float DEFAULT_DASHWIDTH = 0f;
    public static final float DEFAULT_DASHGAP = 0f;
    public static final float DEFAULT_TOP_LEFT_RADIUS = 0f;
    public static final float DEFAULT_TOP_RIGHT_RADIUS = 0f;
    public static final float DEFAULT_BOTTOM_LEFT_RADIUS = 0f;
    public static final float DEFAULT_BOTTOM_IGHT_RADIUS = 0f;
    
    private float cornerRadius;
    private int strokeColor;
    private int solidColor;
    private int strokeWidth;
    private float dashWidth;
    private float dashGap;
    private float topLeftRadius;
    private float topRightRadius;
    private float bottomLeftRadius;
    private float bottomRightRadius;

    public float getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(float cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
    }

    public int getSolidColor() {
        return solidColor;
    }

    public void setSolidColor(int solidColor) {
        this.solidColor = solidColor;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public float getDashWidth() {
        return dashWidth;
    }

    public void setDashWidth(float dashWidth) {
        this.dashWidth = dashWidth;
    }

    public float getDashGap() {
        return dashGap;
    }

    public void setDashGap(float dashGap) {
        this.dashGap = dashGap;
    }

    public float getTopLeftRadius() {
        return topLeftRadius;
    }

    public void setTopLeftRadius(float topLeftRadius) {
        this.topLeftRadius = topLeftRadius;
    }

    public float getTopRightRadius() {
        return topRightRadius;
    }

    public void setTopRightRadius(float topRightRadius) {
        this.topRightRadius = topRightRadius;
    }

    public float getBottomLeftRadius() {
        return bottomLeftRadius;
    }

    public void setBottomLeftRadius(float bottomLeftRadius) {
        this.bottomLeftRadius = bottomLeftRadius;
    }

    public float getBottomRightRadius() {
        return bottomRightRadius;
    }

    public void setBottomRightRadius(float bottomRightRadius) {
        this.bottomRightRadius = bottomRightRadius;
    }
}
