package com.hackathon.golo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.golo.adaptor.LocalListAdaptor;
import com.hackathon.golo.adaptor.TogoContentAdaptor;
import com.hackathon.golo.fragment.PaymentDialogFragment;
import com.hackathon.golo.model.LocalDetail;
import com.hackathon.golo.model.Locals;
import com.hackathon.golo.model.PlanList;

import java.util.ArrayList;

public class ItinerariesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Activity mActivity;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Locals> localsArrayList = new ArrayList<>();
    private ArrayList<PlanList> planLists = new ArrayList<>();
    private Button buttonPay;
    private LinearLayout rlPay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_it);

        mRecyclerView = findViewById(R.id.content_recyclerview);
        buttonPay = findViewById(R.id.bt_ok);
        rlPay = findViewById(R.id.rl_pay);

        mActivity = ItinerariesActivity.this;
        Locals locals;
        PlanList planList;

        locals = new Locals();
        locals.setViewType("top");
        LocalDetail localDetail = new LocalDetail();

        locals.setLocalDetail(localDetail);

        localsArrayList.add(locals);

        locals = new Locals();
        locals.setViewType("other");
        planList = new PlanList();
        planList.setViewType("start");
        planLists.add(planList);

        locals.setLocalDetail(localDetail);

        planList = new PlanList();
        planList.setDistance("(67 Reviews) | 7 km from here");
        planList.setKm(1.5);
        planList.setPlaceName("Wat Phra That Doi Suthep");
        planList.setReview(67);
        planList.setViewType("place");
        planLists.add(planList);

        planList = new PlanList();
        planList.setDistance("20 mins by bus");
        planList.setViewType("middle");
        planLists.add(planList);

        planList = new PlanList();
        planList.setDistance("(100 Reviews) | 0.5 km from here");
        planList.setKm(10);
        planList.setPlaceName("Nimman Road (Nimmanhemin)");
        planList.setReview(10);
        planList.setViewType("place");
        planLists.add(planList);

        planList = new PlanList();
        planList.setDistance("10 mins by bus");
        planList.setViewType("middle");
        planLists.add(planList);

        planList = new PlanList();
        planList.setDistance("(100 Reviews) | 5 km from here");
        planList.setKm(10);
        planList.setPlaceName("Warorot Market (or Kad Luang)");
        planList.setReview(10);
        planList.setViewType("place");
        planLists.add(planList);

        planList = new PlanList();
        planList.setDistance("15 mins by walking");
        planList.setViewType("middle");
        planLists.add(planList);

        planList = new PlanList();
        planList.setDistance("(100 Reviews) | 3 km from here");
        planList.setKm(10);
        planList.setPlaceName("Tha Pae Gate");
        planList.setReview(10);
        planList.setViewType("place");
        planLists.add(planList);

        planList = new PlanList();
        planList.setReview(10);
        planList.setViewType("bottom");
        planLists.add(planList);
        localDetail.setPlanListArrayList(planLists);

        localsArrayList.add(locals);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new TogoContentAdaptor(mActivity, localsArrayList);

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
                        Locals locals1 = localsArrayList.get(0);
                        locals1.setPay(true);
                        localsArrayList.set(0, locals1);

                        mAdapter.notifyDataSetChanged();
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
