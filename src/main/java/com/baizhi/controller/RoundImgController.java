package com.baizhi.controller;

import com.baizhi.entity.ImgDto;
import com.baizhi.entity.Page;
import com.baizhi.entity.RoundImg;
import com.baizhi.service.RoundImgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by wd199 on 2017/6/13.
 */
@Controller("roundImgController")
@RequestMapping("/roundImg")
public class RoundImgController {
    @Resource(name = "roundImgService")
    RoundImgService roundImgService;

    @RequestMapping("/queryOne")
    @ResponseBody
    public RoundImg queryOne(RoundImg roundImg){
        RoundImg roundImg1 = roundImgService.findRoundImg(roundImg);
        return roundImg1;
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public ImgDto queryAll(int page,int rows){
        Page page1 = new Page();
        page1.setPageIndex(page);
        page1.setPageSize(rows);
        List<RoundImg> roundImgs = roundImgService.findRoundImgs(page1);
        Integer total = roundImgService.findRows();
        ImgDto imgDto = new ImgDto();
        imgDto.setRows(roundImgs);
        imgDto.setTotal(total);
        return imgDto;
    }


    @RequestMapping("/add")
    @ResponseBody
    public int addRoundImage(HttpSession session,RoundImg roundImg, MultipartFile multipartFile) throws IOException {
        String originName=multipartFile.getOriginalFilename();
        String realPath=session.getServletContext().getRealPath("/uploading");
        String destFileName = realPath + "/" + originName;
        multipartFile.transferTo(new File(destFileName));



        roundImg.setSrc(originName);
        return roundImgService.addRoundImg(roundImg);
    }

    @RequestMapping("/update")
    @ResponseBody
    public int updateRoundImage(RoundImg roundImg){
        return roundImgService.modifyRoundImg(roundImg);
    }

}
