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

import com.bumptech.glide.Glide;
import com.hackathon.golo.PromotionDetailActivity;
import com.hackathon.golo.R;
import com.hackathon.golo.model.Explorer;
import com.hackathon.golo.model.Offers;

import java.util.ArrayList;


public class OffersAdaptor extends RecyclerView.Adapter<OffersAdaptor.ViewHolder> {

    Context mContext;
    ArrayList<Offers> offersArrayList;

    public OffersAdaptor(Context context, ArrayList<Offers> explorers) {
        mContext = context;
        offersArrayList = explorers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .item_offers, null, false);
        OffersAdaptor.ViewHolder vh = new OffersAdaptor.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        holder.tvTitle.setText(offersArrayList.get(position).getTitle());
        holder.tvDesc.setText(offersArrayList.get(position).getTitle());


        Glide.with(mContext).load(offersArrayList.get(position).getImage()).into(holder.ivOffers);

        holder.ivOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, PromotionDetailActivity.class);
                i.putExtra("position", position);
                i.putExtra("image", offersArrayList.get(position).getImage());
                i.putExtra("point", offersArrayList.get(position).getPoint());
                i.putExtra("pointDiscount", offersArrayList.get(position).getPointDiscount());
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

        ViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            tvDesc = view.findViewById(R.id.tv_desc);
            ivOffers = view.findViewById(R.id.iv_offers);
        }
    }
}
