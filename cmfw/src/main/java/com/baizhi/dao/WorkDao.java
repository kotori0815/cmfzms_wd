package com.baizhi.dao;

import com.baizhi.entity.Page;
import com.baizhi.entity.Work;

import java.util.List;

/**
 * Created by wd199 on 2017/6/16.
 */
public interface WorkDao {
    public Work selectWork(int workId);
    public List<Work> selectWorks(Page page);
    public int updateWork(Work work);
    public int selectTotal();
}
