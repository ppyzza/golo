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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.golo.LocalGuideActivity;
import com.hackathon.golo.R;
import com.hackathon.golo.model.Locals;
import com.hackathon.golo.tools.ItemDecorator;


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
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plan_list, null, false);
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
        topLocalHolder.tvPrice.setText(locals.getLocalDetail().getPrice()+"");
    }

    private void initPlanHolder(PlanHolder planHolder, Locals locals) {
        RecyclerView.LayoutManager layoutManager = null;
        layoutManager = new GridLayoutManager(mContext, 1, GridLayoutManager
                .VERTICAL, false);

        RecyclerView.Adapter adapter = new ItemLocationAdaptor(mContext, locals.getLocalDetail().getPlanListArrayList());
        planHolder.mRecyclerView.setLayoutManager(layoutManager);
        planHolder.mRecyclerView.addItemDecoration(new ItemDecorator(mContext));

        planHolder.mRecyclerView.setAdapter(adapter);
        planHolder.tvDetail.setText(locals.getLocalDetail().getDetail());

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
        public TextView tvDetail;
        public RecyclerView mRecyclerView;

        PlanHolder(View v) {
            super(v);
            tvDetail = v.findViewById(R.id.tv_detail);
            mRecyclerView = v.findViewById(R.id.content_second_recyclerview);
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
