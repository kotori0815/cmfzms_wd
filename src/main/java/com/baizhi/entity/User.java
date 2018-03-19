package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by wd199 on 2017/6/16.
 */
public class User {
   private String userId;
   private String realname;
   private String faName;
   private String email;
   private String mobile;
   private String password;
   private String sex;
   private String addr;
   private String img;
   private String sign;
   private String status;
   private String salt;
   private Integer count;
   @JSONField(format = "yyyy-MM-dd")
   private Date regTime;
   @JSONField(format = "yyyy-MM-dd")
   private Date lastlogTime;
   private Lama lama;


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", realname='" + realname + '\'' +
                ", faName='" + faName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", addr='" + addr + '\'' +
                ", img='" + img + '\'' +
                ", sign='" + sign + '\'' +
                ", status='" + status + '\'' +
                ", salt='" + salt + '\'' +
                ", count=" + count +
                ", regTime=" + regTime +
                ", lastlogTime=" + lastlogTime +
                ", lama=" + lama +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getFaName() {
        return faName;
    }

    public void setFaName(String faName) {
        this.faName = faName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getLastlogTime() {
        return lastlogTime;
    }

    public void setLastlogTime(Date lastlogTime) {
        this.lastlogTime = lastlogTime;
    }

    public Lama getLama() {
        return lama;
    }

    public void setLama(Lama lama) {
        this.lama = lama;
    }

    public User(String userId, String realname, String faName, String email, String mobile, String password, String sex, String addr, String img, String sign, String status, String salt, Date regTime, Date lastlogTime, Lama lama) {
        this.userId = userId;
        this.realname = realname;
        this.faName = faName;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.sex = sex;
        this.addr = addr;
        this.img = img;
        this.sign = sign;
        this.status = status;
        this.salt = salt;
        this.regTime = regTime;
        this.lastlogTime = lastlogTime;
        this.lama = lama;
    }

    public User() {
    }
}
