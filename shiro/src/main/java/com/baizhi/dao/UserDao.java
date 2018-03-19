package com.baizhi.dao;

import com.baizhi.entity.User;

/**
 * Created by wd199 on 2017/6/20.
 */
public interface UserDao {
    public User selectUser(String userName);
}
