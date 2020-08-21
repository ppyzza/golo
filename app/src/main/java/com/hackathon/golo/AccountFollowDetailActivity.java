package com.hackathon.golo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.hackathon.golo.fragment.AccountFollowFragment;
import com.hackathon.golo.fragment.CreatePlanFragment;
import com.hackathon.golo.normalactivity.ExplorerDetailActivity;

import pl.aprilapps.switcher.Switcher;

public class AccountFollowDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_account_follow);

        Intent i = getIntent();
        String fragmentName = i.getStringExtra("fragment");
        Fragment fragment;

        switch (fragmentName) {
            case "account_follow":
                fragment = new AccountFollowFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.pager, fragment)
                        .commit();
            default:
        }

    }

}
