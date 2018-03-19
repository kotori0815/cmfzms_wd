package com.baizhi.t;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.Md5Utils;
import com.baizhi.util.SaltUtils;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * Created by wd199 on 2017/6/12.
 */
public class AdminTe {
    @Test
    public void testDs(){
        ClassPathXmlApplicationContext ctos = new ClassPathXmlApplicationContext("spring.xml");
        Object bean = ctos.getBean("ds");
        System.err.println(bean);
    }

    @Test
    public void testSql(){
        ClassPathXmlApplicationContext ctos = new ClassPathXmlApplicationContext("spring.xml");
        Object bean = ctos.getBean("factory");
        System.err.println(bean);
    }

    @Test
    public void testQu(){
        ClassPathXmlApplicationContext ctos = new ClassPathXmlApplicationContext("spring.xml");
        Object bean = ctos.getBean("adminDao");
        AdminDao adminDao= (AdminDao) bean;
        Admin admin = adminDao.selectAdmin("bigdobee");
        System.err.println(admin);
    }

    @Test
    public void testMd5(){
        String salt = SaltUtils.getSalt(6);
        String qwer123456 = Md5Utils.generateMD5Code("qwer"+"123456");
        System.err.println(qwer123456);
    }

    @Test
    public void testFind(){
        ClassPathXmlApplicationContext ctos = new ClassPathXmlApplicationContext("spring.xml");
        Object bean = ctos.getBean("adminDao");
        AdminDao adminDao= (AdminDao) bean;
        Admin admin = new Admin();
        admin.setAdminName("bigdobee");
        admin.setPassword("qwer");
        Admin admin1 = adminDao.selectAdmin(admin.getAdminName());
        String salt = admin1.getSalt();

        String password=Md5Utils.generateMD5Code(admin.getPassword()+admin1.getSalt());
        System.err.println(password);

    }

    @Test
    public void testSer(){
        ClassPathXmlApplicationContext ctos = new ClassPathXmlApplicationContext("spring.xml");
        Object bean = ctos.getBean("adminService");
        AdminService adminService= (AdminService) bean;
        Admin admin = new Admin();
        admin.setAdminName("bigdobee");
        admin.setPassword("qwer");
        Admin admin1 = adminService.findAdmin(admin);
        System.err.println(admin1);
    }


}
