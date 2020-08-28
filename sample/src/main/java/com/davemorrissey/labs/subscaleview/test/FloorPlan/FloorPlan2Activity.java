package com.davemorrissey.labs.subscaleview.test.FloorPlan;

import android.util.Log;

import com.davemorrissey.labs.subscaleview.test.AbstractFragmentsActivity;
import com.davemorrissey.labs.subscaleview.test.Page;
import com.davemorrissey.labs.subscaleview.test.R.id;

import java.util.Arrays;
import java.util.List;

import static com.davemorrissey.labs.subscaleview.test.R.layout.fragments_activity;
import static com.davemorrissey.labs.subscaleview.test.R.string.extension_p1_subtitle;
import static com.davemorrissey.labs.subscaleview.test.R.string.extension_p1_text;
import static com.davemorrissey.labs.subscaleview.test.R.string.floorplan2_title;

public class FloorPlan2Activity extends AbstractFragmentsActivity {

    private static final List<Class<FloorPlan2PinFragment>> FRAGMENTS = Arrays.asList(
            FloorPlan2PinFragment.class

    );

    public FloorPlan2Activity() {
        super(floorplan2_title, fragments_activity, Arrays.asList(
                new Page(extension_p1_subtitle, extension_p1_text)
        ));
    }

    @Override
    protected void onPageChanged(int page) {
        try {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(id.frame, FRAGMENTS.get(page).newInstance())
                    .commit();
        } catch (Exception e) {
            Log.e(FloorPlan1PinFragment.class.getName(), "Failed to load fragment", e);
        }
    }

}
