package com.baizhi.service;

import com.baizhi.entity.Admin;

/**
 * Created by wd199 on 2017/6/12.
 */
public interface AdminService {
      public   Admin findAdmin(Admin admin);
      public   int addAdmin(Admin admin);
}
