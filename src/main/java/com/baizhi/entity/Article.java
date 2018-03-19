package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by wd199 on 2017/6/15.
 */
public class Article {
    private String articleId;
    private String title;
    @JSONField(format = "yyyy-MM-dd")
    private Date publishTime;
    private String context;
    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;
    private Lama lama;
    private String status;


    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", title='" + title + '\'' +
                ", publishTime=" + publishTime +
                ", context='" + context + '\'' +
                ", createTime=" + createTime +
                ", lama=" + lama +
                ", status='" + status + '\'' +
                '}';
    }

    public Article(String articleId, String title, Date publishTime, String context, Date createTime, Lama lama, String status) {
        this.articleId = articleId;
        this.title = title;
        this.publishTime = publishTime;
        this.context = context;
        this.createTime = createTime;
        this.lama = lama;
        this.status = status;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }



    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Lama getLama() {
        return lama;
    }

    public void setLama(Lama lama) {
        this.lama = lama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Article() {
    }
}
