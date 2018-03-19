package com.baizhi;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;

/**
 * Created by wd199 on 2017/6/20.
 */
public class CustomRealm extends AuthenticatingRealm{


    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) token;
        System.out.println("invoke this method");
        if ("wudi".equals(usernamePasswordToken.getUsername())){
            return new SimpleAuthenticationInfo("pingzi","bigdobee","aa");
        }

        return null;
    }
}
