package com.baizhi.dao;

import com.baizhi.entity.Admin;

/**
 * Created by wd199 on 2017/6/12.
 */
public interface AdminDao {
    public int insertAdmin(Admin admin);
    public int deleteAdmin(String adminId);
    public int updateAdmin(Admin admin);
    public Admin selectAdmin(String adminName);
}
