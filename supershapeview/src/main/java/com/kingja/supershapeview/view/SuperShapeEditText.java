package com.kingja.supershapeview.view;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.kingja.supershapeview.core.SuperManager;

/**
 * Description:TODO
 * Create Time:2017/6/26 10:32
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class SuperShapeEditText extends AppCompatEditText {

    private SuperManager superManager;

    public SuperManager getSuperManager() {
        return superManager;
    }
    public SuperShapeEditText(Context context) {
        super(context);
    }

    public SuperShapeEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initSuperShapeView(attrs);
    }

    public SuperShapeEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initSuperShapeView(attrs);
    }

    private void initSuperShapeView(AttributeSet attrs) {
        superManager = new SuperManager(attrs, this);
        superManager.beSuperView();
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        superManager.buildShape(null);
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
