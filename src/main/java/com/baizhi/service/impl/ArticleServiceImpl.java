package com.baizhi.service.impl;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import com.baizhi.entity.Page;
import com.baizhi.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by wd199 on 2017/6/15.
 */
@Service(value = "articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Resource(name = "articleDao")
    ArticleDao articleDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int findTotal() {
        return articleDao.selectTotal();
    }

    public int addArticle(Article article) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        article.setArticleId(uuid);
        return articleDao.insertArticle(article);
    }

    public int modifyArticle(Article article) {
        System.err.println(article);
        return articleDao.updateArticle(article);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Article findArticle(Article article) {
        return articleDao.selectArticle(article.getArticleId());
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Article> findArticles(Page page) {
        return articleDao.selectArticles(page);
    }
}
