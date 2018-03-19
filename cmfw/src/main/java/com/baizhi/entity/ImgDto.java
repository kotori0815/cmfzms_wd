package com.baizhi.entity;

import java.util.List;

/**
 * Created by wd199 on 2017/6/13.
 */
public class ImgDto {
   private Integer total;
    private List<RoundImg> rows;


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<RoundImg> getRows() {
        return rows;
    }

    public void setRows(List<RoundImg> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "ImgDto{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public ImgDto() {
    }

    public ImgDto(Integer total, List<RoundImg> rows) {
        this.total = total;
        this.rows = rows;
    }
}
