package com.baizhi.dao;

import com.baizhi.entity.Lama;
import com.baizhi.entity.Page;

import java.util.List;

/**
 * Created by wd199 on 2017/6/14.
 */
public interface LamaDao {
    public Lama selectLama(String lamaId);
    public List<Lama> selectLamas(Page page);
    public int insertLama(Lama lama);
    public int updateLama(Lama lama);
    public int selectTotal();
}
