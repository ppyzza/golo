package com.hackathon.golo.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hackathon.golo.R;
import com.hackathon.golo.model.Offers;
import com.hackathon.golo.model.PlanList;
import com.hackathon.golo.model.Togo;

import java.util.ArrayList;


public class ItemLocationAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    ArrayList<PlanList> planListArrayList;

    public ItemLocationAdaptor(Context context, ArrayList<PlanList> explorers) {
        mContext = context;
        planListArrayList = explorers;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location_list, null, false);
                return new ItemLocationAdaptor.ViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location_distance, null, false);
                return new ItemLocationAdaptor.ViewHolder2(view);
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location_distance_middle, null, false);
                return new ItemLocationAdaptor.ViewHolder3(view);
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location_distance_end, null, false);
                return new ItemLocationAdaptor.ViewHolder4(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolder) {
            initPlace((ViewHolder) holder, planListArrayList.get(position), position);
        } else if(holder instanceof ViewHolder2){
            //initDistance((ViewHolder2) holder, planListArrayList.get(position), position);

        } else if(holder instanceof ViewHolder3){
            initDistanceMiddle((ViewHolder3) holder, planListArrayList.get(position), position);

        } else if(holder instanceof ViewHolder4){
            //initDistance((ViewHolder4) holder, planListArrayList.get(position), position);

        }
    }

    private void initPlace(ViewHolder viewHolder, PlanList planList, int position) {
        viewHolder.tvTitle.setText(planListArrayList.get(position).getPlaceName());
        viewHolder.tvDesc.setText(""+planListArrayList.get(position).getDistance());
    }



    private void initDistanceMiddle(ViewHolder3 viewHolder2, PlanList planList, int position) {
        viewHolder2.tvTitle.setText(""+planListArrayList.get(position).getDistance());

    }




    @Override
    public int getItemCount() {
        if(planListArrayList!=null) {
            return planListArrayList.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getItemViewType(int position) {
        String viewType = planListArrayList.get(position).getViewType();
        switch (viewType) {
            case "start":
                return 1;
            case "middle":
                return 2;
            case "bottom":
                return 3;
            case "place":
                return 0;
        }
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    final class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDesc;

        ViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.location_name);
            tvDesc = view.findViewById(R.id.review_and_distant);

        }
    }

    final class ViewHolder2 extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDesc;

        ViewHolder2(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.location_name);
            tvDesc = view.findViewById(R.id.review_and_distant);

        }
    }

    final class ViewHolder3 extends RecyclerView.ViewHolder {


        TextView tvTitle;
        TextView tvDesc;

        ViewHolder3(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.location_name);
            tvDesc = view.findViewById(R.id.review_and_distant);

        }
    }

    final class ViewHolder4 extends RecyclerView.ViewHolder {


        ViewHolder4(View view) {
            super(view);

        }
    }


}
