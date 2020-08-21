package com.hackathon.golo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MultipleActivity extends AppCompatActivity {

    TabLayout tabLayout;

    ViewPager viewPager;
    private Activity mActivity;
    private ArrayList<String> categoryList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_tab);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.pager);

    }
}