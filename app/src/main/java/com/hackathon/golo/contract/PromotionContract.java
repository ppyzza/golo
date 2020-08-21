package com.hackathon.golo.contract;

import com.hackathon.golo.model.Promotion;

import java.util.ArrayList;

public interface PromotionContract {

    interface View {
        void showPromotionSuccess(ArrayList<Promotion> promotion);
    }

    interface Presenter {
        void dataPromotion(ArrayList<Promotion> promotion);
        void getPromotion();
    }

    interface Model {
        void getPromotion();
    }
}
