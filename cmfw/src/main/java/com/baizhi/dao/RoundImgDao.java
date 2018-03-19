package com.baizhi.dao;

import com.baizhi.entity.Page;
import com.baizhi.entity.RoundImg;

import java.util.List;

/**
 * Created by wd199 on 2017/6/13.
 */
public interface RoundImgDao {
    public int insertRoundImg(RoundImg roundImg);
    public int updateRoundImg(RoundImg roundImg);
    public RoundImg selectRoundImg(String imgId);
    public List<RoundImg> selectRoundImgs(Page page);
    public Integer selectRow();
}
