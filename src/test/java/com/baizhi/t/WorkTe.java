package com.baizhi.t;

import com.baizhi.dao.UserDao;
import com.baizhi.dao.WorkDao;
import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import com.baizhi.entity.Work;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by wd199 on 2017/6/13.
 */
public class WorkTe {

    static ClassPathXmlApplicationContext ctos;
    static Object bean;
    static WorkDao workDao;
    @Before
    public void before(){
        ctos = new ClassPathXmlApplicationContext("spring.xml");
        bean= ctos.getBean("workDao");
        workDao= (WorkDao) bean;
        System.err.println(workDao);
    }

    @Test
    public void testSel(){
        List<Work> works = workDao.selectWorks(new Page(1, 100));
        System.err.println(works);
    }



}
