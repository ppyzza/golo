package com.hackathon.golo.accountfollow.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.golo.R;
import com.hackathon.golo.accountfollow.adaptor.AccountPlanAdaptor;
import com.hackathon.golo.accountfollow.model.AccountPlanModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AccountPlanFragment extends Fragment {

    private Activity mActivity;
    private RecyclerView mRecyclerView;
    private ArrayList<AccountPlanModel> accountPlanModelArrayList = new ArrayList<>();
    private AccountPlanAdaptor adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account_tab, container, false);
        mRecyclerView = rootView.findViewById(R.id.content_recyclerview);

        mActivity = getActivity();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);

        adapter = new AccountPlanAdaptor(mActivity);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        accountPlanModelArrayList.add(
                new AccountPlanModel("Party Pattaya" , "Sat, Aug 29 - Sun, Aug 30" ,
                        "Bangkok | 2 Day | 10 Places"));

        accountPlanModelArrayList.add(
                new AccountPlanModel("Chiang Mai 2020" , "Tue, Sep 01 - Sat, Sep 05" ,
                        "Chiangmai | 5 Day | 36 Places"));

        accountPlanModelArrayList.add(
                new AccountPlanModel("Bangkok in you area" , "Mon, Sep 07 - Mon, Sep 07" ,
                        "Pattaya | 1 Day | 5 Places"));

        adapter.planList = accountPlanModelArrayList;
        adapter.notifyDataSetChanged();

    }
}
