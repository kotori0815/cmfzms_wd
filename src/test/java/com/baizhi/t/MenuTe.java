package com.baizhi.t;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by wd199 on 2017/6/12.
 */
public class MenuTe {
    @Test
    public void testmenu(){
        ClassPathXmlApplicationContext ctos = new ClassPathXmlApplicationContext("spring.xml");
        Object bean = ctos.getBean("menuDao");
        System.err.println(bean);
    }

    @Test
    public void testAdd(){
        ClassPathXmlApplicationContext ctos = new ClassPathXmlApplicationContext("spring.xml");
        Object bean = ctos.getBean("menuDao");
        MenuDao menuDao= (MenuDao) bean;
        menuDao.insertMenu( new Menu("60efe04d1a8b42009fa525b4e05ff9cc",null,null,null,new Menu("3e86e7d89ea24bfb9ef337b699f0995f",null,null,null,null)));
        menuDao.insertMenu( new Menu("4e9122b0575341d2aa258c6cd42c3836",null,null,null,new Menu("44d899ab2927445b9b78a6670623d21f",null,null,null,null)));
        menuDao.insertMenu( new Menu("408ff638941846f382362414e069c087",null,null,null,new Menu("d02f3b9a3cbe4be58a93935949925c0b",null,null,null,null)));
        menuDao.insertMenu( new Menu("a6d6fe9e27164365903678e988517b27",null,null,null,new Menu("c8bad5892ee94647ba00ef923727c75e",null,null,null,null)));
        menuDao.insertMenu( new Menu("88b0473507734777bcbf0a440ec1d158",null,null,null,new Menu("f9b996ceb7f3475c9281f72b5feed296",null,null,null,null)));
        menuDao.insertMenu( new Menu("fb334c21b1c345b0b4cc0842f478766e",null,null,null,new Menu("8c84e502321d4f84bfc1f740c510d4ca",null,null,null,null)));
        menuDao.insertMenu( new Menu("eaf129db4cf94545a43ed624a5c7e69e",null,null,null,new Menu("b33a6ad0971744a48bbed198601c359f",null,null,null,null)));
        menuDao.insertMenu( new Menu("9fc090bd1ab1403494fb027d5fff9e9f",null,null,null,new Menu("7eb11ddb979f46eea99c028d8e8442aa",null,null,null,null)));
        menuDao.insertMenu( new Menu("5a2483fbe6364f72908a781938e12830",null,null,null,new Menu("3e86e7d89ea24bfb9ef337b699f0995f",null,null,null,null)));
        menuDao.insertMenu( new Menu("904b156ed9e147b28070724d757630b4",null,null,null,new Menu("44d899ab2927445b9b78a6670623d21f",null,null,null,null)));
        menuDao.insertMenu( new Menu("fc5876ac025d4b5496ff0202efc40804",null,null,null,new Menu("d02f3b9a3cbe4be58a93935949925c0b",null,null,null,null)));
        menuDao.insertMenu( new Menu("ec5484521427403eb4a1d6ec7973f278",null,null,null,new Menu("c8bad5892ee94647ba00ef923727c75e",null,null,null,null)));
        menuDao.insertMenu( new Menu("65b4db151dc64b7e9e9c8ea04066f05b",null,null,null,new Menu("f9b996ceb7f3475c9281f72b5feed296",null,null,null,null)));
        menuDao.insertMenu( new Menu("cd79da0d4a6c4415beb838735dcb6eda",null,null,null,new Menu("8c84e502321d4f84bfc1f740c510d4ca",null,null,null,null)));
        menuDao.insertMenu( new Menu("5871ecd464da4fe5aefd559164963624",null,null,null,new Menu("b33a6ad0971744a48bbed198601c359f",null,null,null,null)));
        menuDao.insertMenu( new Menu("1b7b5c9b68cb4c04a05ec63756749c4f",null,null,null,new Menu("7eb11ddb979f46eea99c028d8e8442aa",null,null,null,null)));



    }

    @Test
    public void createUUID(){
        for (int i=0;i<1;i++){
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            System.err.println(uuid);
        }
    }

    @Test
    public void testSelect(){
        ClassPathXmlApplicationContext ctos = new ClassPathXmlApplicationContext("spring.xml");
        Object bean = ctos.getBean("menuDao");
        MenuDao menuDao= (MenuDao) bean;
        List<Menu> menus = menuDao.selectMenus();
        System.err.println(menus.size());
        for (Menu m:menus
             ) {
            System.err.println(m);
        }
    }
}
