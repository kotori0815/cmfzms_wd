package com.baizhi.dao;

import com.baizhi.entity.Poet;

import java.util.List;

/**
 * Created by wd199 on 2017/6/24.
 */
public interface PoetDao {

    public List<Poet> selectPoet(Poet poet);
}
