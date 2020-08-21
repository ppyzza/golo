package com.hackathon.golo.service;

import com.hackathon.golo.model.TATPlace;
import com.hackathon.golo.model.placedetail.PlaceResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TATInterface {


    @GET("places/search")
    Observable<TATPlace> getSectionType(
            @Query("section") String section
    );

    @GET("tatapi/v5/attraction/{placeId}")
    Observable<PlaceResponse> getPlaceDetail(
            @Path("placeId") String placeId
    );
}
