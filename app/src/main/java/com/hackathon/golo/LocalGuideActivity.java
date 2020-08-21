package com.hackathon.golo;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.golo.adaptor.LocalListAdaptor;
import com.hackathon.golo.adaptor.TogoAdaptor;
import com.hackathon.golo.model.LocalDetail;
import com.hackathon.golo.model.Locals;

import java.util.ArrayList;

public class LocalGuideActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Activity mActivity;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Locals> localsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_local_detail);

        mRecyclerView = findViewById(R.id.content_recyclerview);
        mActivity = LocalGuideActivity.this;


        Locals locals = new Locals();
        locals.setViewType("top");
        LocalDetail localDetail = new LocalDetail();
        localDetail.setDistance(10);
        localDetail.setHours(2);
        localDetail.setName("Korea Tour Online");
        localDetail.setPlanReview(20);
        localDetail.setTitle("Korea Tour Online");
        localDetail.setPrice("1,080");

        locals.setLocalDetail(localDetail);

        localsArrayList.add(locals);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new LocalListAdaptor(mActivity, localsArrayList);

        mRecyclerView.setAdapter(mAdapter);
    }
}
