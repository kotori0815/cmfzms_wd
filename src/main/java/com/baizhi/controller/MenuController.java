package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wd199 on 2017/6/12.
 */
@Controller("menuController")
@RequestMapping("/menu")
public class MenuController {
    @Resource(name = "menuService")
    MenuService menuService;

    @RequestMapping("/queryMenus")
    @ResponseBody
    public Menu[] queryMenus(){
        List<Menu> menuList = menuService.findMenus();
        Menu[] menus = new Menu[menuList.size()];
        for (int i=0;i<menuList.size();i++){
            menus[i]=menuList.get(i);
        }
        return menus;
    }


}
