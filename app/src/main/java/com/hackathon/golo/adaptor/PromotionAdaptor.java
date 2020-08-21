package com.hackathon.golo.adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackathon.golo.PromotionActivity;
import com.hackathon.golo.PromotionDetailActivity;
import com.hackathon.golo.R;
import com.hackathon.golo.model.Promotion;
import com.hackathon.golo.model.SearchResult;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class PromotionAdaptor extends RecyclerView.Adapter<PromotionAdaptor.ViewHolder> {

    Context mContext;
    ArrayList<Promotion> promotionArrayList;

    public PromotionAdaptor(Context context, ArrayList<Promotion> promotion) {
        mContext = context;
        promotionArrayList = promotion;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .item_coupon, null, false);
        PromotionAdaptor.ViewHolder vh = new PromotionAdaptor.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(promotionArrayList.get(position).getName());
        holder.tvDesc.setText(promotionArrayList.get(position).getDescription());
        holder.tvType.setText(promotionArrayList.get(position).getTypeCampaign());
        holder.tvPoint.setText(promotionArrayList.get(position).getPoint());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, PromotionDetailActivity.class);
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(promotionArrayList!=null) {
            return promotionArrayList.size();
        }
        return 0;
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

        ImageView imageView;
        TextView tvName;
        TextView tvDesc;
        TextView tvType;
        TextView tvPoint;

        ViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name_coupon);
            tvDesc = view.findViewById(R.id.tv_description_coupon);
            tvType = view.findViewById(R.id.tv_type_coupon);
            tvPoint = view.findViewById(R.id.tv_point_coupon);
        }
    }
}
