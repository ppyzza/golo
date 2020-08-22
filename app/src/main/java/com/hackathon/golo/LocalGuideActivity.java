package com.hackathon.golo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hackathon.golo.adaptor.LocalListAdaptor;
import com.hackathon.golo.fragment.PaymentDialogFragment;
import com.hackathon.golo.model.LocalDetail;
import com.hackathon.golo.model.Locals;
import com.hackathon.golo.model.PlanList;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LocalGuideActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Activity mActivity;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Locals> localsArrayList = new ArrayList<>();
    private ArrayList<PlanList> planLists = new ArrayList<>();
    private Button buttonPay;
    private LinearLayout rlPay;
    private DatabaseReference mDatabase;
    private int newPoint;

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
        localDetail.setDetail("This is a book");

        locals.setLocalDetail(localDetail);

        localsArrayList.add(locals);


        locals = new Locals();
        locals.setViewType("other");
        localDetail = new LocalDetail();
        localDetail.setDistance(10);
        localDetail.setHours(2);
        localDetail.setName("Korea Tour Online");
        localDetail.setPlanReview(20);
        localDetail.setTitle("Korea Tour Online");
        localDetail.setPrice("1,080 Bath/Person");
        localDetail.setDetail("This is a book");

        locals.setLocalDetail(localDetail);

        PlanList planList = new PlanList();
        planList.setDistance(20);
        planList.setKm(10);
        planList.setPlaceName("Ascend B2B CTA");
        planList.setReview(10);
        planList.setViewType("start");
        planLists.add(planList);

        planList = new PlanList();
        planList.setDistance(20);
        planList.setKm(10);
        planList.setPlaceName("Ascend B2B CTA");
        planList.setReview(10);
        planList.setViewType("place");
        planLists.add(planList);

        planList = new PlanList();
        planList.setDistance(20);
        planList.setKm(10);
        planList.setPlaceName("Ascend B2B CTA");
        planList.setReview(10);
        planList.setViewType("middle");
        planLists.add(planList);

        planList = new PlanList();
        planList.setDistance(20);
        planList.setKm(10);
        planList.setPlaceName("Galaxy Far Far Away");
        planList.setReview(10);
        planList.setViewType("place");
        planLists.add(planList);

        planList = new PlanList();
        planList.setDistance(20);
        planList.setKm(10);
        planList.setPlaceName("Galaxy Far Far Away");
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

        mAdapter = new LocalListAdaptor(mActivity, localsArrayList);

        mRecyclerView.setAdapter(mAdapter);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        final DatabaseReference mMessagesRef = mDatabase.child("user").child("userid-2");
        mMessagesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    if (ds.getKey().contains("point")) {
                        Integer point = ds.getValue(Integer.class);
                        newPoint = point += 10;
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

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

                        mMessagesRef.child("point").setValue(newPoint);

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
