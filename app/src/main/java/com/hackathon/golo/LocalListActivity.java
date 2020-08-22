package com.hackathon.golo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.hackathon.golo.fragment.CreatePlanFragment;
import com.hackathon.golo.fragment.LocalFragment;

public class LocalListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_local);

        Intent i = getIntent();
        String fragmentName = i.getStringExtra("fragment");
        Fragment fragment;

        switch (fragmentName) {
            case "local":
                fragment = new LocalFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.rl_local, fragment)
                        .commit();
            default:
        }
    }
}
