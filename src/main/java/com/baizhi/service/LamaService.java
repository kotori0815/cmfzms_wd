package com.baizhi.service;

import com.baizhi.entity.Lama;
import com.baizhi.entity.Page;

import java.util.List;

/**
 * Created by wd199 on 2017/6/14.
 */
public interface LamaService {
    public Lama findLama(Lama lama);
    public List<Lama> findLamas(Page page);
    public int addLama(Lama lama);
    public int modifyLama(Lama lama);
    public int findRows();
}
