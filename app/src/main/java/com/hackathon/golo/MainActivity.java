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

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navView = findViewById(R.id.nav_view);
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
//                String value = dataSnapshot.getValue(String.class);
//                builder.setCancelable(false);
//                builder.setMessage(value);
//                AlertDialog dialog = builder.create();
//                dialog.show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
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

}
