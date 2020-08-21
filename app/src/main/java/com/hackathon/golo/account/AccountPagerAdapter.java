package com.hackathon.golo.account;

import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.hackathon.golo.account.fragment.AccountPlanFragment;
import com.hackathon.golo.account.fragment.AccountPlanLocalFragment;
import com.hackathon.golo.account.fragment.AccountReviewerFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AccountPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    int tabPosition = 0;
    private SparseArray<Fragment> registeredFragments = new SparseArray<>();

    public AccountPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("FJTAG", "tabPosition: " + tabPosition);
        switch (position) {
            case 1:
                tabPosition = position;
                AccountPlanLocalFragment mainFragment1 = new AccountPlanLocalFragment();
                return mainFragment1;
            case 2:
                tabPosition = position;
                AccountReviewerFragment mainFragment12 = new AccountReviewerFragment();
                return mainFragment12;

            default:
                tabPosition = position;
                AccountPlanFragment mainFragment = new AccountPlanFragment();
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
