package com.baizhi.entity;

import java.util.List;

/**
 * Created by wd199 on 2017/6/16.
 */
public class UserDto<T> {
    private int total;
    private List<T> rows;

    public UserDto() {
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public UserDto(int total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
