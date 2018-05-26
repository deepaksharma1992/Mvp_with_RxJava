package com.sharma.deepak.guardiansnews.network;

import com.sharma.deepak.guardiansnews.bean.news_api.NewsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by deepak on 26-05-2018.
 */

public interface ApiInterface {

    @GET("search?order-by=newest&show-tags=contributor&page-size=15&q=politics&api-key=test")
    Single<NewsResponse> getNewsResponse();

}
