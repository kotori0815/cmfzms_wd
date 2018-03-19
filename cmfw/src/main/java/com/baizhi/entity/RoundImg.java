package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by wd199 on 2017/6/13.
 */
public class RoundImg {
    private String imgId;
    private  String imgDetail;
    private String src;
    private String status;
    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;
    @JSONField(format = "yyyy-MM-dd")
    private Date updateTime;


    public RoundImg(String imgId, String imgDetail, String src, String status, Date createTime, Date updateTime) {
        this.imgId = imgId;
        this.imgDetail = imgDetail;
        this.src = src;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "RoundImg{" +
                "imgId='" + imgId + '\'' +
                ", imgDetail='" + imgDetail + '\'' +
                ", src='" + src + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImgDetail() {
        return imgDetail;
    }

    public void setImgDetail(String imgDetail) {
        this.imgDetail = imgDetail;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public RoundImg() {
    }
}
