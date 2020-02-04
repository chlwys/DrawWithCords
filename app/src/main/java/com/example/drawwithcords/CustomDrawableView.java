package com.example.drawwithcords;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class CustomDrawableView extends View {
    private DotDrawable drawable;

    public CustomDrawableView(Context context) {
        super(context);
        int x = 10;
        int y = 10;
        int width = this.getWidth();
        int height = this.getHeight();

        drawable = new DotDrawable();
        drawable.setBounds(x, y, x + width, y + height);
    }

    protected void onDraw(Canvas canvas) {
        drawable.draw(canvas);
    }
}