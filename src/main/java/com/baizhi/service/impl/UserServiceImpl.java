package com.baizhi.service.impl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wd199 on 2017/6/16.
 */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    UserDao userDao;


    public int modifyUser(User user) {
        return userDao.updateUser(user);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User findUser(User user) {
        return userDao.selectUser(user.getUserId());
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> findUsers(Page page) {
        return userDao.selectUsers(page);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int findTotal() {
        return userDao.selectTotal();
    }

    public List<User> findUserByCondition(String[] values) {
        String condition="";
        for (int i = 0; i < values.length; i++) {
            if (i==values.length-1) condition+=values[i];
            else condition+=values[i]+",";
        }
        return userDao.findUserByCondition(condition);
    }

    public int importUser(List<User> users) {
        return userDao.insertUsers(users);



    }

    public List<User> queryUserByMan() {


        return userDao.selectManUser();
    }

    public List<User> queryUserByWoman() {
        return userDao.selectWomanUser();
    }


}
