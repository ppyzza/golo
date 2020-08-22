package com.hackathon.golo.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.hackathon.golo.GlideApp;
import com.hackathon.golo.R;
import com.hackathon.golo.account.AccountPagerAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class AccountFollowFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView tvName;
    private ArrayList<String> data = new ArrayList<>();

    private AccountPagerAdapter adapter;
    private String titleArray[];
    private String name;
    private String image;
    private ImageView imageView;
    private Activity mActivity;

    public static AccountFollowFragment newInstance(String name, String image) {
        AccountFollowFragment fragment = new AccountFollowFragment();
        Bundle args = new Bundle();
        args.putString("name", name);
        args.putString("image", image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account_follow, container, false);

        if (getArguments() != null) {
            name = getArguments().getString("name");
            image = getArguments().getString("image");
        }
        tabLayout = rootView.findViewById(R.id.tab_layout);
        viewPager = rootView.findViewById(R.id.pager);
        tvName = rootView.findViewById(R.id.tv_name);
        imageView = rootView.findViewById(R.id.iv_profile);
        Glide.with(mActivity).load(image).into(imageView);

        tvName.setText(name);
        Log.i("tag", "Touch In!");
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        data.add("Plans");
        data.add("Local Guides");
        data.add("Reviews");

        for (int i = 0; i < data.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(data.get(i)));
        }

        adapter = new AccountPagerAdapter(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
