package com.baizhi.service.impl;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wd199 on 2017/6/12.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Resource(name = "menuDao")
    MenuDao menuDao;

    public List<Menu> findMenus() {
        List<Menu> menus = menuDao.selectMenus();
        return menus;
    }
}
