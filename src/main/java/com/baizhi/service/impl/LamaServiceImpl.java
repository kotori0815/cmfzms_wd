package com.baizhi.service.impl;

import com.baizhi.dao.LamaDao;
import com.baizhi.entity.Lama;
import com.baizhi.entity.Page;
import com.baizhi.service.LamaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by wd199 on 2017/6/14.
 */
@Service("lamaService")
@Transactional
public class LamaServiceImpl implements LamaService {
    @Resource(name="lamaDao")
    LamaDao lamaDao;


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Lama findLama(Lama lama) {
        return lamaDao.selectLama(lama.getLamaId());
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Lama> findLamas(Page page) {
        return lamaDao.selectLamas(page);
    }

    public int addLama(Lama lama) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        lama.setLamaId(uuid);
        return lamaDao.insertLama(lama);
    }

    public int modifyLama(Lama lama) {
        return lamaDao.updateLama(lama);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int findRows() {
        return lamaDao.selectTotal();
    }
}
