package com.baizhi.entity;

import java.util.List;

/**
 * Created by wd199 on 2017/6/14.
 */
public class LamaDto {
    private Integer total;
    private List<Lama> rows;

    @Override
    public String toString() {
        return "LamaDto{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Lama> getRows() {
        return rows;
    }

    public void setRows(List<Lama> rows) {
        this.rows = rows;
    }

    public LamaDto(Integer total, List<Lama> rows) {
        this.total = total;
        this.rows = rows;
    }

    public LamaDto(){
    }
}
