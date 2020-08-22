package com.hackathon.golo.adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.golo.ItinerariesActivity;
import com.hackathon.golo.R;
import com.hackathon.golo.model.Togo;

import java.util.ArrayList;


public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {

    Context mContext;
    ArrayList<Togo> offersArrayList;

    public CategoryAdaptor(Context context, ArrayList<Togo> explorers) {
        mContext = context;
        offersArrayList = explorers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .item_todo, null, false);
        CategoryAdaptor.ViewHolder vh = new CategoryAdaptor.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(offersArrayList.get(position).getTitle());
        holder.tvDesc.setText(offersArrayList.get(position).getDescription());
        holder.tvPeriod.setText(offersArrayList.get(position).getPeriod());
        holder.tvBy.setText((offersArrayList.get(position).getBy()));
        // Glide.with(mContext).load(offersArrayList.get(position)).into(holder.ivOffers);

        holder.ivBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, ItinerariesActivity.class);
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
        TextView tvBy;
        ImageView ivBanner;
        ViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            tvDesc = view.findViewById(R.id.tv_desc);
            ivOffers = view.findViewById(R.id.iv_banner);
            tvPeriod = view.findViewById(R.id.tv_period);
            tvBy = view.findViewById(R.id.tv_by);
            ivBanner = view.findViewById(R.id.iv_banner);
        }
    }
}
