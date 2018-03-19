package com.baizhi;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wd199 on 2017/6/20.
 */

public class Md5Realm extends AuthenticatingRealm{



    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        ClassPathXmlApplicationContext ctos = new ClassPathXmlApplicationContext("classpath:spring.xml");
        UserDao userDao = (UserDao) ctos.getBean("userDao");
        System.out.println("MD5 method invoke");
        String username= (String) token.getPrincipal();
        System.err.println(username);
        User user = userDao.selectUser(username);
        System.err.println(user);
        if (user!=null){
            return  new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),"cc");
        }
        return null;
    }
}
