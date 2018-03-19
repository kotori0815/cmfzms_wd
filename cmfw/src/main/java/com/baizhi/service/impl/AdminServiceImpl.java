package com.baizhi.service.impl;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.Md5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by wd199 on 2017/6/12.
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
    @Resource(name="adminDao")
    AdminDao adminDao;


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin findAdmin(Admin admin) {
        Admin admin1 = adminDao.selectAdmin(admin.getAdminName());
        if (admin1!=null){
            String password= Md5Utils.generateMD5Code(admin.getPassword()+admin1.getSalt());
            if (password.equals(admin1.getPassword())){
                System.err.println(admin1);
                return admin1;
            }
        }
        return null;
    }

    public int addAdmin(Admin admin) {

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return 0;
    }
}
