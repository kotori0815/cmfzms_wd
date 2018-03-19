package com.baizhi.entity;

/**
 * Created by wd199 on 2017/6/14.
 */
public class Lama {
    private String lamaId;
    private String lamaName;
    private String img;

    @Override
    public String toString() {
        return "Lama{" +
                "lamaId='" + lamaId + '\'' +
                ", lamaName='" + lamaName + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public String getLamaId() {
        return lamaId;
    }

    public void setLamaId(String lamaId) {
        this.lamaId = lamaId;
    }

    public String getLamaName() {
        return lamaName;
    }

    public void setLamaName(String lamaName) {
        this.lamaName = lamaName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Lama(String lamaId, String lamaName, String img) {
        this.lamaId = lamaId;
        this.lamaName = lamaName;
        this.img = img;
    }

    public Lama() {
    }
}
