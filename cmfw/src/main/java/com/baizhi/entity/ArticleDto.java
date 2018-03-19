package com.baizhi.entity;

import java.util.List;

/**
 * Created by wd199 on 2017/6/15.
 */
public class ArticleDto {
    private List<Article> rows;
    private int total;

    @Override
    public String toString() {
        return "ArticleDto{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }

    public ArticleDto(List<Article> rows, int total) {
        this.rows = rows;
        this.total = total;
    }

    public ArticleDto() {
    }

    public List<Article> getRows() {
        return rows;
    }

    public void setRows(List<Article> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
