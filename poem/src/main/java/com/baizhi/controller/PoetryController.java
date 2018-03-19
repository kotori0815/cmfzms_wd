package com.baizhi.controller;

import com.baizhi.app.Index;
import com.baizhi.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by wd199 on 2017/6/25.
 */
@Controller("poetryController")
@RequestMapping("/poetry")
public class PoetryController {
    @Autowired
    private PoetryService service;

    @RequestMapping(value = "query", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String, Object> query(Integer page, String keyWord, String type) {
        System.out.println(type);
        Map<String, Object> map = Index.searchByHighLighter(page, 5, keyWord,type);
        return map;
    }
}
