package com.baizhi;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;


/**
 * Created by wd199 on 2017/6/20.
 */
public class Shiro1 {
    public static void main(String[] args) {
        Subject subject=null;
        try {
            //创建安全管理器工厂
            IniSecurityManagerFactory iniSecurityManagerFactory=new IniSecurityManagerFactory("classpath:shiro1.ini");
            //创建安全管理器
            SecurityManager instance = iniSecurityManagerFactory.getInstance();
            //将安全管理器注入安全工具中
            SecurityUtils.setSecurityManager(instance);
            //从安全工具中获取主体
            subject = SecurityUtils.getSubject();
            //调用主体中的认证方法完成认证 token中的参数代表用户输入的信息
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("wudi","wu81");

            subject.login(usernamePasswordToken);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("认证结果"+subject.isAuthenticated());
        }
    }
}
