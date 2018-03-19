package com.baizhi.t;

import com.sun.org.apache.xml.internal.security.Init;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by wd199 on 2017/6/16.
 */
public class testTime {

    @Test
    public void createtime() {

        int[] ints = new int[12];
        Random random = new Random();
       for (int j=0;j<12;j++){
               ints[j] = random.nextInt(30);

       }


           String s = Arrays.toString(ints);
           System.err.println(s);

    }
}
