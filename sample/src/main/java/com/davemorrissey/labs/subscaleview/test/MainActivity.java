package com.davemorrissey.labs.subscaleview.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davemorrissey.labs.subscaleview.test.R.id;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
    RecyclerView plansList;
    List<Plans> PlansArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        plansList = findViewById(id.plansList);
        plansList.setLayoutManager(new LinearLayoutManager(this));
        PlansArray = new ArrayList<>();

        PlansArray.add(
                new Plans(
                        1,
                        "Plan 1", R.drawable.planicon));
        PlansArray.add(
                new Plans(
                        2,
                        "Plan 2", R.drawable.plan2));



    PlansAdapter adapter = new PlansAdapter(this, PlansArray);
      plansList.setAdapter(adapter);

//
//        ActionBar actionBar = getActionBar();
//        if (actionBar != null) {
//            actionBar.setTitle(R.string.main_title);
//        }
//        generatePlans();
//    }
//    private void generatePlans() {
//        AssetManager manager = getAssets();
//        String path = "floorPlans/";
//        planButton=findViewById(id.floorPlanButton);
//        try {
//            String list[] = manager.list(path);
//            for(String plan: list) {
//                Log.d("ASSETS", path+plan);
//                Log.d("ASSETS", ""+ plan.charAt(0));
//
//            }
//        } catch (IOException e) {
//            Log.d("FloorPlanManager", "Unable to parse asset files");
//        }
//
//    }
//
//
//
//    private void startActivity(Class<? extends Activity> activity) {
//        Intent intent = new Intent(this, activity);
//        startActivity(intent);
//    }
//
//    @Override
//    public void onBackPressed() {
//        moveTaskToBack(true);
   }

    @Override
    public void onClick(View view) {

    }
}
