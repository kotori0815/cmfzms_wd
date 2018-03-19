package com.baizhi.service.impl;

import com.baizhi.dao.AdviceDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Advice;
import com.baizhi.entity.Page;
import com.baizhi.service.AdminService;
import com.baizhi.service.AdviceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wd199 on 2017/6/18.
 */
@Service(value = "adviceService")
@Transactional
public class AdviceServiceImpl implements AdviceService{
    @Resource(name = "adviceDao")
    AdviceDao adviceDao;

    public int addAdvice(Advice advice) {
        return adviceDao.insertAdvice(advice);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Advice> findAdvices(Page page) {
        return adviceDao.selectAdvices(page);
    }

    public int findRows() {
        return adviceDao.selectTotal();
    }
}
