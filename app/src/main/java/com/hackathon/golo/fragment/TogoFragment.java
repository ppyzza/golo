package com.hackathon.golo.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.golo.R;
import com.hackathon.golo.adaptor.MainExplorerAdaptor;
import com.hackathon.golo.adaptor.TogoAdaptor;
import com.hackathon.golo.model.Togo;

import java.util.ArrayList;

public class TogoFragment extends Fragment {

    private ArrayList<Togo> togoArrayList = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private Activity mActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_explorer_search, container, false);

        mActivity = getActivity();
        Togo togo = new Togo();
        togo.setTitle("If you could have a day");
        togo.setDescription("A busy day spent exploring must-see attractions, including Wat Arun, The Grand Palace, and Te…");
        togo.setPeriod("Bangkok | 1 Day | 6 Places");
        togo.setBy("Planned by Bo Chaleeporn");
        togo.setImage("https://picsum.photos/300/175");

        for (int i = 0; i < 5; i++) {
            togoArrayList.add(togo);
        }

        mRecyclerView = rootView.findViewById(R.id.content_recyclerview);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new TogoAdaptor(mActivity, togoArrayList);

        mRecyclerView.setAdapter(mAdapter);
        return rootView;


    }
}
