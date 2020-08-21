package com.hackathon.golo.contract;

import com.hackathon.golo.model.Campaign;
import com.hackathon.golo.model.Promotion;
import com.hackathon.golo.model.RedeemRequest;

import java.util.ArrayList;

public interface PromotionContract {

    interface View {
        void showPromotionSuccess(ArrayList<Promotion> promotion);
        void showPromotionDetailSuccess(ArrayList<Promotion> promotion);
        void showRedeemSuccess(Campaign redeem);
        void showRedeemFail();
    }

    interface Presenter {
        void dataPromotion(ArrayList<Promotion> promotion);
        void dataPromotionDetail(ArrayList<Promotion> promotion);
        void dataRedeem(Campaign redeem);
        void dataRedeemError();
        void getPromotion();
        void getPromotionDetail();
        void redeem(RedeemRequest request);
    }

    interface Model {
        void getPromotion();
        void getPromotionDetail();
        void redeem(RedeemRequest request);
    }
}
