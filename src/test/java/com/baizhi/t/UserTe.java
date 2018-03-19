package com.baizhi.t;

import com.baizhi.dao.ArticleDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Article;
import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.hssf.usermodel.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by wd199 on 2017/6/13.
 */
public class UserTe {

    static ClassPathXmlApplicationContext ctos;
    static Object bean;
    static UserDao userDao;
    @Before
    public void before(){
        ctos = new ClassPathXmlApplicationContext("spring.xml");
        bean= ctos.getBean("userDao");
        userDao= (UserDao) bean;
        System.err.println(userDao);
    }

    @Test
    public void testSel(){
        List<User> users = userDao.selectUsers(new Page(1, 100));
        System.err.println(users);
    }


    @Test
    public void testExport() {

        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
            UserService userService= (UserService) ctx.getBean("userService");
            List<User> users = userService.findUsers(new Page(1, 100));
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
            HSSFCellStyle cellStyle=hssfWorkbook.createCellStyle();

            HSSFDataFormat hssfDataFormat = hssfWorkbook.createDataFormat();
           short format = hssfDataFormat.getFormat("yyyy-MM-dd");


            HSSFFont hssfFont = hssfWorkbook.createFont();
            hssfFont.setFontName("微软雅黑");
            cellStyle.setFont(hssfFont);
            cellStyle.setDataFormat(format);

            HSSFSheet sheet = hssfWorkbook.createSheet("用户信息");
            sheet.setColumnWidth(6,4000);
            HSSFRow title = sheet.createRow(0);
            String[] field = new String[]{"用户编号", "真实姓名", "法号", "邮箱", "移动电话", "密码", "性别", "地址", "图片", "个性签名", "状态", "密码后缀", "注册时间", "最后一次登录时间", "跟随上师"};

            for (int i = 0; i < field.length; i++) {
                HSSFCell cell = title.createCell(i);
                cell.setCellValue(field[i]);
            }

            for (int i=1;i<=users.size();i++){
                HSSFRow row=sheet.createRow(i);
                row.createCell(0).setCellValue(users.get(i-1).getUserId());
                row.createCell(1).setCellValue(users.get(i-1).getRealname());
                row.createCell(2).setCellValue(users.get(i-1).getFaName());
                row.createCell(3).setCellValue(users.get(i-1).getEmail());
                row.createCell(4).setCellValue(users.get(i-1).getMobile());
                row.createCell(5).setCellValue(users.get(i-1).getPassword());
                row.createCell(6).setCellValue(users.get(i-1).getSex());
                row.createCell(7).setCellValue(users.get(i-1).getAddr());
                row.createCell(8).setCellValue(users.get(i-1).getImg());
                row.createCell(9).setCellValue(users.get(i-1).getSign());
                row.createCell(10).setCellValue(users.get(i-1).getStatus());
                row.createCell(11).setCellValue(users.get(i-1).getSalt());
                row.createCell(12).setCellValue(users.get(i-1).getRegTime());
                row.createCell(13).setCellValue(users.get(i-1).getLastlogTime());

                row.createCell(14).setCellValue(users.get(i-1).getLama().getLamaName());
                HSSFCell cell1 = row.createCell(6);
                HSSFCell cell2 = row.createCell(6);
                cell1.setCellStyle(cellStyle);
                cell2.setCellStyle(cellStyle);


            }

            FileOutputStream outputStream = new FileOutputStream("f://x.xls");
            hssfWorkbook.write(outputStream);
            hssfWorkbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testExport1() {

        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook();


            HSSFSheet sheet = hssfWorkbook.createSheet("用户信息");
            sheet.setColumnWidth(6,4000);
            HSSFRow title = sheet.createRow(0);
            String[] field = new String[]{"用户编号", "真实姓名", "法号", "邮箱", "移动电话", "密码"};

            for (int i = 0; i < field.length; i++) {
                HSSFCell cell = title.createCell(i);
                cell.setCellValue(field[i]);
            }



            FileOutputStream outputStream = new FileOutputStream("f://model.xls");
            hssfWorkbook.write(outputStream);
            hssfWorkbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void downLoad(){

    }

    @Test
    public void testSepte(){
        String[] fileds = new String[]{"userId", "realname", "faName", "email", "mobile", "password", "sex", "addr", "status", "salt", "regTime", "lastlogTime", "lamaId"};
        System.err.println(Arrays.toString(fileds));
    }


    @Test
    public void importXls() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("f://x.xls");
        HSSFWorkbook hssfWorkbook=new HSSFWorkbook(fileInputStream);
        HSSFSheet sheetAt = hssfWorkbook.getSheetAt(0);
        for (int i = 0; i < sheetAt.getLastRowNum(); i++) {
            HSSFRow row = sheetAt.getRow(i);
            System.err.println(row);
        }


    }

    @Test
    public void testCon(){
        List<User> userByCondition = userDao.findUserByCondition("userId,faName");
        System.err.println(userByCondition);

    }


    @Test
    public void testIsert(){
        User user = new User("2", "wei", "weiguoweimin", "wei@qq.", "123", "qwerrqwe", "m", "sq", "jqk", null, "up", "wei", null,null,null);
        User user1 = new User("3", "g", "pwengniao", "gjp@qq.", "123", "qwerrqwe", "m", "zk", "76", null, "up", "gjp", null,null,null);

     
        


        List<User> users=new ArrayList<User>();
        users.add(user);
        users.add(user1);
        int i = userDao.insertUsers(users);
        System.err.println(i);


    }


    @Test
    public void testUser(){
        List<User> users = userDao.selectManUser();
        List<User> users1 = userDao.selectWomanUser();
        System.err.println(users);
        System.err.println(users1);
    }

}
