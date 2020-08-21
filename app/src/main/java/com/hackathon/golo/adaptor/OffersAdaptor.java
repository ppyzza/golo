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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(offersArrayList.get(position).getTitle());
        holder.tvDesc.setText(offersArrayList.get(position).getTitle());

        switch (position) {
            default:
                Glide.with(mContext).load("https://picsum.photos/128/61").into(holder.ivOffers);
                break;
            case 6:
                Glide.with(mContext).load("https://picsum.photos/127/61").into(holder.ivOffers);
                break;
            case 7:
                Glide.with(mContext).load("https://picsum.photos/129/61").into(holder.ivOffers);
                break;
            case 8:
                Glide.with(mContext).load("https://picsum.photos/120/61").into(holder.ivOffers);
                break;
            case 9:
                Glide.with(mContext).load("https://picsum.photos/119/61").into(holder.ivOffers);
                break;
        }


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
