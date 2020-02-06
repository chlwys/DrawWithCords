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

        DataM call = new DataM(mContext);
        long[][] values = call.splitByComma();
        for (int i = 0; i < values.length; i++) {
            int x, y, p;
            if (values[i][4] > 500) {
                x = (int) values[i][2] / 5 + 100;
                y = (int) values[i][3] / 20 + 10;
                paint.setARGB(255, (int) values[i][4] / 8 - 100, 0,0);
                bigPoint(x, y, paint, canvas);
            }
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