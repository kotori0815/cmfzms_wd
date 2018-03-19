package com.baizhi;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Created by wd199 on 2017/6/20.
 */
public class Shiro2 {
    public static void main(String[] args) {

        //创建安全管理器工厂
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //创建安全管理器
        SecurityManager instance = iniSecurityManagerFactory.getInstance();
        //将安全管理器注入进安全工具
        SecurityUtils.setSecurityManager(instance);
        //获得安全工具中的主体
        Subject subject = SecurityUtils.getSubject();
        //调用主体中的认证方法认证信息
        new UsernamePasswordToken();

    }


}
