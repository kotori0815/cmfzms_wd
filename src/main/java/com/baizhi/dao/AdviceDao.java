package com.baizhi.dao;

import com.baizhi.entity.Advice;
import com.baizhi.entity.Page;

import java.util.List;

/**
 * Created by wd199 on 2017/6/18.
 */
public interface AdviceDao {
    public List<Advice> selectAdvices(Page page);
    public int insertAdvice(Advice advice);
    public int selectTotal();
}
