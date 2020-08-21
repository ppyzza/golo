package com.hackathon.golo.presenters

import com.hackathon.golo.contract.ExplorerContract
import com.hackathon.golo.contract.SearchExploreContract
import com.hackathon.golo.model.Offers
import com.hackathon.golo.models.ExplorerModels
import com.hackathon.golo.models.SearchExplorerModels
import java.util.ArrayList

class SearchExplorerPresenter (private val mView: SearchExploreContract.View) : SearchExploreContract.Presenter {

    private val mModel: SearchExploreContract.Model

    init {
        mModel = SearchExplorerModels(this)
    }

    override fun getSearchContents() {
        mModel.getOffers()
    }

    override fun dataSearch(offers: ArrayList<Offers>?) {
        mView.showSearchContent(offers)
    }
}