package com.hackathon.golo;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.golo.adaptor.LocalListAdaptor;
import com.hackathon.golo.adaptor.TogoAdaptor;
import com.hackathon.golo.fragment.PaymentDialogFragment;
import com.hackathon.golo.model.LocalDetail;
import com.hackathon.golo.model.Locals;

import java.util.ArrayList;

public class LocalGuideActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Activity mActivity;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Locals> localsArrayList = new ArrayList<>();
    private Button buttonPay;
    private LinearLayout rlPay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_local_detail);

        mRecyclerView = findViewById(R.id.content_recyclerview);
        buttonPay = findViewById(R.id.bt_ok);
        rlPay = findViewById(R.id.rl_pay);

        mActivity = LocalGuideActivity.this;


        Locals locals = new Locals();
        locals.setViewType("top");
        LocalDetail localDetail = new LocalDetail();
        localDetail.setDistance(10);
        localDetail.setHours(2);
        localDetail.setName("Korea Tour Online");
        localDetail.setPlanReview(20);
        localDetail.setTitle("Korea Tour Online");
        localDetail.setPrice("1,080 Bath/Person");

        locals.setLocalDetail(localDetail);

        localsArrayList.add(locals);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new LocalListAdaptor(mActivity, localsArrayList);

        mRecyclerView.setAdapter(mAdapter);

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PaymentDialogFragment addPhotoBottomDialogFragment =
                        PaymentDialogFragment.newInstance();

                addPhotoBottomDialogFragment.show(getSupportFragmentManager(),
                        "payment_dialog");
                addPhotoBottomDialogFragment.setPaymentDialogInterface(new PaymentDialogFragment.PaymentDialogInterface() {
                    @Override
                    public void payment() {
                        rlPay.setVisibility(View.GONE);
                    }

                    @Override
                    public void cancel() {

                    }
                });

            }
        });


    }
}
