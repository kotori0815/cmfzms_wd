package com.baizhi.entity;

/**
 * Created by wd199 on 2017/6/16.
 */
public class Work {
  private int workId;
  private String workName;
  private String type;
  private User user;

    @Override
    public String toString() {
        return "Work{" +
                "workId=" + workId +
                ", workName='" + workName + '\'' +
                ", type='" + type + '\'' +
                ", user=" + user +
                '}';
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Work() {
    }

    public Work(int workId, String workName, String type, User user) {
        this.workId = workId;
        this.workName = workName;
        this.type = type;
        this.user = user;
    }
}
