package com.hackathon.golo.myplan;

import android.util.SparseArray;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.hackathon.golo.fragment.FindExplorerFragment;

public class MyPlanPageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    int tabPosition = 0;
    private SparseArray<Fragment> registeredFragments = new SparseArray<>();

    public MyPlanPageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            default:
                tabPosition = position;
                FindExplorerFragment mainFragment = new FindExplorerFragment();
                return mainFragment;
        }
    }

    public int getmNumOfTabs() {
        return mNumOfTabs;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    public int getCurrentTab() {
        return tabPosition;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }


}
