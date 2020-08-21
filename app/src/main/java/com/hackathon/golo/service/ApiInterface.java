package com.hackathon.golo.service;

import com.hackathon.golo.model.Campaign;
import com.hackathon.golo.model.Offers;
import com.hackathon.golo.model.Promotion;
import com.hackathon.golo.model.RedeemRequest;
import com.hackathon.golo.model.TravelMate;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("/suggest_travel_mate")
    Observable<ArrayList<TravelMate>> getTravelMates();

    @GET("/offers_around")
    Observable<ArrayList<Offers>> getOffers();

    @GET("/promotion")
    Observable<ArrayList<Promotion>> getPromotion();

    @GET("/promotiondetail")
    Observable<ArrayList<Promotion>> getPromotionDetail();

    @POST("projects/5f2d16330991dd0001e90d7a/redeem/campaign-code")
    Observable<Campaign> redeem(@Body RedeemRequest redeemRequest);

}
