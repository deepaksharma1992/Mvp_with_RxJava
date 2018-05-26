package com.sharma.deepak.guardiansnews.bean.news_api;

import java.util.List;

/**
 * Created by deepak on 26-05-2018.
 */

public class ResponseJSONObject {
    private String status, userTier, orderBy;
    private int total, startIndex, pageSize, currentPage, pages;
    private List<NewsResults> results;

    public List<NewsResults> getResults() {
        return results;
    }

    public String getStatus() {
        return status;
    }

    public String getUserTier() {
        return userTier;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public int getTotal() {
        return total;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPages() {
        return pages;
    }
}



