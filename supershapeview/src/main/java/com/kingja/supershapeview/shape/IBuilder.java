package com.kingja.supershapeview.shape;

import android.graphics.Canvas;

import com.kingja.supershapeview.core.SuperConfig;

/**
 * Description:TODO
 * Create Time:2018/3/12 15:50
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface IBuilder {
    public void buildShape( Canvas canvas);

    public void setSuperConfig(SuperConfig superConfig);

    public void modifyAttr();
}
