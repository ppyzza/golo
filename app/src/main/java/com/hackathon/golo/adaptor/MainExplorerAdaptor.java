package com.hackathon.golo.adaptor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.golo.MainActivity;
import com.hackathon.golo.MainTabActivity;
import com.hackathon.golo.MultipleActivity;
import com.hackathon.golo.PromotionActivity;
import com.hackathon.golo.PromotionDetailActivity;
import com.hackathon.golo.R;
import com.hackathon.golo.constans.GoloConstants;
import com.hackathon.golo.model.MainExplorerModel;
import com.hackathon.golo.tools.ItemDecorator;

import java.util.ArrayList;

public class MainExplorerAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private Activity mActivity;
    private ArrayList<MainExplorerModel> mDatas;

    public MainExplorerAdaptor(Activity activity, Context context, ArrayList<MainExplorerModel> datas) {
        mActivity = activity;
        mContext = context;
        mDatas = datas;
    }

    @Override
    public int getItemViewType(int position) {
        if(mDatas!=null) {
            return mDatas.get(position).getViewType();
        } else {
            return 0;
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        getItemViewType(position);
        final MainExplorerModel mainExplorerModel = mDatas.get(position);
        if(holder instanceof ExploreHolder) {
            initExplorerHolder((ExploreHolder) holder, mainExplorerModel);
        } else if(holder instanceof PromotionHolder) {
            initPromotionExplorer((PromotionHolder) holder, mainExplorerModel);
        } else if(holder instanceof SuggestHolder) {
            initSuggestExplorer((SuggestHolder) holder, mainExplorerModel);
        } else if(holder instanceof TrendingHolder) {
            initTrendingExplorer((TrendingHolder) holder, mainExplorerModel);
        }
    }

    private void initExplorerHolder(ExploreHolder exploreHolder, MainExplorerModel mainExplorerModel) {
        exploreHolder.tvMore.setVisibility(View.GONE);
        exploreHolder.tvTitle.setText(mainExplorerModel.getTitle());

        RecyclerView.LayoutManager layoutManager = null;
        layoutManager = new GridLayoutManager(mContext, 4, GridLayoutManager
                .VERTICAL, false);

        RecyclerView.Adapter adapter = new ExplorerAdaptor(mContext, mainExplorerModel.getExplorerArrayList());
        exploreHolder.mRecyclerView.setLayoutManager(layoutManager);

        exploreHolder.mRecyclerView.setAdapter(adapter);

    }

    private void initPromotionExplorer(PromotionHolder promotionHolder, MainExplorerModel mainExplorerModel) {
        promotionHolder.tvTitle.setText(mainExplorerModel.getTitle());

        promotionHolder.tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mActivity, PromotionActivity.class);
                mActivity.startActivity(i);
            }
        });

        RecyclerView.LayoutManager layoutManager = null;
        layoutManager = new GridLayoutManager(mContext, 1, GridLayoutManager
                .HORIZONTAL, false);

        RecyclerView.Adapter adapter = new OffersAdaptor(mContext, mainExplorerModel.getOffersArrayList());
        promotionHolder.mRecyclerView.setLayoutManager(layoutManager);
        promotionHolder.mRecyclerView.addItemDecoration(new ItemDecorator(mActivity));

        promotionHolder.mRecyclerView.setAdapter(adapter);

    }

    private void initSuggestExplorer(SuggestHolder suggestHolder, MainExplorerModel mainExplorerModel) {
        suggestHolder.tvTitle.setText(mainExplorerModel.getTitle());

        RecyclerView.LayoutManager layoutManager = null;
        layoutManager = new GridLayoutManager(mContext, 1, GridLayoutManager
                .HORIZONTAL, false);

        RecyclerView.Adapter adapter = new SuggestedAdaptor(mContext, mainExplorerModel.getTravelMateArrayList());
        suggestHolder.mRecyclerView.setLayoutManager(layoutManager);
        suggestHolder.mRecyclerView.addItemDecoration(new ItemDecorator(mActivity));

        suggestHolder.mRecyclerView.setAdapter(adapter);

    }

    private void initTrendingExplorer(TrendingHolder suggestHolder, MainExplorerModel mainExplorerModel) {
        suggestHolder.tvTitle.setText(mainExplorerModel.getTitle());

        RecyclerView.LayoutManager layoutManager = null;
        layoutManager = new GridLayoutManager(mContext, 1, GridLayoutManager
                .VERTICAL, false);

        RecyclerView.Adapter adapter = new TrendingAdaptor(mContext, mainExplorerModel.getSearchResultArrayList());
        suggestHolder.mRecyclerView.setLayoutManager(layoutManager);
        suggestHolder.mRecyclerView.addItemDecoration(new ItemDecorator(mActivity));

        suggestHolder.mRecyclerView.setAdapter(adapter);

    }


    class ExploreHolder extends RecyclerView.ViewHolder {
        public RecyclerView mRecyclerView;
        public TextView tvTitle;
        public TextView tvMore;

        ExploreHolder(View v) {
            super(v);
            mRecyclerView = v.findViewById(R.id.content_second_recyclerview);
            tvTitle = v.findViewById(R.id.tv_title);
            tvMore = v.findViewById(R.id.tv_more);
        }
    }

    class PromotionHolder extends RecyclerView.ViewHolder {
        public RecyclerView mRecyclerView;
        public TextView tvTitle;
        public TextView tvMore;

        PromotionHolder(View v) {
            super(v);
            mRecyclerView = v.findViewById(R.id.content_second_recyclerview);
            tvTitle = v.findViewById(R.id.tv_title);
            tvMore = v.findViewById(R.id.tv_more);
        }
    }

    class SuggestHolder extends RecyclerView.ViewHolder {
        public RecyclerView mRecyclerView;
        public TextView tvTitle;
        public TextView tvMore;

        SuggestHolder(View v) {
            super(v);
            mRecyclerView = v.findViewById(R.id.content_second_recyclerview);
            tvTitle = v.findViewById(R.id.tv_title);
            tvMore = v.findViewById(R.id.tv_more);
        }
    }

    class TrendingHolder extends RecyclerView.ViewHolder {
        public RecyclerView mRecyclerView;
        public TextView tvTitle;
        public TextView tvMore;

        TrendingHolder(View v) {
            super(v);
            mRecyclerView = v.findViewById(R.id.content_second_recyclerview);
            tvTitle = v.findViewById(R.id.tv_title);
            tvMore = v.findViewById(R.id.tv_more);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case GoloConstants.EXPLORER_VIEW:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .item_main_content, null, false);
                return new ExploreHolder(view);
            case GoloConstants.OFFER_VIEW:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .item_main_content_margin, null, false);
                return new PromotionHolder(view);
            case GoloConstants.SUGGEST_VIEW:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .item_main_content_margin, null, false);
                return new SuggestHolder(view);
            case GoloConstants.TRENDING_VIEW:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .item_main_content_margin, null, false);
                return new TrendingHolder(view);
        }
        return null;
    }

}
