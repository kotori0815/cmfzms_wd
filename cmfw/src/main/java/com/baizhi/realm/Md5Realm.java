package com.baizhi.realm;

import com.baizhi.dao.AdminDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

/**
 * Created by wd199 on 2017/6/20.
 */
@Component("md5Realm")
public class Md5Realm extends AuthorizingRealm{

    @Resource(name = "adminDao")
    private AdminDao adminDao;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }


    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username= (String) token.getPrincipal();
        System.out.println("访问了自定义的realm");
        Admin admin = adminDao.selectAdmin(username);
        if (admin!=null){
            return new SimpleAuthenticationInfo(admin.getAdminName(),admin.getPassword(),ByteSource.Util.bytes(admin.getSalt()),UUID.randomUUID().toString());
        }
        return null;
    }
}
