package com.sharma.deepak.guardiansnews.bean.news_api;

import java.util.List;

/**
 * Created by deepak on 26-05-2018.
 */

public class NewsResults {
    private String id, type, sectionId, sectionName, webPublicationDate, webTitle, webUrl, apiUrl;
    private List<Tags> tags;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getSectionId() {
        return sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public List<Tags> getTags() {
        return tags;
    }
}
