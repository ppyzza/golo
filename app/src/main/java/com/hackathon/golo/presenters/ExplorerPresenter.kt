package com.hackathon.golo.presenters

import com.hackathon.golo.contract.ExplorerContract
import com.hackathon.golo.model.TravelMate
import com.hackathon.golo.models.ExplorerModels
import java.util.ArrayList

class ExplorerPresenter (private val mView: ExplorerContract.View) : ExplorerContract.Presenter {


    private val mModel: ExplorerContract.Model

    init {
        mModel = ExplorerModels(this)
    }

    override fun getTravelMates() {
        mModel.getTravelMates()
    }

    override fun getOffes() {

    }

    override fun getTrendingPlace() {

    }

    override fun dataTravelMates(travelMate: ArrayList<TravelMate>?) {
        mView.showTrendingPlaceSuccess(travelMate)
    }
}