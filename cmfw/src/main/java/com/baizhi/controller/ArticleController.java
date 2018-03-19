package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.entity.ArticleDto;
import com.baizhi.entity.Page;
    import com.baizhi.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wd199 on 2017/6/15.
 */
@Controller(value = "articleController")
@RequestMapping("/article")
public class ArticleController {
    @Resource(name = "articleService")
    ArticleService articleService;

    @RequestMapping("/addArticle")
    @ResponseBody
    public int addArticle(Article article){
        System.err.println(article);
        return articleService.addArticle(article);
    }

    @RequestMapping("/updateArticle")
    @ResponseBody
    public int updateArticle(Article article){
        System.err.println(article);
        return articleService.modifyArticle(article);
    }

    @RequestMapping("/queryArticle")
    @ResponseBody
    public Article queryArticle(Article article){
        return articleService.findArticle(article);
    }

    @RequestMapping("/queryArticles")
    @ResponseBody
    public ArticleDto queryArticles(int page,int rows){
        Page page1 = new Page();
        page1.setPageIndex(page);
        page1.setPageSize(rows);
        List<Article> articles = articleService.findArticles(page1);
        int total = articleService.findTotal();
        ArticleDto articleDto = new ArticleDto();
        articleDto.setRows(articles);
        articleDto.setTotal(total);
        return articleDto;
    }

    @RequestMapping(value = "/queryOne", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryOne(Article article){
        Article article1 = articleService.findArticle(article);
        String context = article1.getContext();
        return context;
    }

    @RequestMapping("/test")
    @ResponseBody
    public void test(Article article){
        System.err.println(article);
    }




}
