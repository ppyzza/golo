package com.hackathon.golo.service;

import com.hackathon.golo.model.Promotion;
import com.hackathon.golo.model.TravelMate;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/suggest_travel_mate")
    Observable<ArrayList<TravelMate>> getTravelMates();

    @GET("/promotion")
    Observable<ArrayList<Promotion>> getPromotion();

}
