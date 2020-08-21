package com.hackathon.golo;

import android.os.Bundle;

import com.hackathon.golo.adaptor.PromotionAdaptor;
import com.hackathon.golo.contract.PromotionContract;
import com.hackathon.golo.model.Campaign;
import com.hackathon.golo.model.Promotion;
import com.hackathon.golo.presenters.PromotionPresenter;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PromotionActivity extends AppCompatActivity implements PromotionContract.View {
    private ArrayList<Promotion> promotionList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private PromotionPresenter promotionPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);

        promotionPresenter = new PromotionPresenter(this);
        promotionPresenter.getPromotion();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView = (RecyclerView) findViewById(R.id.promotion_content_recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void showPromotionSuccess(ArrayList<Promotion> promotion) {
        promotionList = new ArrayList<>();
        promotionList = promotion;
        mAdapter = new PromotionAdaptor(this, promotionList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showPromotionDetailSuccess(ArrayList<Promotion> promotion) {

    }

    @Override
    public void showRedeemSuccess(Campaign redeem) {

    }

    @Override
    public void showRedeemFail() {

    }
}
