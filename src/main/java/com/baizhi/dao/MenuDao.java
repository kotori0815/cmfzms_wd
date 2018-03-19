package com.baizhi.dao;

import com.baizhi.entity.Menu;

import java.util.List;

/**
 * Created by wd199 on 2017/6/12.
 */
public interface MenuDao {
    public int insertMenu(Menu menu);
    public List<Menu> selectMenus();
}
