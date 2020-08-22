package com.hackathon.golo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.golo.adaptor.ExplorerAdaptor;
import com.hackathon.golo.adaptor.ExplorerSelectAdaptor;
import com.hackathon.golo.model.Explorer;
import com.hackathon.golo.model.MainExplorerModel;

import java.util.ArrayList;

public class SelectCategoryActivity extends AppCompatActivity {

    private TypedArray imageArray;
    private TypedArray imageSelectArray;
    private String[] titleArray;
    private ArrayList<MainExplorerModel> mainExplorerModelArrayList;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private Activity mActivity;
    private ArrayList<Explorer> listExplorer;
    private Button btOk;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_explorer_text);

        titleArray = getResources().getStringArray(R.array.menu_explorer_register_text);
        imageArray = getResources().obtainTypedArray(R.array.menu_explorer_register);
        imageSelectArray = getResources().obtainTypedArray(R.array.menu_explorer_register_select);
        mRecyclerView = findViewById(R.id.content_recyclerview);
        btOk = findViewById(R.id.bt_ok);

        mActivity = SelectCategoryActivity.this;
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        // use a linear layout manager

        listExplorer = new ArrayList<>();

        mainExplorerModelArrayList = new ArrayList<>();

        for (int i = 0; i < titleArray.length; i++) {
            Explorer explorer = new Explorer();
            explorer.setImage(imageArray.getResourceId(i, 1));
            explorer.setTitle(titleArray[i]);
            explorer.setSelect(false);
            explorer.setImageSelected(imageSelectArray.getResourceId(i, 1));

            listExplorer.add(explorer);
        }

        RecyclerView.LayoutManager layoutManager = null;
        layoutManager = new GridLayoutManager(mActivity, 4, GridLayoutManager
                .VERTICAL, false);

        RecyclerView.Adapter adapter = new ExplorerSelectAdaptor(mActivity, listExplorer);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(adapter);

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mActivity, MainActivity.class);
                mActivity.startActivity(i);
            }
        });

    }
}
