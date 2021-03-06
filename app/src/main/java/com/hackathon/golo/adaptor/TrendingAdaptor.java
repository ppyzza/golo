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
import com.hackathon.golo.model.SearchResult;

import java.util.ArrayList;


public class TrendingAdaptor extends RecyclerView.Adapter<TrendingAdaptor.ViewHolder> {

    Context mContext;
    ArrayList<SearchResult> explorerArrayList;

    public TrendingAdaptor(Context context, ArrayList<SearchResult> explorers) {
        mContext = context;
        explorerArrayList = explorers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .item_trending, null, false);
        TrendingAdaptor.ViewHolder vh = new TrendingAdaptor.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(explorerArrayList.get(position).getPlaceName());
        holder.tvDesc.setText(""+explorerArrayList.get(position).getPlaceId());

        Glide.with(mContext).load(explorerArrayList.get(position).getPlaceThumbnail()).into(holder.ivThumb);

    }

    @Override
    public int getItemCount() {
        return explorerArrayList.size();
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
        ImageView ivThumb;

        ViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            tvDesc = view.findViewById(R.id.tv_desc);
            ivThumb = view.findViewById(R.id.iv_trending_thumb);
        }
    }
}
