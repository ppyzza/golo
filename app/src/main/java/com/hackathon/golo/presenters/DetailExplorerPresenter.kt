package com.hackathon.golo.presenters

import com.hackathon.golo.contract.DetailExplorerContract
import com.hackathon.golo.model.placedetail.PlaceResponse
import com.hackathon.golo.models.DetailExplorerModels


class DetailExplorerPresenter (private val mView: DetailExplorerContract.View) : DetailExplorerContract.Presenter {

    private val mModel: DetailExplorerContract.Model

    init {
        mModel = DetailExplorerModels(this)
    }

    override fun dataPlaceDetail(placeResponse: PlaceResponse?) {
        mView.showPlaceDetail(placeResponse);
    }

    override fun getPlaceDetail(placeId: String?) {
        mModel.getPlaceDetail(placeId);
    }


}