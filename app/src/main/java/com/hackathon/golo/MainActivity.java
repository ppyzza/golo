package com.hackathon.golo;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hackathon.golo.model.PlanModel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {
    }

    private BottomNavigationView navView;
    private FrameLayout fabFrame;
    private LinearLayout layoutCreateNewPlan;
    private LinearLayout layOutLocalGuide;
    private FloatingActionButton fab;
    private RelativeLayout rl_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fabFrame = findViewById(R.id.fabFrame);
        navView = findViewById(R.id.nav_view);
        fab = findViewById(R.id.fab);
        rl_back = findViewById(R.id.rl_back);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_explorer, R.id.navigation_favorites, R.id.navigation_my_plans, R.id.navigation_account)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        FirebaseApp.initializeApp(this);
        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mPlanRef = mRootRef.child("plan/" + getUid());
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        mPlanRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Log.d("FJTAG", dataSnapshot.toString());
//                String value = dataSnapshot.getValue(String.class);`
//                builder.setCancelable(false);
//                builder.setMessage(value);
//                AlertDialog dialog = builder.create();
//                dialog.show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
        buttonAction();
        closeSubMenusFab();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSubMenusFab();
            }
        });
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeSubMenusFab();
            }
        });
        createPlan();
    }

    private void createPlan() {
        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mPlanRef = mRootRef.child("plan/" + getUid());
        String key = mPlanRef.push().getKey();
        PlanModel planModel = new PlanModel("ไว้ไปด้วยกันนะ", "1", "2020-08-21", "2020-08-22");
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/" + key, planModel);
        mPlanRef.updateChildren(childUpdates);
    }

    private String getUid() {
        return "userid-1";
    }

    private void buttonAction() {

        layoutCreateNewPlan = (LinearLayout) this.findViewById(R.id.layOutCreateNewPlan);
        layoutCreateNewPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        layOutLocalGuide = (LinearLayout) this.findViewById(R.id.layOutLocalGuide);
        layOutLocalGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void closeSubMenusFab() {
        fabFrame.setVisibility(View.GONE);
        fab.setVisibility(View.VISIBLE);
        navView.setVisibility(View.VISIBLE);
    }

    //Opens FAB submenus
    private void openSubMenusFab() {
        fabFrame.setVisibility(View.VISIBLE);
        fab.setVisibility(View.GONE);
        navView.setVisibility(View.GONE);
    }
}
