package com.baizhi.controller;

import com.baizhi.entity.Lama;
import com.baizhi.entity.LamaDto;
import com.baizhi.entity.Page;
import com.baizhi.service.LamaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by wd199 on 2017/6/14.
 */
@Controller("lamaController")
@RequestMapping("/lama")
public class LamaController {
    @Resource(name = "lamaService")
    LamaService lamaService;

    @RequestMapping("queryLamas")
    @ResponseBody
    public LamaDto queryLamas(int page,int rows){
        Page page1 = new Page();
        page1.setPageSize(rows);
        page1.setPageIndex(page);
        int total = lamaService.findRows();
        List<Lama> lamas = lamaService.findLamas(page1);
        LamaDto lamaDto = new LamaDto();
        lamaDto.setRows(lamas);
        lamaDto.setTotal(total);
        return lamaDto;
    }

    @RequestMapping("/queryLama")
    @ResponseBody
    public Lama queryLama(Lama lama){
        return lamaService.findLama(lama);
    }

    @RequestMapping("/addLama")
    @ResponseBody
    public int addLama(Lama lama, HttpSession session,  MultipartFile multipartFile) throws IOException {
        String originName=multipartFile.getOriginalFilename();
        String realPath=session.getServletContext().getRealPath("/uploadLama");
        String destFileName = realPath + "/" + originName;
        multipartFile.transferTo(new File(destFileName));
        lama.setImg(originName);
        return lamaService.addLama(lama);
    }

    @RequestMapping("/updateLama")
    @ResponseBody
    public int updateLama(Lama lama){
        return lamaService.modifyLama(lama);
    }


    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Lama> queryAll(){
        List<Lama> lamas = lamaService.findLamas(new Page(1, 100));
        return lamas;
    }
}
