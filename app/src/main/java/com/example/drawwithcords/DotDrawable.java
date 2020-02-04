package com.example.drawwithcords;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

public class DotDrawable extends Drawable {
    private final Paint paint;

    public DotDrawable() {
        // Set up color and text size
        paint = new Paint();
        paint.setARGB(255, 255, 0, 0);
    }

    @Override
    public void draw(Canvas canvas) {
        // Get the drawable's bounds
       /* int width = getBounds().width();
        int height = getBounds().height();
        float radius = Math.min(width, height) / 2; */

        // Draw a red circle in the center
        //canvas.drawCircle(width/2, height/2, radius, redPaint);
        for (int i = 100; i < 101; i++) {
            bigPoint(i,i, paint, canvas);
        }
    }

    @Override
    public void setAlpha(int alpha) {
        // This method is required
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        // This method is required
    }

    @Override
    public int getOpacity() {
        // Must be PixelFormat.UNKNOWN, TRANSLUCENT, TRANSPARENT, or OPAQUE
        return PixelFormat.OPAQUE;
    }

    private void bigPoint(int x, int y, Paint color, Canvas canvas) {
        int size = 3;
        for (int i = x - size; i < x + size; i++) {
            for (int j = y - size; j < y + size; j++) {
                canvas.drawPoint(i, j, color);
            }
        }
    }
}