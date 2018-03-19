package com.baizhi.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by wd199 on 2017/6/24.
 */
public class Poet {
    private Integer id;
    private String name;
    private Date createTime;
    private Date updateTime;
    private List<Poetry> poetryList;

    @Override
    public String toString() {
        return "PoetDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", poetryList=" + poetryList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Poetry> getPoetryList() {
        return poetryList;
    }

    public void setPoetryList(List<Poetry> poetryList) {
        this.poetryList = poetryList;
    }
}
