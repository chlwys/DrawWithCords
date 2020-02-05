package com.example.drawwithcords;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

public class DotDrawable extends Drawable {

    private final Paint paint;
    private Context mContext;

    public DotDrawable(Context context) {
        // Set up color and text size
        mContext = context;
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
        DataM call = new DataM(mContext);
        long[][] values = call.splitByComma();
        for (int i = 0; i < values.length; i++) {
            int x, y, p;
            if (values[i][4] > 500) {
                x = (int) values[i][2] / 40 + 100;
                y = (int) values[i][3] / 20;
                bigPoint(x, y, paint, canvas);
            }
            //for (int j = 0; j <= 4; j++)
        }
        //bigPoint(100,100, paint, canvas);
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