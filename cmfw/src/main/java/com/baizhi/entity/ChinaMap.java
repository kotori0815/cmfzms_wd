package com.baizhi.entity;

/**
 * Created by wd199 on 2017/6/19.
 */
public class ChinaMap {
    private String name;
    private Integer value;


    @Override
    public String toString() {
        return "ChinaMap{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public ChinaMap() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
