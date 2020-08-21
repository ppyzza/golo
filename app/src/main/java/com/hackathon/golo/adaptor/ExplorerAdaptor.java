package com.hackathon.golo.adaptor;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.golo.R;
import com.hackathon.golo.model.Explorer;

import java.util.ArrayList;


public class ExplorerAdaptor extends RecyclerView.Adapter<ExplorerAdaptor.ViewHolder> {

    Context mContext;
    ArrayList<Explorer> explorerArrayList;

    public ExplorerAdaptor(Context context, ArrayList<Explorer> explorers) {
        mContext = context;
        explorerArrayList = explorers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .item_explorer_round, null, false);
        ExplorerAdaptor.ViewHolder vh = new ExplorerAdaptor.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvImage.setText(explorerArrayList.get(position).getTitle());
        holder.image.setImageResource(explorerArrayList.get(position).getImage());
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

        TextView tvImage;
        ImageView image;

        ViewHolder(View view) {
            super(view);
            tvImage = view.findViewById(R.id.tv_image);
            image = view.findViewById(R.id.image);
        }
    }
}
