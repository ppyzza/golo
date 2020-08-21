package com.hackathon.golo;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hackathon.golo.adaptor.PromotionAdaptor;
import com.hackathon.golo.contract.PromotionContract;
import com.hackathon.golo.model.Promotion;
import com.hackathon.golo.model.PromotionModel;
import com.hackathon.golo.models.PromotionModels;
import com.hackathon.golo.presenters.PromotionPresenter;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
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

        PromotionModel promotionModel = new PromotionModel();
        promotionModel.setPromotionArrayList(promotionList);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView = (RecyclerView) findViewById(R.id.promotion_content_recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    private String getUid() {
        return "userid-1";
    }

    @Override
    public void showPromotionSuccess(ArrayList<Promotion> promotion) {
        promotionList = new ArrayList<>();
        promotionList = promotion;
        mAdapter = new PromotionAdaptor(this, promotionList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
