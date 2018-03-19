package com.baizhi.controller;

import com.baizhi.entity.Page;
import com.baizhi.entity.UserDto;
import com.baizhi.entity.Work;
import com.baizhi.service.WorkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wd199 on 2017/6/16.
 */
@Controller(value = "workController")
@RequestMapping("/work")
public class WorkController {
    @Resource(name = "workService")
    WorkService workService;

    @RequestMapping("/queryWork")
    @ResponseBody
    public Work queryWork(Work work){
        return workService.findWork(work);
    }

    @RequestMapping("/queryWorks")
    @ResponseBody
    public UserDto<Work> queryWorks(int page,int rows){
        Page page1 = new Page();
        page1.setPageIndex(page);
        page1.setPageSize(rows);
        List<Work> works = workService.findWorks(page1);
        UserDto<Work> dto = new UserDto<Work>();
        int total = workService.findTotal();
        dto.setRows(works);
        dto.setTotal(total);
        return dto;
    }

    @RequestMapping("/updateWork")
    @ResponseBody
    public int updateWork(Work work){
        return workService.modifyWork(work);
    }
}
