package com.baizhi.entity;

import java.util.List;

/**
 * Created by wd199 on 2017/6/12.
 */
public class Menu {
    private String menuId;
    private String title;
    private String path;
    private String iconname;
    private List<Menu> menus;
    private Menu parent;


    @Override
    public String toString() {
        return "Menu{" +
                "menuId='" + menuId + '\'' +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", iconname='" + iconname + '\'' +
                ", menus=" + menus +
                ", parent=" + parent +
                '}';
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIconname() {
        return iconname;
    }

    public void setIconname(String iconname) {
        this.iconname = iconname;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public Menu() {
    }

    public Menu(String menuId, String title, String path, String iconname, Menu parent) {
        this.menuId = menuId;
        this.title = title;
        this.path = path;
        this.iconname = iconname;
        this.parent = parent;
    }
}
