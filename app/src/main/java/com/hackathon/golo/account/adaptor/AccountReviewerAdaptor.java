package com.hackathon.golo.account.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hackathon.golo.R;
import com.hackathon.golo.account.model.AccountPlanModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AccountReviewerAdaptor extends RecyclerView.Adapter<AccountReviewerAdaptor.ViewHolder> {
    Context mContext;
    public ArrayList<AccountPlanModel> planList = new ArrayList<>();

    public AccountReviewerAdaptor(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public AccountReviewerAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plan_reviewer, null, false);
        AccountReviewerAdaptor.ViewHolder vh = new AccountReviewerAdaptor.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AccountReviewerAdaptor.ViewHolder holder, int position) {
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
