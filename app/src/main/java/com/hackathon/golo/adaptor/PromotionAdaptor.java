package com.hackathon.golo.adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hackathon.golo.PromotionActivity;
import com.hackathon.golo.PromotionDetailActivity;
import com.hackathon.golo.R;
import com.hackathon.golo.model.Attribute;
import com.hackathon.golo.model.Promotion;
import com.hackathon.golo.model.SearchResult;
import com.hackathon.golo.presenters.PromotionPresenter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class PromotionAdaptor extends RecyclerView.Adapter<PromotionAdaptor.ViewHolder> {

    Context mContext;
    ArrayList<Promotion> promotionArrayList;
    private AdapterCallback adapterCallback;

    public PromotionAdaptor(Context context, ArrayList<Promotion> promotion) {
        mContext = context;
        promotionArrayList = promotion;
        adapterCallback = ((AdapterCallback) context);
    }

    public static interface AdapterCallback {
        void onMethodCallback(Integer position);
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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvName.setText(promotionArrayList.get(position).getName());
        holder.tvDesc.setText(promotionArrayList.get(position).getDescription());
        holder.tvPoint2.setText("From "+promotionArrayList.get(position).getPoint() + " points");
        holder.tvPoint.setText(promotionArrayList.get(position).getPointDiscount() + " point");
        if(promotionArrayList.get(position).getImage() != null){
            Glide.with(mContext).load(promotionArrayList.get(position).getImage()).into(holder.imageView);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, PromotionDetailActivity.class);
                i.putExtra("position", position);
                i.putExtra("image", promotionArrayList.get(position).getImage());
                i.putExtra("point", promotionArrayList.get(position).getPoint().toString());
                i.putExtra("pointDiscount", promotionArrayList.get(position).getPointDiscount().toString());
                mContext.startActivity(i);
            }
        });

        holder.btRedeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    adapterCallback.onMethodCallback(position);
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
        TextView tvPoint;
        TextView tvPoint2;
        Button btRedeem;

        ViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name_coupon);
            tvDesc = view.findViewById(R.id.tv_description_coupon);
            tvPoint = view.findViewById(R.id.tv_point_coupon);
            tvPoint2 = view.findViewById(R.id.tv_point);
            btRedeem = view.findViewById(R.id.button_redeem);
            imageView = view.findViewById(R.id.image_coupon);
        }
    }
}
