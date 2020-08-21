package com.hackathon.golo.models

import com.hackathon.golo.contract.DetailExplorerContract
import com.hackathon.golo.contract.ExplorerContract
import com.hackathon.golo.contract.SearchExploreContract
import com.hackathon.golo.service.ApiClient
import com.hackathon.golo.service.ApiInterface
import com.hackathon.golo.service.TATInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailExplorerModels (private val mPresenter: DetailExplorerContract.Presenter) : DetailExplorerContract.Model {

    private var apiInterface: TATInterface? = null
    private val mCompositeDisposable = CompositeDisposable()
    private var mApiClient: ApiClient? = null

    init {
        mApiClient = ApiClient()
    }

    override fun getPlaceDetail(placeId: String) {
        apiInterface = mApiClient!!.basetatToken
        val observable = apiInterface!!.getPlaceDetail(placeId)
        val d = observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe({ data ->
                    mPresenter.dataPlaceDetail(data)
                }, { error->
                    error.message
                })
        mCompositeDisposable.add(d)
    }

}