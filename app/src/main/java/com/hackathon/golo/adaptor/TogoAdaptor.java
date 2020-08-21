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
import com.hackathon.golo.model.Togo;

import java.util.ArrayList;


public class TogoAdaptor extends RecyclerView.Adapter<TogoAdaptor.ViewHolder> {

    Context mContext;
    ArrayList<Togo> offersArrayList;

    public TogoAdaptor(Context context, ArrayList<Togo> explorers) {
        mContext = context;
        offersArrayList = explorers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .item_todo, null, false);
        TogoAdaptor.ViewHolder vh = new TogoAdaptor.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(offersArrayList.get(position).getTitle());
        holder.tvDesc.setText(offersArrayList.get(position).getDescription());
        // Glide.with(mContext).load(offersArrayList.get(position)).into(holder.ivOffers);

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

        ViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            tvDesc = view.findViewById(R.id.tv_desc);
            ivOffers = view.findViewById(R.id.iv_banner);
            tvPeriod = view.findViewById(R.id.tv_period);
        }
    }
}
