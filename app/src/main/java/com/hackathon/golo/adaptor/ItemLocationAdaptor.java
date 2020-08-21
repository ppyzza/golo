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


public class ItemLocationAdaptor extends RecyclerView.Adapter<ItemLocationAdaptor.ViewHolder> {

    Context mContext;
    ArrayList<PlanList> planListArrayList;

    public ItemLocationAdaptor(Context context, ArrayList<PlanList> explorers) {
        mContext = context;
        planListArrayList = explorers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .item_location_list, null, false);
        ItemLocationAdaptor.ViewHolder vh = new ItemLocationAdaptor.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(planListArrayList.get(position).getPlaceName());
        holder.tvDesc.setText(""+planListArrayList.get(position).getDistance());

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
        return super.getItemViewType(position);
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
}
