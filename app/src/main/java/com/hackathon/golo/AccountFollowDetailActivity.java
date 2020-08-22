package com.hackathon.golo;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.hackathon.golo.fragment.AccountFollowFragment;

public class AccountFollowDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_account_follow);

        Intent i = getIntent();
        String fragmentName = i.getStringExtra("fragment");
        AccountFollowFragment fragment;

        switch (fragmentName) {
            case "account_follow":
                fragment = AccountFollowFragment.newInstance(i.getStringExtra("name"), i.getStringExtra("image"));
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.pager, fragment)
                        .commit();
            default:
        }

    }

}
