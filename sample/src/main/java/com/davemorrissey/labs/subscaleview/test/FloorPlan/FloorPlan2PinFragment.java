package com.davemorrissey.labs.subscaleview.test.FloorPlan;

import android.graphics.PointF;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.test.R.id;
import com.davemorrissey.labs.subscaleview.test.R.layout;
import com.davemorrissey.labs.subscaleview.test.FloorPlan.views.PinView;

public class FloorPlan2PinFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(layout.floor_pin_fragment, container, false);
        final FloorPlan2Activity activity = (FloorPlan2Activity)getActivity();
        final PinView imageView = rootView.findViewById(id.imageView);
        imageView.setImage(ImageSource.asset("floorPlans/1.jpg"));

        if (activity != null) {
            Log.d("PRANAV","Touch registered");


            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        imageView.setPin(new PointF(event.getX(), event.getY()));
                    }
                    else{
                        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                    }
                    return true;
                }

            });

        }

        return rootView;
    }


}
