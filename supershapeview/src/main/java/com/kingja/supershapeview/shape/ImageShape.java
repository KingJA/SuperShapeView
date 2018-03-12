package com.kingja.supershapeview.shape;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.kingja.supershapeview.core.SuperConfig;

/**
 * Description:TODO
 * Create Time:2018/3/12 15:49
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ImageShape implements IBuilder {
    private final ImageView imageView;
    private SuperConfig superConfig;

    @Override
    public void setSuperConfig(SuperConfig superConfig) {
        this.superConfig = superConfig;
    }

    @Override
    public void modifyAttr() {
        imageView.invalidate();
    }

    public ImageShape(View view) {
        this.imageView = (ImageView) view;
    }

    private Paint getStrokePaint() {
        Paint strokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setColor(superConfig.getStrokeColor());
        strokePaint.setStrokeWidth(superConfig.getStrokeWidth());
        return strokePaint;
    }

    private RectF getRectF() {
        int borderOffset = (int) (superConfig.getStrokeWidth() * 0.5f);
        RectF rectF = new RectF();
        rectF.set(borderOffset, borderOffset, imageView.getMeasuredWidth() - borderOffset, imageView
                .getMeasuredHeight() - borderOffset);
        return rectF;
    }

    private Paint getShaderPaint() {
        Bitmap mBitmap = drawableToBitmap(imageView.getDrawable());
        BitmapShader mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint mBitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitmapShader.setLocalMatrix(imageView.getImageMatrix());
        mBitmapPaint.setShader(mBitmapShader);
        return mBitmapPaint;
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmap;
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(2, 2, Bitmap.Config.ARGB_8888);
            } else {
                int width = drawable.getIntrinsicWidth();
                int height = drawable.getIntrinsicHeight();
                bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
            bitmap = null;
        }
        return bitmap;
    }


    private Path getPath() {
        Path path = new Path();
        path.addRoundRect(getRectF(), superConfig.getCornerRadius(), superConfig.getCornerRadius(), Path.Direction.CW);
        return path;
    }

    @Override
    public void buildShape(Canvas canvas) {
        canvas.drawPath(getPath(), getShaderPaint());
        if (superConfig.getStrokeWidth() > 0) {
            canvas.drawPath(getPath(), getStrokePaint());
        }
    }
}
