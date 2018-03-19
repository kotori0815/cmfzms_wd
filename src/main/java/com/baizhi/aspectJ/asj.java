package com.baizhi.aspectJ;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Advice;
import com.baizhi.entity.RoundImg;
import com.baizhi.entity.User;
import com.baizhi.service.AdviceService;
import org.apache.ibatis.binding.MapperMethod;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * Created by wd199 on 2017/6/18.
 */
@Aspect
@Component
public class asj {

    @Resource(name = "adviceService")
    AdviceService adviceService;

    @Around(value = "execution(* com.baizhi.service.impl.RoundImgServiceImpl.addRoundImg(..))||execution(* com.baizhi.service.impl.RoundImgServiceImpl.modifyRoundImg(..))")
    public Object aroundAdvice(ProceedingJoinPoint point) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session = request.getSession();

        Admin admin = (Admin) session.getAttribute("admin");

        Advice advice = new Advice();

        String action="";
        //编号
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        advice.setAdvId(uuid);

        advice.setCreateName(admin.getAdminName());



        Object[] args = point.getArgs();

            Object arg = args[0];


        MethodSignature signature = (MethodSignature) point.getSignature();


        Method method = signature.getMethod();
        RoundImg roundImg= (RoundImg) arg;

        String content="";
        System.out.println(method.getName());
        if (method.getName().contains("add")) {

            content="用户"+admin.getAdminName()+",在"+new Date()+"插入了一条数据，为轮播图片信息,轮播图描述信息为"+roundImg.getImgDetail()+",状态为"+roundImg.getStatus()+",插入时间日期"+new Date();
            action="add";
        }else if (method.getName().contains("update")){
            content="用户"+admin.getAdminName()+",在"+new Date()+"修改了一条数据，为轮播图片信息,轮播图描述信息为"+roundImg.getImgDetail()+",状态为"+roundImg.getStatus()+",插入时间日期"+new Date();
            action="update";
        }

        advice.setContent(content);

        int i = adviceService.addAdvice(advice);

        Object proceed = point.proceed();
        System.err.println(proceed);
        return proceed;
    }


}
