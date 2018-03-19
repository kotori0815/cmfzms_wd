package com.baizhi.service;

import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import com.baizhi.entity.Work;

import java.util.List;

/**
 * Created by wd199 on 2017/6/16.
 */
public interface WorkService {
    public Work findWork(Work work);
    public List<Work> findWorks(Page page);
    public int modifyWork(Work work);
    public int findTotal();
}
