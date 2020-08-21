package com.hackathon.golo.normalactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.hackathon.golo.R;
import com.hackathon.golo.contract.DetailExplorerContract;
import com.hackathon.golo.contract.ExplorerContract;
import com.hackathon.golo.model.placedetail.Location;
import com.hackathon.golo.model.placedetail.PlaceResponse;
import com.hackathon.golo.presenters.DetailExplorerPresenter;

public class ExplorerDetailActivity extends AppCompatActivity implements DetailExplorerContract.View {

    DetailExplorerPresenter mDetailExplorerPresenter;
    private ImageView ivBanner, ivThumb;
    private Activity mActivity;
    private TextView tvTitle, tvLocation, tvDetail;
    private Bundle mBundle;
    private String placeId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explorer_detail);

        mBundle = getIntent().getExtras();
        placeId = mBundle.getString("placeId" ,"");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mActivity = ExplorerDetailActivity.this;
        ivBanner = findViewById(R.id.iv_banner);
        ivThumb = findViewById(R.id.iv_trending_thumb);
        tvTitle = findViewById(R.id.tv_title);
        tvLocation = findViewById(R.id.tv_location);
        tvDetail = findViewById(R.id.tv_detail);

        mDetailExplorerPresenter = new DetailExplorerPresenter(this);
        mDetailExplorerPresenter.getPlaceDetail(placeId);

    }

    @Override
    public void showPlaceDetail(PlaceResponse placeResponse) {
        Glide.with(mActivity).load(placeResponse.getResult().getWebPictureUrls().get(0)).into(ivBanner);
        Glide.with(mActivity).load(placeResponse.getResult().getMobilePictureUrls().get(0)).into(ivThumb);
        tvTitle.setText(placeResponse.getResult().getPlaceName());
        tvDetail.setText(placeResponse.getResult().getPlaceInformation().getDetail());
        Location loc = placeResponse.getResult().getLocation();
        tvLocation.setText(loc.getAddress()+" "+loc.getSubDistrict()+" "+loc.getDistrict()+" "+loc.getProvince()+" "+loc.getPostcode());

    }
}
