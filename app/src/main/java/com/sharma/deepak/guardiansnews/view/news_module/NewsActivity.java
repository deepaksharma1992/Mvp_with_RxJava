package com.sharma.deepak.guardiansnews.view.news_module;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sharma.deepak.guardiansnews.R;
import com.sharma.deepak.guardiansnews.bean.news_api.NewsResults;
import com.sharma.deepak.guardiansnews.presenter.news_module.NewsActivityPresenter;
import com.sharma.deepak.guardiansnews.presenter.news_module.NewsActivityPresenterInteractor;
import com.sharma.deepak.guardiansnews.utility.NetworkUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity implements NewsActivityInteractor, ArticleAdapter.OnArticleClickListener {

    @BindView(R.id.rv_news_list)
    RecyclerView mRvNewsList;

    @BindView(R.id.pb_progress)
    ProgressBar mProgressBar;

    @BindView(R.id.tv_text_message)
    TextView mTvNoItem;

    private NewsActivityPresenterInteractor mPresenterInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setUpActivityComponents();
        callNewsWebAPI();
    }

    /**
     * @author deepaks
     * @date 26 may 2018
     * @description method to call the news web API
     */
    private void callNewsWebAPI() {
        if (NetworkUtil.isConnectedToNetwork(this))
            mPresenterInteractor.callNewsWebAPi();
        else {
            mProgressBar.setVisibility(View.INVISIBLE);
            mTvNoItem.setVisibility(View.VISIBLE);
            mTvNoItem.setText(getString(R.string.tv_no_connection));
        }
    }

    /**
     * @author deepaks
     * @date 26 may 2018
     * @description method to set up the activity components
     */
    private void setUpActivityComponents() {
        ButterKnife.bind(this);
        mPresenterInteractor = new NewsActivityPresenter(this);
    }

    /**
     * @author deepaks
     * @date 26 may 2018
     * @description method to show the progress bar
     */
    @Override
    public void startProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
        mRvNewsList.setVisibility(View.INVISIBLE);
        mTvNoItem.setVisibility(View.INVISIBLE);
    }

    /**
     * @author deepaks
     * @date 26 may 2018
     * @description method to stop the progress bar
     */
    @Override
    public void stopProgressBar() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mRvNewsList.setVisibility(View.VISIBLE);
    }

    /**
     * @param newsList the news list
     * @author deepaks
     * @date 26 may 2018
     * @description method to set the adapter
     */
    @Override
    public void setUpAdapter(List<NewsResults> newsList) {
        if (newsList.size() > 0) {
            mRvNewsList.setLayoutManager(new LinearLayoutManager(this));
            ArticleAdapter mAdapter = new ArticleAdapter(this, this, newsList);
            mRvNewsList.setAdapter(mAdapter);
        } else {
            mTvNoItem.setVisibility(View.VISIBLE);
            mTvNoItem.setText(R.string.no_item);
        }
    }

    /**
     * @param url the string url
     * @author deepaks
     * @date 26 may 2018
     * @description method to open the news on the web browser
     */
    @Override
    public void OnArticleClick(String url) {
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(webIntent);
    }
}
