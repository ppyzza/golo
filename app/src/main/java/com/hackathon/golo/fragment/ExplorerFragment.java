package com.hackathon.golo.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.hackathon.golo.R;
import com.hackathon.golo.adaptor.MainExplorerAdaptor;
import com.hackathon.golo.constans.GoloConstants;
import com.hackathon.golo.model.Explorer;
import com.hackathon.golo.model.MainExplorerModel;
import com.hackathon.golo.model.SearchResult;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import org.th.tatsdk.ServiceRequestListener;
import org.th.tatsdk.TATSDKEnvironment;
import org.th.tatsdk.common.TATGeolocation;
import org.th.tatsdk.common.TATLanguage;
import org.th.tatsdk.search.TATLocation;
import org.th.tatsdk.search.TATPlaces;
import org.th.tatsdk.search.TATPlacesSearchParameter;
import org.th.tatsdk.search.TATPlacesSearchResult;
import org.th.tatsdk.search.TATPlacesSearchResultSet;

import java.util.ArrayList;
import java.util.List;

public class ExplorerFragment extends Fragment {

    private Activity mActivity;
    private Context mContext;
    private RecyclerView mRecyclerView;
    private ArrayList<Explorer> listExplorer;
    private TypedArray imageArray;
    private String[] titleArray;
    private ArrayList<MainExplorerModel> mainExplorerModelArrayList;
    private RecyclerView.Adapter mAdapter;
    private FusedLocationProviderClient mFusedLocationClient;
    private String apiKey = "GUjuQd31FzGhPuopjg3lM32arSZ1Ny(1YaEeMfeVbt2vtE3Xc777t4o4KOZObNLteprO3Q6xeaO3S4sxMOqdxQG=====2";
    private TATPlacesSearchParameter tatPlacesSearchParameter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_explorer, container, false);

        titleArray = getResources().getStringArray(R.array.menu_explorer_text);
        imageArray = getResources().obtainTypedArray(R.array.menu_explorer_image);

        mActivity = getActivity();
        TATSDKEnvironment.setEnvironment(apiKey, mActivity);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(mActivity);

        mRecyclerView = rootView.findViewById(R.id.content_recyclerview);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        listExplorer = new ArrayList<>();

        mainExplorerModelArrayList = new ArrayList<>();

        for (int i = 0; i < titleArray.length; i++) {
            Explorer explorer = new Explorer();
            explorer.setImage(imageArray.getResourceId(i, 0));
            explorer.setTitle(titleArray[i]);

            listExplorer.add(explorer);
        }

        MainExplorerModel mainExplorerModel = new MainExplorerModel();
        mainExplorerModel.setSeeMore(false);
        mainExplorerModel.setTitle(getString(R.string.explore_menu_1));
        mainExplorerModel.setViewType(GoloConstants.EXPLORER_VIEW);
        mainExplorerModel.setExplorerArrayList(listExplorer);

        mainExplorerModelArrayList.add(mainExplorerModel);

        mainExplorerModel = new MainExplorerModel();
        mainExplorerModel.setSeeMore(true);
        mainExplorerModel.setTitle(getString(R.string.explore_menu_2));
        mainExplorerModel.setViewType(GoloConstants.OFFER_VIEW);
        mainExplorerModel.setExplorerArrayList(listExplorer);

        mainExplorerModelArrayList.add(mainExplorerModel);

        mainExplorerModel = new MainExplorerModel();
        mainExplorerModel.setSeeMore(true);
        mainExplorerModel.setTitle(getString(R.string.explore_menu_3));
        mainExplorerModel.setViewType(GoloConstants.SUGGEST_VIEW);
        mainExplorerModel.setExplorerArrayList(listExplorer);

        mainExplorerModelArrayList.add(mainExplorerModel);


        getTrending();

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void getTrending() {
        Dexter.withContext(mActivity)
                .withPermissions(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                        Toast.makeText(mActivity, "why", Toast.LENGTH_SHORT).show();
                        mFusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {
                                getTAT(location.getLatitude(), location.getLongitude());
                            }
                        });
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {

                    }
                }).check();

//        mFusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
//            @Override
//            public void onSuccess(Location location) {
//                Toast.makeText(mActivity, "fff", Toast.LENGTH_SHORT).show();
//                getTAT(location.getLatitude(), location.getLongitude());
//            }
//        });

//        Dexter.withContext(mActivity)
//                .withPermissions(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
//                .withListener(new MultiplePermissionsListener() {
//                    @Override
//                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
//                        Toast.makeText(mActivity, "why", Toast.LENGTH_SHORT).show();
//                        mFusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
//                            @Override
//                            public void onSuccess(Location location) {
//                                     getTAT(location.getLatitude(), location.getLongitude());
//                            }
//                        });
//                    }
//
//                    @Override
//                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
//
//                    }
//                });
//



    }

    private void getTAT(double latitude, double longitude) {
        TATGeolocation tatLocation = new TATGeolocation(latitude, longitude);
        tatPlacesSearchParameter = new TATPlacesSearchParameter(tatLocation, TATLanguage.THAI);
        // tatPlacesSearchParameter.setNumberOfResult(10);
        //tatPlacesSearchParameter.setSearchRadius(1000);
        //tatPlacesSearchParameter.set
        TATPlaces.searchAsync(tatPlacesSearchParameter, new ServiceRequestListener<TATPlacesSearchResultSet>() {
            @Override
            public void onResponse(@Nullable TATPlacesSearchResultSet tatPlacesSearchResultSet) {
                ArrayList<SearchResult> searchResults = new ArrayList<>();

                for(int i=0; i<tatPlacesSearchResultSet.getResults().length; i++) {
                    TATPlacesSearchResult data = tatPlacesSearchResultSet.getResults()[i];
                    TATLocation location = data.getLocation();
                    searchResults.add(new SearchResult(
                            data.getId(),
                            data.getName(),
                            SearchResult.CREATOR.sortAddress(
                            location.getAddress(), location.getSubDistrict(), location.getDistrict(), location.getProvince()),
                            SearchResult.CREATOR.distanceToUnit(data.getDistance()),
                            data.getCategoryName(),
                            data.getThumbnailUrl())
                    );
                }

                MainExplorerModel mainExplorerModel;

                mainExplorerModel = new MainExplorerModel();
                mainExplorerModel.setSeeMore(true);
                mainExplorerModel.setTitle(getString(R.string.explore_menu_4));
                mainExplorerModel.setViewType(GoloConstants.TRENDING_VIEW);
                mainExplorerModel.setSearchResultArrayList(searchResults);

                mainExplorerModelArrayList.add(mainExplorerModel);

                setAdaptor();
            }

            @Override
            public void onError(@Nullable String s, int i) {
                Log.d("errro", ""+s+"code"+i);
            }
        });
    }

    private void setAdaptor() {
        mAdapter = new MainExplorerAdaptor(mActivity, mActivity, mainExplorerModelArrayList);

        mRecyclerView.setAdapter(mAdapter);
    }
}
