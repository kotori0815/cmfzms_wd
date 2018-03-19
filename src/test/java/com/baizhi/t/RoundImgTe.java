package com.baizhi.t;

import com.baizhi.dao.RoundImgDao;
import com.baizhi.entity.Page;
import com.baizhi.entity.RoundImg;
import com.baizhi.service.RoundImgService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by wd199 on 2017/6/13.
 */
public class RoundImgTe {

    static ClassPathXmlApplicationContext ctos;
    static Object bean;
    static Object bean2;
    static RoundImgDao roundImgDao;
    static RoundImgService roundImgService;
    @Before
    public void before(){
        ctos = new ClassPathXmlApplicationContext("spring.xml");
        bean= ctos.getBean("roundImgDao");
        bean2= ctos.getBean("roundImgService");
        roundImgService= (RoundImgService) bean2;
        roundImgDao= (RoundImgDao) bean;
        System.err.println(roundImgService);
        System.err.println(roundImgDao);
    }

    @Test
    public void testBefore(){
        RoundImg roundImg = new RoundImg();
        roundImg.setImgId("123456");
        roundImg.setImgDetail("第一张图片");
        roundImg.setStatus("未选中");
        roundImg.setSrc("路径");
        int i = roundImgDao.insertRoundImg(roundImg);
        System.err.println(i);
    }

    @Test
    public void testSelect(){
        RoundImg roundImg = roundImgDao.selectRoundImg("123456");
        System.err.println(roundImg);
    }

    @Test
    public void testSelects(){
        List<RoundImg> roundImgs = roundImgDao.selectRoundImgs(new Page());
        for (RoundImg ri:roundImgs
             ) {
            System.err.println(ri);
        }
    }

    @Test
    public void testUpdate(){
        RoundImg roundImg = new RoundImg();
        roundImg.setImgId("123456");
        roundImg.setImgDetail("第一张图片");
        roundImg.setStatus("选中");
        roundImg.setSrc("路径已修改");
        int i = roundImgDao.updateRoundImg(roundImg);
        System.err.println(i);
    }



    @Test
    public void testAdv(){
        List<RoundImg> roundImgs = roundImgService.findRoundImgs(new Page());
        System.err.println(roundImgs);
    }
}
