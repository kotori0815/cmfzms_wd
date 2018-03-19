package com.baizhi;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */

public class AppTest {

    static ClassPathXmlApplicationContext ctos;
    static Object bean;
    static UserDao userDao;
    @Before
    public void before(){
        ctos=new ClassPathXmlApplicationContext("classpath:spring.xml");
        bean=ctos.getBean("userDao");
        userDao=(UserDao) bean;
    }

    @Test
    public void test1(){
        System.out.println(userDao);
        User user = userDao.selectUser("pingzi");
        System.out.println(user);
    }
}
