package com.baizhi.dao;

import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wd199 on 2017/6/16.
 */
public interface UserDao {
    public int updateUser(User user);
    public User selectUser(String userId);
    public List<User> selectUsers(Page page);
    public int selectTotal();
    public List<User> findUserByCondition(@Param("condition") String condition);
    public int insertUsers(@Param("list") List<User> users);
    public List<User> selectManUser();
    public List<User> selectWomanUser();

}
