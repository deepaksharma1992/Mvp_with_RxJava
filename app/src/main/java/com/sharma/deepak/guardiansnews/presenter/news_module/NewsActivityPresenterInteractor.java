package com.sharma.deepak.guardiansnews.presenter.news_module;

import com.sharma.deepak.guardiansnews.bean.news_api.NewsResults;

import java.util.List;

/**
 * Created by deepak on 26-05-2018.
 */

public interface NewsActivityPresenterInteractor {
    /**
     * @author deepaks
     * @date 26 may 2018
     * @description method to open the news on the web browser
     */
    void callNewsWebAPi();

    /**
     * @param newsList the news list
     * @author deepaks
     * @date 26 may 2018
     * @description method to set the adapter for the news list
     */
    void setAdapter(List<NewsResults> newsList);
}
