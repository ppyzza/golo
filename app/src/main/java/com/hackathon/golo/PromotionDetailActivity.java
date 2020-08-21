package com.hackathon.golo;

import android.os.Bundle;

import com.hackathon.golo.adaptor.PromotionAdaptor;
import com.hackathon.golo.contract.PromotionContract;
import com.hackathon.golo.model.Promotion;
import com.hackathon.golo.model.PromotionModel;
import com.hackathon.golo.presenters.PromotionPresenter;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PromotionDetailActivity extends AppCompatActivity implements PromotionContract.View {
    private ArrayList<Promotion> promotionList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private PromotionPresenter promotionPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion_detail);
    }

    @Override
    public void showPromotionSuccess(ArrayList<Promotion> promotion) {
    }
}
