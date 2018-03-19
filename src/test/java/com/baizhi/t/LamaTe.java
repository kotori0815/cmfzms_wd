package com.baizhi.t;

import com.baizhi.dao.LamaDao;
import com.baizhi.dao.RoundImgDao;
import com.baizhi.entity.Lama;
import com.baizhi.entity.Page;
import com.baizhi.entity.RoundImg;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by wd199 on 2017/6/13.
 */
public class LamaTe {

    static ClassPathXmlApplicationContext ctos;
    static Object bean;
    static LamaDao lamaDao;
    @Before
    public void before(){
        ctos = new ClassPathXmlApplicationContext("spring.xml");
        bean= ctos.getBean("lamaDao");
        lamaDao= (LamaDao) bean;
        System.err.println(lamaDao);
    }



    @Test
    public void testSelect(){
        List<Lama> lamas = lamaDao.selectLamas(new Page());
        System.err.println(lamas);

    }

    @Test
    public void testSelects(){
        List<Lama> roundImgs = lamaDao.selectLamas(new Page());
        for (Lama ri:roundImgs) {
            System.err.println(ri);
        }
    }


}
