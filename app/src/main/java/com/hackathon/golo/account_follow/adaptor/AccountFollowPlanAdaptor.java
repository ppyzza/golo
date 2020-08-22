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


public class AccountFollowPlanAdaptor extends RecyclerView.Adapter<AccountFollowPlanAdaptor.ViewHolder> {

    Context mContext;
    public ArrayList<AccountPlanModel> planList = new ArrayList<>();

    public AccountFollowPlanAdaptor(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plan, null, false);
        AccountFollowPlanAdaptor.ViewHolder vh = new AccountFollowPlanAdaptor.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(planList.get(position).getName());
        holder.tvDescription.setText(planList.get(position).getDetail());
        holder.tvInfo.setText(planList.get(position).getInfo());
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

        TextView tvName;
        TextView tvDescription;
        TextView tvInfo;

        ViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_plan_name);
            tvDescription = view.findViewById(R.id.tv_plan_description);
            tvInfo = view.findViewById(R.id.tv_plan_info);
        }
    }
}
