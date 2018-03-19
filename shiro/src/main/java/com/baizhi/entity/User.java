package com.baizhi.entity;

/**
 * Created by wd199 on 2017/6/20.
 */
public class User {
    private Integer UserId;
    private String UserName;
    private String Password;
    private String salt;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
