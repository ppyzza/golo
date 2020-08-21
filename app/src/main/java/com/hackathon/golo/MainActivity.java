package com.hackathon.golo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityEmptyWithBackToolBar.class);
                intent.putExtra("fragment", "create_plan");
                startActivity(intent);
            }
        });
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
