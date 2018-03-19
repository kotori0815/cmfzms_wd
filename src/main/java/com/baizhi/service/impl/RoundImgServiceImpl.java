package com.baizhi.service.impl;

import com.baizhi.dao.RoundImgDao;
import com.baizhi.entity.Page;
import com.baizhi.entity.RoundImg;
import com.baizhi.service.RoundImgService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by wd199 on 2017/6/13.
 */
@Service(value = "roundImgService")
@Transactional
public class RoundImgServiceImpl implements RoundImgService {
    @Resource(name = "roundImgDao")
    RoundImgDao roundImgDao;

    public int addRoundImg(RoundImg roundImg) {

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        roundImg.setImgId(uuid);
        return roundImgDao.insertRoundImg(roundImg);
    }

    public int modifyRoundImg(RoundImg roundImg) {
        return roundImgDao.updateRoundImg(roundImg);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public RoundImg findRoundImg(RoundImg roundImg) {
        return roundImgDao.selectRoundImg(roundImg.getImgId());
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<RoundImg> findRoundImgs(Page page) {
        return roundImgDao.selectRoundImgs(page);
    }

    public Integer findRows() {
        return roundImgDao.selectRow();
    }
}
