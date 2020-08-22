package com.hackathon.golo;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.golo.adaptor.ExplorerAdaptor;
import com.hackathon.golo.model.Explorer;
import com.hackathon.golo.model.MainExplorerModel;

import java.util.ArrayList;

public class SelectCategoryActivity extends AppCompatActivity {

    private TypedArray imageArray;
    private String[] titleArray;
    private ArrayList<MainExplorerModel> mainExplorerModelArrayList;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private Activity mActivity;
    private ArrayList<Explorer> listExplorer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_explorer);

        titleArray = getResources().getStringArray(R.array.menu_explorer_text);
        imageArray = getResources().obtainTypedArray(R.array.menu_explorer_image);
        mRecyclerView = findViewById(R.id.content_recyclerview);

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

            listExplorer.add(explorer);
        }

        RecyclerView.LayoutManager layoutManager = null;
        layoutManager = new GridLayoutManager(mActivity, 4, GridLayoutManager
                .VERTICAL, false);

        RecyclerView.Adapter adapter = new ExplorerAdaptor(mActivity, listExplorer);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(adapter);

    }
}
