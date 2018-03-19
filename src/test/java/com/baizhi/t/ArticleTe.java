package com.baizhi.t;

import com.baizhi.dao.ArticleDao;
import com.baizhi.dao.LamaDao;
import com.baizhi.entity.Article;
import com.baizhi.entity.Lama;
import com.baizhi.entity.Page;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by wd199 on 2017/6/13.
 */
public class ArticleTe {

    static ClassPathXmlApplicationContext ctos;
    static Object bean;
    static ArticleDao articleDao;
    @Before
    public void before(){
        ctos = new ClassPathXmlApplicationContext("spring.xml");
        bean= ctos.getBean("articleDao");
        articleDao= (ArticleDao) bean;
        System.err.println(articleDao);
    }


    @Test
    public void testsel(){
        Article article = articleDao.selectArticle("07520afefb5d4bd59bfcee568d3ba72e");
        System.err.println(article);
    }


}
