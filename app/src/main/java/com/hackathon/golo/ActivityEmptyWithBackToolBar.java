package com.hackathon.golo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hackathon.golo.fragment.CreatePlanFragment;

import java.time.Instant;

import static android.content.ContentValues.TAG;

public class ActivityEmptyWithBackToolBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_with_back_tool_bar);
        Intent i = getIntent();
        String fragmentName = i.getStringExtra("fragment");
        Fragment fragment;

        switch (fragmentName) {
            case "create_plan":
                fragment = new CreatePlanFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.mainframe, fragment)
                        .commit();
            default:
        }

    }
}