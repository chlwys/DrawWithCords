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
        drawable = new DotDrawable();

    }

    protected void onDraw(Canvas canvas) {
        drawable.draw(canvas);
    }
}