package com.hackathon.golo.account_follow.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hackathon.golo.R;
import com.hackathon.golo.account_follow.model.AccountPlanModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AccountFollowReviewerAdaptor extends RecyclerView.Adapter<AccountFollowReviewerAdaptor.ViewHolder> {
    Context mContext;
    public ArrayList<AccountPlanModel> planList = new ArrayList<>();

    public AccountFollowReviewerAdaptor(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public AccountFollowReviewerAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plan_reviewer, null, false);
        AccountFollowReviewerAdaptor.ViewHolder vh = new AccountFollowReviewerAdaptor.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AccountFollowReviewerAdaptor.ViewHolder holder, int position) {
        holder.tvImage.setText(planList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return planList.size();
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

        ViewHolder(View view) {
            super(view);
            tvImage = view.findViewById(R.id.tv_location_name);
        }
    }
}
