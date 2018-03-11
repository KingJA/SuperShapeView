package com.kingja.supershapeview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.kingja.supershapeview.core.SuperManager;

/**
 * Description:TODO
 * Create Time:2017/6/26 10:32
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class SuperShapeRelativeLayout extends RelativeLayout {

    public SuperShapeRelativeLayout(Context context) {
        super(context);
    }

    public SuperShapeRelativeLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initSuperShapeView(attrs);
    }

    public SuperShapeRelativeLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initSuperShapeView(attrs);
    }

    private void initSuperShapeView(AttributeSet attrs) {
        new SuperManager().beSuperView(attrs, this);
    }
}
