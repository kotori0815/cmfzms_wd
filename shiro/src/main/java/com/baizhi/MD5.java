package com.baizhi;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by wd199 on 2017/6/20.
 */
public class MD5 {

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("jqka","ele",512);
        System.out.println(md5Hash);
    }
}
