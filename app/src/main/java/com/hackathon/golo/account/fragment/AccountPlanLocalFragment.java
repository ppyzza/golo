package com.hackathon.golo.account.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.golo.R;
import com.hackathon.golo.account.adaptor.AccountPlanAdaptor;
import com.hackathon.golo.account.adaptor.AccountPlanLocalAdaptor;
import com.hackathon.golo.account.model.AccountPlanModel;
import com.hackathon.golo.tools.ItemDecorator;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AccountPlanLocalFragment extends Fragment {

    private Activity mActivity;
    private RecyclerView mRecyclerView;
    private ArrayList<AccountPlanModel> accountPlanModelArrayList = new ArrayList<>();
    private AccountPlanLocalAdaptor adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account_tab, container, false);
        mRecyclerView = rootView.findViewById(R.id.content_recyclerview);

        mActivity = getActivity();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);

        adapter = new AccountPlanLocalAdaptor(mActivity);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        accountPlanModelArrayList.add(
                new AccountPlanModel("Bangkok’s Favorite Food Tour: 10 Testing"
                        , "A busy day spent exploring must-see attractions, including Wat Arun, The Grand Palace, and Te…" ,
                        "Bangkok | 1 Day | 6 Places"));

        adapter.planList = accountPlanModelArrayList;
        adapter.notifyDataSetChanged();

    }
}
