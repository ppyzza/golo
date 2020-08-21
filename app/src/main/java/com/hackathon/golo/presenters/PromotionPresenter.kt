package com.hackathon.golo.presenters

import com.hackathon.golo.contract.PromotionContract
import com.hackathon.golo.model.Promotion
import com.hackathon.golo.models.PromotionModels
import java.util.*

class PromotionPresenter(private val mView: PromotionContract.View) : PromotionContract.Presenter {


    private val mModel: PromotionContract.Model

    init {
        mModel = PromotionModels(this)
    }

    override fun getPromotion() {
        mModel.getPromotion()
    }

    override fun getPromotionDetail() {
        mModel.getPromotionDetail()
    }

    override fun dataPromotion(promotion: ArrayList<Promotion>?) {
        mView.showPromotionSuccess(promotion)
    }

    override fun dataPromotionDetail(promotion: ArrayList<Promotion>?) {
        mView.showPromotionDetailSuccess(promotion)
    }
}