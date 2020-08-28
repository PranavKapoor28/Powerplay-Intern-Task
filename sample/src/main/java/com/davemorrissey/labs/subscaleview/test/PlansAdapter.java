package com.davemorrissey.labs.subscaleview.test;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.davemorrissey.labs.subscaleview.test.FloorPlan.FloorPlan1Activity;
import com.davemorrissey.labs.subscaleview.test.FloorPlan.FloorPlan2Activity;

import java.util.List;


public class PlansAdapter extends RecyclerView.Adapter<PlansAdapter.PlanViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Plans> plansList;

    //getting the context and product list with constructor
    public PlansAdapter(Context mCtx, List<Plans> plansList) {
        this.mCtx = mCtx;
        this.plansList = plansList;
    }


    @Override
    public PlanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.floor_plan_button, null);
        return new PlanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlanViewHolder holder, int position) {
        //getting the product of the specified position
        Plans plans = plansList.get(position);

        //binding the data with the viewholder views
        holder.floorPlanText.setText(plans.getTitle());

        holder.floorplanImage.setImageDrawable(mCtx.getResources().getDrawable(plans.getImage()));

    }


    @Override
    public int getItemCount() {
        return plansList.size();
    }


    class PlanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView floorPlanText;
        ImageView floorplanImage;

        public PlanViewHolder(View itemView) {
            super(itemView);

            floorPlanText = itemView.findViewById(R.id.floorplan2List);
            floorplanImage = itemView.findViewById(R.id.floorplan2Image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i;
                    switch (getAdapterPosition()) {
                        case 0:
                            i = new Intent(view.getContext(), FloorPlan1Activity.class);
                            break;

                        case 1:
                            i = new Intent(view.getContext(), FloorPlan2Activity.class);
                            break;

                        default:
                            i = new Intent(view.getContext(), MainActivity.class);
                            break;
                    }
                    view.getContext().startActivity(i);
                }
            });

        }

        @Override
        public void onClick(View view) {

        }
    }
}