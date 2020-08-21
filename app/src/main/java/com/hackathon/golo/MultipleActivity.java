package com.hackathon.golo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hackathon.golo.R;
import com.hackathon.golo.myplan.TabPageAdapter;

import java.util.ArrayList;


public class MultipleActivity extends Fragment {

    TabLayout tabLayout;

    ViewPager viewPager;
    private Activity mActivity;
    private ArrayList<String> categoryList = new ArrayList<>();
    private TabPageAdapter adapter;
    private String titleArray[];

    public MultipleActivity() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // categoryList = getArguments().getStringArrayList("menuList");
        }
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_myplan_tabs, container, false);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.pager);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        titleArray = getResources().getStringArray(R.array.menu_coupon);

        for (int i = 0; i < titleArray.length; i++) {
            categoryList.add(titleArray[i]);
        }

        for (int i = 0; i < categoryList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(categoryList.get(i)));
        }

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        adapter = new TabPageAdapter(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
    }
}
