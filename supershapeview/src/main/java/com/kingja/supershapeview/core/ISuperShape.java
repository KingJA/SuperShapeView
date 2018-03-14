package com.kingja.supershapeview.core;

/**
 * Description:TODO
 * Create Time:2018/3/11 11:54
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface ISuperShape {

    public void setSolidColor(int solidColor);

    public void setStrokeColor(int strokeColor);

    public void setStrokeWidth(int strokeWidth);

    public void setCorner(float corner);

    public void setDashWidth(float dashWidth);

    public void setDashGap(float dashGap);

    public void setCorner(int leftTopCorner, int rightTopCorner, int rightBottomCorner, int leftBottomCorner);
}
