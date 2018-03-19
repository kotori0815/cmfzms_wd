package com.baizhi.service;

import com.baizhi.entity.Article;
import com.baizhi.entity.Page;

import java.util.List;

/**
 * Created by wd199 on 2017/6/15.
 */
public interface ArticleService {
    public int findTotal();
    public int addArticle(Article article);
    public int modifyArticle(Article article);
    public Article findArticle(Article article);
    public List<Article> findArticles(Page page);
}
