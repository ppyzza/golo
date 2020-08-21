package com.hackathon.golo.adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.golo.LocalGuideActivity;
import com.hackathon.golo.R;
import com.hackathon.golo.model.Locals;


import java.util.ArrayList;


public class LocalListAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    ArrayList<Locals> locals;

    public LocalListAdaptor(Context context, ArrayList<Locals> explorers) {
        mContext = context;
        locals = explorers;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_local_detail, null, false);
                return new TopLocalHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_local_list, null, false);
                return new PlanHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        getItemViewType(position);
        final Locals local = locals.get(position);
        if(holder instanceof TopLocalHolder) {
            initTopLocalHolder((TopLocalHolder) holder, local);
        } else {
            initPlanHolder((PlanHolder) holder, local);

        }
    }

    private void initTopLocalHolder(TopLocalHolder topLocalHolder, Locals locals) {
        topLocalHolder.tvTitle.setText(locals.getLocalDetail().getName());
        topLocalHolder.tvDesc.setText("("+locals.getLocalDetail().getPlanReview()+" reviews) | "+locals.getLocalDetail().getDistance()+" km from here");
        topLocalHolder.tvPrice.setText(locals.getLocalDetail().getPrice()+" Bath / Person");
    }

    private void initPlanHolder(PlanHolder planHolder, Locals locals) {

    }

    class TopLocalHolder extends RecyclerView.ViewHolder {
        public ImageView ivBanner;
        public TextView tvTitle;
        public TextView tvDesc;
        public TextView tvPrice;

        TopLocalHolder(View v) {
            super(v);
            ivBanner = v.findViewById(R.id.iv_banner);
            tvTitle = v.findViewById(R.id.tv_title);
            tvDesc = v.findViewById(R.id.tv_desc);
            tvPrice = v.findViewById(R.id.tvPrice);

        }
    }

    class PlanHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvMore;

        PlanHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tv_title);
            tvMore = v.findViewById(R.id.tv_more);
        }
    }

    @Override
    public int getItemCount() {
        if(locals!=null) {
            return locals.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(locals.get(position).getViewType().equals("top")) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }


}
