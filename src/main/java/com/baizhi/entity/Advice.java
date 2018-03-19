package com.baizhi.entity;

/**
 * Created by wd199 on 2017/6/18.
 */
public class Advice {
   private String advId;
   private String createName;
   private String createTime;
   private String content;
   private String action;



    @Override
    public String toString() {
        return "Advice{" +
                "advId='" + advId + '\'' +
                ", createName='" + createName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", content='" + content + '\'' +
                ", action='" + action + '\'' +
                '}';
    }

    public String getAdvId() {
        return advId;
    }

    public void setAdvId(String advId) {
        this.advId = advId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
