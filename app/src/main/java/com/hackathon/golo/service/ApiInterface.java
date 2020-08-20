package com.hackathon.golo.service;

import com.hackathon.golo.model.TravelMate;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("users/my-profile")
    Observable<List<TravelMate>> getTravelMates();

}
