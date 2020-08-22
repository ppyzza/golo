package com.hackathon.golo;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hackathon.golo.adaptor.PromotionAdaptor;
import com.hackathon.golo.contract.PromotionContract;
import com.hackathon.golo.fragment.ConfirmRedeemDialogFragment;
import com.hackathon.golo.model.Attribute;
import com.hackathon.golo.model.Campaign;
import com.hackathon.golo.model.Promotion;
import com.hackathon.golo.model.RedeemRequest;
import com.hackathon.golo.presenters.PromotionPresenter;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PromotionActivity extends AppCompatActivity implements PromotionContract.View, PromotionAdaptor.AdapterCallback {
    private ArrayList<Promotion> promotionList;
    private RecyclerView mRecyclerView;
    private TextView tvUserPoint;
    private RecyclerView.Adapter mAdapter;
    private PromotionPresenter promotionPresenter;
    private DatabaseReference mDatabase;
    private Integer count = 1;
    private Integer sumPoint = 0;
    private Integer userPoint = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);

        promotionPresenter = new PromotionPresenter(this);
        promotionPresenter.getPromotionDetail();

        mDatabase = FirebaseDatabase.getInstance().getReference();

        final DatabaseReference mMessagesRef = mDatabase.child("user").child("userid-2");
        mMessagesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    if (ds.getKey().contains("point")) {
                        userPoint = ds.getValue(Integer.class);
                        tvUserPoint.setText("Your Point : "+ userPoint);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView = (RecyclerView) findViewById(R.id.promotion_content_recyclerview);
        tvUserPoint = (TextView) findViewById(R.id.tv_user_point);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void showPromotionSuccess(ArrayList<Promotion> promotion) {
    }

    @Override
    public void showPromotionDetailSuccess(ArrayList<Promotion> promotion) {
        promotionList = new ArrayList<>();
        promotionList = promotion;
        mAdapter = new PromotionAdaptor(this, promotionList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showRedeemSuccess(Campaign redeem) {
        final DatabaseReference mMessagesRef = mDatabase.child("user").child("userid-2");
        mMessagesRef.child("point").setValue(userPoint - sumPoint);
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Redeem Success", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void showRedeemFail() {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Redeem Fail", Toast.LENGTH_LONG);
        toast.show();
        sumPoint = userPoint;
    }

    @Override
    public void onMethodCallback(final Integer position) {
        sumPoint = promotionList.get(position).getPointDiscount();
        if(userPoint < promotionList.get(position).getPointDiscount()){
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Point not enough", Toast.LENGTH_LONG);
            toast.show();
        }else {
            final ConfirmRedeemDialogFragment redeemBottomDialogFragment =
                    ConfirmRedeemDialogFragment.newInstance();

            redeemBottomDialogFragment.show(getSupportFragmentManager(),
                    "confirm_dialog");
            redeemBottomDialogFragment.setConfirmRedeemDialogInterface(
                    new ConfirmRedeemDialogFragment.ConfirmRedeemDialogInterface() {
                        @Override
                        public void confirm() {
                            if (promotionList.get(position).getPointDiscount() > userPoint) {
                                Context context = getApplicationContext();
                                Toast toast = Toast.makeText(context, "Point not enough", Toast.LENGTH_LONG);
                                toast.show();
                            } else {
                                final Attribute attribute = new Attribute();
                                attribute.setTravel("Chiang mai");
                                RedeemRequest request = new RedeemRequest();
                                request.setCampaignCode(promotionList.get(position).getRedeemCode());
                                request.setChannel("");
                                request.setAttribute(attribute);
                                sumPoint = userPoint - promotionList.get(position).getPointDiscount();
                                promotionPresenter.redeem(request);
                            }
                        }

                        @Override
                        public void cancel() {

                        }
                    }, sumPoint
            );
        }
    }
}
