package com.hackathon.golo.normalactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hackathon.golo.R;
import com.hackathon.golo.adaptor.TabAdapter;
import com.hackathon.golo.fragment.ExplorerFragment;
import com.hackathon.golo.fragment.FindExplorerFragment;
import com.hackathon.golo.fragment.PlanningFragment;
import com.hackathon.golo.fragment.TabViewFragment;
import com.hackathon.golo.model.PlanModel;
import com.hackathon.golo.model.PlaningModel;
import com.hackathon.golo.model.SelectLocationModel;
import com.hackathon.golo.model.UserModel;
import com.hackathon.golo.myplan.MyPlanMultipleTabFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class PlanningActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PlanModel value;
    private List<SelectLocationModel> selectLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.planning_fragment, new PlanningFragment());
        transaction.commit();

        setContentView(R.layout.activity_planning);

        Intent i = getIntent();
        String planId = i.getStringExtra("planId");
        Log.d(TAG, "plan id is: " + planId );

        final DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference mPlanRef = mRootRef.child("plan/userid-2/" + planId);

        mPlanRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                value = dataSnapshot.getValue(PlanModel.class);
                String form = value.getFrom();
                String to = value.getTo();
                TextView locationPeriod = (TextView)findViewById(R.id.location_period_from_to);
                if(locationPeriod != null) {
                    locationPeriod.setText(form + " - " + to);

                    TextView planName = (TextView)findViewById(R.id.plan_name);
                    planName.setText(value.getPlanName());
                    setTabView(value);

                    Log.d(TAG, "Value plan is: " + dataSnapshot.toString());

                }

            }

            public void setTabView(PlanModel value) {
                viewPager = (ViewPager) findViewById(R.id.viewPager);
                tabLayout = (TabLayout) findViewById(R.id.tabLayout);
                adapter = new TabAdapter(getSupportFragmentManager());
                for(String dateRangeKey : value.dateRange.keySet()) {
                    String[] date = dateRangeKey.split("-");
                    TabViewFragment tabViewFragment = new TabViewFragment();
                    adapter.addFragment(tabViewFragment, String.format("%s/%s", date[2], date[1]));
                }
                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);

                MaterialButton goExplore = findViewById(R.id.go_explore);
                goExplore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.planning_fragment, new MyPlanMultipleTabFragment());
                        transaction.commit();
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
//                        Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SelectLocationModel event) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.add_here_mock, new PlanningFragment());
        transaction.commit();
    };

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}