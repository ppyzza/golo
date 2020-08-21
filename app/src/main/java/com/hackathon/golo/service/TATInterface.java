package com.hackathon.golo.service;

import com.hackathon.golo.model.TATPlace;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TATInterface {


    @GET("places/search")
    Observable<TATPlace> getSectionType(
            @Query("section") String section
    );
}
