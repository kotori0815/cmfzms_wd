package com.baizhi.service.impl;

import com.baizhi.dao.PoetryDao;
import com.baizhi.entity.Poetry;
import com.baizhi.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wd199 on 2017/6/24.
 */
@Service("poetryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PoetryServiceImpl implements PoetryService {

    @Autowired
    private PoetryDao dao;

    public Poetry queryOne(Integer id) {
        Poetry poetry = new Poetry();
        poetry.setId(id);
        List<Poetry> poetries = dao.selectPoetry(poetry);
        if (poetries != null && poetries.size() == 1)
            return poetries.get(0);
        return null;
    }

    public List<Poetry> queryAll() {
        return dao.selectPoetry(new Poetry());
    }
}
