package com.hackathon.golo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hackathon.golo.adaptor.PromotionAdaptor;
import com.hackathon.golo.contract.PromotionContract;
import com.hackathon.golo.model.Attribute;
import com.hackathon.golo.model.Campaign;
import com.hackathon.golo.model.Promotion;
import com.hackathon.golo.model.RedeemRequest;
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
    private TextView tvName;
    private TextView tvDescription;
    private TextView tvDetail;
    private TextView tvSumPoint;
    private TextView tvYourPoint;
    private ImageView ivDetail;
    private Integer sumPoint = 800;
    private Button buttonRedeem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion_detail);

        tvName = (TextView) findViewById(R.id.tv_name_coupon);
        tvDescription = (TextView) findViewById(R.id.tv_description_coupon);
        tvDetail = (TextView) findViewById(R.id.tv_detail);
        tvSumPoint = (TextView) findViewById(R.id.tv_sum_point);
        tvYourPoint = (TextView) findViewById(R.id.tv_your_point);
        ivDetail = (ImageView) findViewById(R.id.iv_image);
        promotionPresenter = new PromotionPresenter(this);
        promotionPresenter.getPromotionDetail();
        final Attribute attribute = new Attribute();
        attribute.setTravel("Chiang mai");

        buttonRedeem = (Button) findViewById(R.id.button_redeem);

        buttonRedeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedeemRequest request  = new RedeemRequest();
                request.setCampaignCode(promotionList.get(0).getRedeemCode());
                request.setChannel("");
                request.setAttribute(attribute);
                promotionPresenter.redeem(request);

            }
        });

        FirebaseApp.initializeApp(this);
        final DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference mPlanRef = mRootRef.child("plan/" + getUid());
        String key = mPlanRef.push().getKey();

    }

    private String getUid() {
        return "userid-2";
    }

    @Override
    public void showPromotionSuccess(ArrayList<Promotion> promotion) {
    }

    @Override
    public void showPromotionDetailSuccess(ArrayList<Promotion> promotion) {
        if (!promotion.isEmpty()) {
            promotionList = promotion;
            Glide.with(this).load(promotion.get(0).getImage()).into(ivDetail);
            tvName.setText(promotion.get(0).getName());
            tvDescription.setText(promotion.get(0).getDescription());
            tvDetail.setText(promotion.get(0).getVoucherDetail());
            tvSumPoint.setText(sumPoint);
            tvYourPoint.setText("900");
        }

    }

    @Override
    public void showRedeemSuccess(Campaign campaign) {
        Log.i("tag", "Success");
    }

    @Override
    public void showRedeemFail() {
        Log.i("tag", "Error");
    }
}
