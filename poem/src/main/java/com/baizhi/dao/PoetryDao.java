package com.baizhi.dao;

import com.baizhi.entity.Poetry;

import java.util.List;

/**
 * Created by wd199 on 2017/6/24.
 */
public interface PoetryDao {
    public List<Poetry> selectPoetry(Poetry poetry);
}
