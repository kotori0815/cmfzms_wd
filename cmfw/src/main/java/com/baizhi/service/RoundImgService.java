package com.baizhi.service;

import com.baizhi.entity.Page;
import com.baizhi.entity.RoundImg;

import java.util.List;

/**
 * Created by wd199 on 2017/6/13.
 */
public interface RoundImgService {
    public int addRoundImg(RoundImg roundImg);
    public int modifyRoundImg(RoundImg roundImg);
    public RoundImg findRoundImg(RoundImg roundImg);
    public List<RoundImg> findRoundImgs(Page page);
    public Integer findRows();
}
