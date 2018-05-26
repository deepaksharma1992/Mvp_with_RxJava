package com.sharma.deepak.guardiansnews.view.news_module;

import com.sharma.deepak.guardiansnews.bean.news_api.NewsResults;

import java.util.List;

/**
 * Created by deepak on 26-05-2018.
 */

public interface NewsActivityInteractor {

    /**
     * @author deepaks
     * @date 26 may 2018
     * @description method to start the progress bar
     */
    void startProgressBar();
    /**
     * @author deepaks
     * @date 26 may 2018
     * @description method to stop the adapter
     */
    void stopProgressBar();

    /**
     * @author deepaks
     * @date 26 may 2018
     * @description method to set the adapter
     * @param newsList the news list
     */
    void setUpAdapter(List<NewsResults> newsList);
}
