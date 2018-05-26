package com.sharma.deepak.guardiansnews.model.news_module;

import android.util.Log;

import com.sharma.deepak.guardiansnews.bean.news_api.NewsResponse;
import com.sharma.deepak.guardiansnews.network.ApiClient;
import com.sharma.deepak.guardiansnews.network.ApiInterface;
import com.sharma.deepak.guardiansnews.presenter.news_module.NewsActivityPresenter;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by deepak on 26-05-2018.
 */

public class NewsActivityModel implements NewsActivityModelInteractor {
    private Disposable mDisposable;
    private NewsActivityPresenter mPresenterInteractor;
    private static final String TAG = NewsActivityModel.class.getSimpleName();

    public NewsActivityModel(NewsActivityPresenter presenterInteractor) {
        this.mPresenterInteractor = presenterInteractor;
    }

    /**
     * @author deepaks
     * @date 26 may 2018
     * @description method to call the news web API
     */
    @Override
    public void callNewsWebAPI() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Single<NewsResponse> newsResponseObservable = apiInterface.getNewsResponse();

        newsResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getNewsObserver());

    }

    /**
     * @return the single observer
     * @author deepaks
     * @date 26 may 2018
     * @description method to get the news observer
     */
    private SingleObserver<NewsResponse> getNewsObserver() {
        return new SingleObserver<NewsResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;
                Log.i(TAG, "Subscribed");
            }

            @Override
            public void onSuccess(NewsResponse newsResponse) {
                Log.i(TAG, "on Success");
                mPresenterInteractor.setAdapter(newsResponse.getResponse().getResults());
                mDisposable.dispose();
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "error occured");
            }
        };
    }
}
