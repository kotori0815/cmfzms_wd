package com.baizhi.dao;

import com.baizhi.entity.Article;
import com.baizhi.entity.Page;

import java.util.List;

/**
 * Created by wd199 on 2017/6/15.
 */
public interface ArticleDao {
    public int selectTotal();
    public int insertArticle(Article article);
    public int updateArticle(Article article);
    public Article selectArticle(String articleId);
    public List<Article> selectArticles(Page page);
}
