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
import com.hackathon.golo.model.Togo;

import java.util.ArrayList;


public class LocalAdaptor extends RecyclerView.Adapter<LocalAdaptor.ViewHolder> {

    Context mContext;
    ArrayList<Togo> offersArrayList;

    public LocalAdaptor(Context context, ArrayList<Togo> explorers) {
        mContext = context;
        offersArrayList = explorers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .item_local, null, false);
        LocalAdaptor.ViewHolder vh = new LocalAdaptor.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(offersArrayList.get(position).getTitle());
        holder.tvDesc.setText(offersArrayList.get(position).getPeriod());
        // Glide.with(mContext).load(offersArrayList.get(position)).into(holder.ivOffers);
        holder.ivOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, LocalGuideActivity.class);
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(offersArrayList!=null) {
            return offersArrayList.size();
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
        ImageView ivOffers;
        TextView tvPeriod;
        RelativeLayout rlLocal;

        ViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            tvDesc = view.findViewById(R.id.tv_desc);
            ivOffers = view.findViewById(R.id.iv_banner);
            tvPeriod = view.findViewById(R.id.tv_period);
            rlLocal = view.findViewById(R.id.rl_local);
        }
    }
}
