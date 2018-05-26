package com.sharma.deepak.guardiansnews.presenter.news_module;

import com.sharma.deepak.guardiansnews.bean.news_api.NewsResults;
import com.sharma.deepak.guardiansnews.model.news_module.NewsActivityModel;
import com.sharma.deepak.guardiansnews.model.news_module.NewsActivityModelInteractor;
import com.sharma.deepak.guardiansnews.view.news_module.NewsActivityInteractor;

import java.util.List;

/**
 * Created by deepak on 26-05-2018.
 */

public class NewsActivityPresenter implements NewsActivityPresenterInteractor {
    private NewsActivityModelInteractor mModelInteractor;
    private NewsActivityInteractor mActivityInteractor;

    public NewsActivityPresenter(NewsActivityInteractor activityInteractor) {
        this.mActivityInteractor = activityInteractor;
        mModelInteractor = new NewsActivityModel(this);
    }

    /**
     * @author deepaks
     * @date 26 may 2018
     * @description method to open the news on the web browser
     */
    @Override
    public void callNewsWebAPi() {
        mActivityInteractor.startProgressBar();
        mModelInteractor.callNewsWebAPI();
    }

    /**
     * @param newsList the news list
     * @author deepaks
     * @date 26 may 2018
     * @description method to set the adapter for the news list
     */
    @Override
    public void setAdapter(List<NewsResults> newsList) {
        mActivityInteractor.setUpAdapter(newsList);
        mActivityInteractor.stopProgressBar();
    }
}
