package com.hackathon.golo.models

import com.hackathon.golo.contract.PromotionContract
import com.hackathon.golo.service.ApiClient
import com.hackathon.golo.service.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PromotionModels (private val mPresenter: PromotionContract.Presenter) : PromotionContract.Model {

    private var apiInterface: ApiInterface? = null
    private val mCompositeDisposable = CompositeDisposable()
    private var mApiClient: ApiClient? = null

    init {
        mApiClient = ApiClient()
    }

    override fun getPromotion() {
        apiInterface = mApiClient!!.promotionList
        val observable = apiInterface!!.promotion
        val d = observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe({ data ->
                    mPresenter.dataPromotion(data)
                }, { error->
                    error.message
                })
        mCompositeDisposable.add(d)

    }
}