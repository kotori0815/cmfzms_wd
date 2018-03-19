package com.baizhi.service;

import com.baizhi.entity.Advice;
import com.baizhi.entity.Page;

import java.util.List;

/**
 * Created by wd199 on 2017/6/18.
 */
public interface AdviceService {


    public int addAdvice(Advice advice);
    public List<Advice> findAdvices(Page page);
    public int findRows();

}
