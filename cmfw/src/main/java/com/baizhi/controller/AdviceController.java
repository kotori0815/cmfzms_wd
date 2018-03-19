package com.baizhi.controller;

import com.baizhi.entity.Advice;
import com.baizhi.entity.Page;
import com.baizhi.entity.UserDto;
import com.baizhi.service.AdviceService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wd199 on 2017/6/18.
 */
@Controller
@RequestMapping("/advice")
public class AdviceController {

    @Resource(name = "adviceService")
    AdviceService adviceService;

    @RequestMapping("/findAdvices")
    @ResponseBody
    public UserDto<Advice> findAdvices(int page,int rows){
        System.err.println(page+","+rows);
        UserDto<Advice> adviceDto = new UserDto<Advice>();
        Page page1 = new Page(page, rows);
        List<Advice> advices = adviceService.findAdvices(page1);
        int rows1 = adviceService.findRows();
        adviceDto.setTotal(rows1);
        adviceDto.setRows(advices);

        return adviceDto;


    }

}
