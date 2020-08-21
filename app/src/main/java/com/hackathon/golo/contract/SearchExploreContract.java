package com.hackathon.golo.contract;

import com.hackathon.golo.model.Offers;
import com.hackathon.golo.model.TravelMate;

import java.util.ArrayList;

public interface SearchExploreContract {

    interface View {
        void showSearchContent(ArrayList<Offers> offersArrayList);
    }

    interface Presenter {
        void getSearchContents();
        void dataSearch(ArrayList<Offers> offers);
    }

    interface Model {
        void getOffers();
    }
}