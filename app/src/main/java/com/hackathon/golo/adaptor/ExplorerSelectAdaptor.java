package com.hackathon.golo.adaptor;

import android.content.Context;
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


public class ExplorerSelectAdaptor extends RecyclerView.Adapter<ExplorerSelectAdaptor.ViewHolder> {

    Context mContext;
    ArrayList<Explorer> explorerArrayList;

    public ExplorerSelectAdaptor(Context context, ArrayList<Explorer> explorers) {
        mContext = context;
        explorerArrayList = explorers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .item_explorer_round, null, false);
        ExplorerSelectAdaptor.ViewHolder vh = new ExplorerSelectAdaptor.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.tvImage.setText(explorerArrayList.get(position).getTitle());
        holder.image.setImageResource(explorerArrayList.get(position).getImage());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!explorerArrayList.get(position).isSelect()) {
                    Explorer explorer = explorerArrayList.get(position);
                    explorer.setSelect(true);
                    explorerArrayList.set(position, explorer);
                    holder.image.setImageResource(explorerArrayList.get(position).getImageSelected());
                } else {
                    Explorer explorer = explorerArrayList.get(position);
                    explorer.setSelect(false);
                    explorerArrayList.set(position, explorer);
                    holder.image.setImageResource(explorerArrayList.get(position).getImage());

                }
            }
        });
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
