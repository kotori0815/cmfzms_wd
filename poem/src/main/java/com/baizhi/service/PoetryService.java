package com.baizhi.service;

import com.baizhi.entity.Poetry;

import java.util.List;

/**
 * Created by wd199 on 2017/6/24.
 */
public interface PoetryService {
    public Poetry queryOne(Integer id);

    public List<Poetry> queryAll();
}
