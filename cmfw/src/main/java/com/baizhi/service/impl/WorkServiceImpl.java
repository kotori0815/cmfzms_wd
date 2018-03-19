package com.baizhi.service.impl;

import com.baizhi.dao.WorkDao;
import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import com.baizhi.entity.Work;
import com.baizhi.service.WorkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wd199 on 2017/6/16.
 */
@Service(value = "workService")
@Transactional
public class WorkServiceImpl implements WorkService{
    @Resource(name = "workDao")
    WorkDao workDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Work findWork(Work work) {
        return workDao.selectWork(work.getWorkId());
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Work> findWorks(Page page) {
        return workDao.selectWorks(page);
    }

    public int modifyWork(Work work) {
        return workDao.updateWork(work);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int findTotal() {
        return workDao.selectTotal();
    }
}
