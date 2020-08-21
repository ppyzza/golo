package com.hackathon.golo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hackathon.golo.R;
import com.hackathon.golo.account.AccountPagerAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class AccountFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView tvPoint;
    private ArrayList<String> data = new ArrayList<>();

    private AccountPagerAdapter adapter;
    private String titleArray[];
    private DatabaseReference mDatabase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);
        tabLayout = rootView.findViewById(R.id.tab_layout);
        viewPager = rootView.findViewById(R.id.pager);
        tvPoint = rootView.findViewById(R.id.tv_point);
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

        mDatabase = FirebaseDatabase.getInstance().getReference();

        final DatabaseReference mMessagesRef = mDatabase.child("user").child("userid-2");
        mMessagesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    if (ds.getKey().contains("point")) {
                        Integer point = ds.getValue(Integer.class);
                        tvPoint.setText(point + " Points");
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

    }
}
