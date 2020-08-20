package com.hackathon.golo.contract;

import com.hackathon.golo.model.TravelMate;

import java.util.List;

public interface ExplorerContract {

    interface View {
        void showTrendingPlaceSuccess(List<TravelMate> travelMateList);
    }

    interface Presenter {
        void getOffes();
        void getTravelMates();
        void getTrendingPlace();
        void dataTravelMates(List<TravelMate> travelMate);
    }

    interface Model {
        void getTrendingPlace();
        void getTravelMates();
    }
}
