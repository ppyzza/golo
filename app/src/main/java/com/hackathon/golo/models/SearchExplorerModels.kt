package com.hackathon.golo.models

import com.hackathon.golo.contract.ExplorerContract
import com.hackathon.golo.contract.SearchExploreContract
import com.hackathon.golo.service.ApiClient
import com.hackathon.golo.service.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchExplorerModels (private val mPresenter: SearchExploreContract.Presenter) : SearchExploreContract.Model {

    private var apiInterface: ApiInterface? = null
    private val mCompositeDisposable = CompositeDisposable()
    private var mApiClient: ApiClient? = null

    init {
        mApiClient = ApiClient()
    }

    override fun getOffers() {
        apiInterface = mApiClient!!.baseToken
        val observable = apiInterface!!.offers
        val d = observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe({ data ->
                    mPresenter.dataSearch(data)
                }, { error->
                    error.message
                })
        mCompositeDisposable.add(d)
    }

}