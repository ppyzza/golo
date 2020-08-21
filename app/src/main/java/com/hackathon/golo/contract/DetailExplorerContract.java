package com.hackathon.golo.contract;

import com.hackathon.golo.model.placedetail.PlaceResponse;

public interface DetailExplorerContract {

    interface View {
        void showPlaceDetail(PlaceResponse placeResponse);
        void show404Notfound();
    }

    interface Presenter {
        void getPlaceDetail(String placeId);
        void dataPlaceDetail(PlaceResponse placeResponse);
        void show404Notfound();
    }

    interface Model {
        void getPlaceDetail(String placeId);
    }
}
