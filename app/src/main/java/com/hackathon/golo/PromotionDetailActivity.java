package com.hackathon.golo;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hackathon.golo.adaptor.PromotionAdaptor;
import com.hackathon.golo.contract.PromotionContract;
import com.hackathon.golo.fragment.ConfirmRedeemDialogFragment;
import com.hackathon.golo.fragment.PaymentDialogFragment;
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
    private TextView tvCount;
    private TextView tvPoint;
    private ImageView ivDetail;
    private ImageView ivMinus;
    private ImageView ivPlus;
    private Button buttonRedeem;
    private DatabaseReference mDatabase;
    private Integer count = 1;
    private Integer sumPoint = 0;
    private Integer userPoint = 0;

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
        tvCount = (TextView)  findViewById(R.id.tv_count);
        tvPoint = (TextView)  findViewById(R.id.tv_point_coupon);
        promotionPresenter = new PromotionPresenter(this);
        promotionPresenter.getPromotionDetail();
        final Attribute attribute = new Attribute();
        attribute.setTravel("Chiang mai");

        buttonRedeem = (Button) findViewById(R.id.button_redeem);

        buttonRedeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ConfirmRedeemDialogFragment redeemBottomDialogFragment =
                        ConfirmRedeemDialogFragment.newInstance();

                redeemBottomDialogFragment.show(getSupportFragmentManager(),
                        "confirm_dialog");
                redeemBottomDialogFragment.setConfirmRedeemDialogInterface(new ConfirmRedeemDialogFragment.ConfirmRedeemDialogInterface() {
                    @Override
                    public void confirm() {
                        if(sumPoint > userPoint){
                            Context context = getApplicationContext();
                            Toast toast = Toast.makeText(context, "Point not enough", Toast.LENGTH_LONG);
                            toast.show();
                        } else {
                            RedeemRequest request  = new RedeemRequest();
                            request.setCampaignCode(promotionList.get(0).getRedeemCode());
                            request.setChannel("");
                            request.setAttribute(attribute);
                            promotionPresenter.redeem(request);
                        }
                    }

                    @Override
                    public void cancel() {

                    }
                }
               );
            }
        });

        ivMinus = (ImageView) findViewById(R.id.btt_minus);

        ivMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count > 1){
                    count--;
                    tvCount.setText(count.toString());
                    if(!promotionList.isEmpty()){
                        sumPoint = promotionList.get(0).getPointDiscount() * count;
                        tvSumPoint.setText(sumPoint.toString());
                    }
                }
            }
        });
        ivPlus = (ImageView) findViewById(R.id.btt_plus);
        ivPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                tvCount.setText(count.toString());
                if(!promotionList.isEmpty()){
                    sumPoint = promotionList.get(0).getPointDiscount() * count;
                    tvSumPoint.setText(sumPoint.toString());
                }

            }
        });

        mDatabase = FirebaseDatabase.getInstance().getReference();

        final DatabaseReference mMessagesRef = mDatabase.child("user").child("userid-2");
        mMessagesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    if (ds.getKey().contains("point")) {
                        userPoint = ds.getValue(Integer.class);
                        tvYourPoint.setText("Your Point "+ userPoint);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

    }

    @Override
    public void showPromotionSuccess(ArrayList<Promotion> promotion) {
    }

    @Override
    public void showPromotionDetailSuccess(ArrayList<Promotion> promotion) {
        if (!promotion.isEmpty()) {
            promotionList = promotion;
            sumPoint = promotion.get(0).getPointDiscount();
            tvName.setText(promotion.get(0).getName());
            tvDescription.setText(promotion.get(0).getDescription());
            tvDetail.setText(promotion.get(0).getVoucherDetail());
            tvSumPoint.setText(promotion.get(0).getPointDiscount());
            tvPoint.setText(promotion.get(0).getPoint());
            Glide.with(this).load(promotion.get(0).getImage()).into(ivDetail);
        }

    }

    @Override
    public void showRedeemSuccess(Campaign campaign) {
        Log.i("tag", "Success");
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Redeem Success", Toast.LENGTH_LONG);
        toast.show();

        // filebase minus point
    }

    @Override
    public void showRedeemFail() {
        Log.i("tag", "Error");
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Redeem Fail", Toast.LENGTH_LONG);
        toast.show();
    }
}
