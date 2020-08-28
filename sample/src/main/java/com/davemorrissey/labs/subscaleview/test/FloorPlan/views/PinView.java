package com.davemorrissey.labs.subscaleview.test.FloorPlan.views;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.davemorrissey.labs.subscaleview.test.R.drawable;
import java.util.ArrayList;

public class PinView extends SubsamplingScaleImageView  implements View.OnTouchListener{

    private final Paint paint = new Paint();
    private final PointF vPin = new PointF();
    private Bitmap pin;

    private ArrayList<PointF> pointList = new ArrayList<>();

    public PinView(Context context) {
        this(context, null);
    }

    public PinView(Context context, AttributeSet attr) {
        super(context, attr);
        initialise();
    }

    public void setPin(PointF point) {
        pointList.add(point);
        initialise();
        invalidate();
    }

    private void initialise() {
        float density = getResources().getDisplayMetrics().densityDpi;
        pin = BitmapFactory.decodeResource(this.getResources(), drawable.pushpin_blue);
        float w = (density/420f) * pin.getWidth();
        float h = (density/420f) * pin.getHeight();
        pin = Bitmap.createScaledBitmap(pin,    (int)w, (int)h, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isReady()) {
            return;
        }

        paint.setAntiAlias(true);
        int count=0;
        for(int i=0;i<pointList.size();i++) {
            count++;
        }

        if (pin!=null) {
            for(PointF point: pointList) {
                sourceToViewCoord(point, vPin);
                float vX = vPin.x - (pin.getWidth())/5;
                float vY = vPin.y - pin.getHeight()*5;
                canvas.drawBitmap(pin, vX, vY, paint);
                paint.setTextSize(70);
                paint.setColor(Color.RED);

                    canvas.drawText("Pin"+count, vX, vY, paint);

            }
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
