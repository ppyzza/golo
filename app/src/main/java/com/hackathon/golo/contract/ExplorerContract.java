package com.hackathon.golo.contract;

public interface ExplorerContract {

    interface View {
        void showTrendingPlaceSuccess();
    }

    interface Presenter {
        void getOffes();
        void getSuggest();
        void getTrendingPlace();
    }

    interface Model {
        void getTrendingPlace();
    }
}
