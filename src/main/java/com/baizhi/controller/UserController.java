package com.baizhi.controller;

import com.baizhi.entity.*;
import com.baizhi.service.UserService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

/**
 * Created by wd199 on 2017/6/16.
 */
@Controller(value = "userController")
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userService")
    UserService userService;

    @RequestMapping("/updateUser")
    @ResponseBody
    public int updateUser(User user) {

        return userService.modifyUser(user);
    }

    @RequestMapping("/queryUser")
    @ResponseBody
    public User queryUser(User user) {
        return userService.findUser(user);
    }

    @RequestMapping("/queryUsers")
    @ResponseBody
    public UserDto<User> queryUsers(int rows, int page) {
        Page page1 = new Page();
        page1.setPageSize(rows);
        page1.setPageIndex(page);
        List<User> users = userService.findUsers(page1);
        int total = userService.findTotal();
        UserDto<User> userUserDto = new UserDto<User>();
        userUserDto.setTotal(total);
        userUserDto.setRows(users);
        return userUserDto;
    }


    @RequestMapping("/queryTime")
    @ResponseBody
    public int[] queryTime() {
        int[] ints = new int[12];
        Random random = new Random();
        for (int j = 0; j < 12; j++) {
            ints[j] = random.nextInt(30);
        }
        String s = Arrays.toString(ints);
        System.err.println(s);
        return ints;
    }


    @RequestMapping("/downLoadall")
    @ResponseBody
    public void export(HttpServletResponse response) {


        try {


            List<User> users = userService.findUsers(new Page(1, 100));
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
            HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();

            HSSFDataFormat hssfDataFormat = hssfWorkbook.createDataFormat();
            short format = hssfDataFormat.getFormat("yyyy-MM-dd");


            HSSFFont hssfFont = hssfWorkbook.createFont();
            hssfFont.setFontName("微软雅黑");
            cellStyle.setFont(hssfFont);
            cellStyle.setDataFormat(format);

            HSSFSheet sheet = hssfWorkbook.createSheet("用户信息");
            sheet.setColumnWidth(6, 4000);
            HSSFRow title = sheet.createRow(0);
            String[] field = new String[]{"用户编号", "真实姓名", "法号", "邮箱", "移动电话", "密码", "性别", "地址", "图片", "个性签名", "状态", "密码后缀", "注册时间", "最后一次登录时间", "跟随上师"};

            for (int i = 0; i < field.length; i++) {
                HSSFCell cell = title.createCell(i);
                cell.setCellValue(field[i]);
            }

            for (int i = 1; i <= users.size(); i++) {
                HSSFRow row = sheet.createRow(i);
                row.createCell(0).setCellValue(users.get(i - 1).getUserId());
                row.createCell(1).setCellValue(users.get(i - 1).getRealname());
                row.createCell(2).setCellValue(users.get(i - 1).getFaName());
                row.createCell(3).setCellValue(users.get(i - 1).getEmail());
                row.createCell(4).setCellValue(users.get(i - 1).getMobile());
                row.createCell(5).setCellValue(users.get(i - 1).getPassword());
                row.createCell(6).setCellValue(users.get(i - 1).getSex());
                row.createCell(7).setCellValue(users.get(i - 1).getAddr());
                row.createCell(8).setCellValue(users.get(i - 1).getImg());
                row.createCell(9).setCellValue(users.get(i - 1).getSign());
                row.createCell(10).setCellValue(users.get(i - 1).getStatus());
                row.createCell(11).setCellValue(users.get(i - 1).getSalt());
                row.createCell(12).setCellValue(users.get(i - 1).getRegTime());
                row.createCell(13).setCellValue(users.get(i - 1).getLastlogTime());

                row.createCell(14).setCellValue(users.get(i - 1).getLama().getLamaName());
                HSSFCell cell1 = row.createCell(6);
                HSSFCell cell2 = row.createCell(6);
                cell1.setCellStyle(cellStyle);
                cell2.setCellStyle(cellStyle);


            }

            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("用户信息" + format + ".xls", "utf-8"));
            response.setContentType("application/vnd.ms-excel");
            hssfWorkbook.write(response.getOutputStream());
            hssfWorkbook.close();
        } catch (Exception e) {

        }
    }


    @RequestMapping("/downLoad")
    @ResponseBody
    public int downLoad(HttpServletResponse response) throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();


        HSSFSheet sheet = hssfWorkbook.createSheet("用户信息");
        sheet.setColumnWidth(6, 4000);
        HSSFRow title = sheet.createRow(0);
        String[] field = new String[]{"用户编号", "真实姓名", "法号", "邮箱", "移动电话", "密码", "性别", "地址", "图片", "个性签名", "状态", "密码后缀", "注册时间", "最后一次登录时间", "跟随上师"};
        HSSFDataFormat dataFormat = hssfWorkbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy-MM-dd");
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setDataFormat(format);


        for (int i = 0; i < field.length; i++) {
            HSSFCell cell = title.createCell(i);
            if (i == 12 || i == 13) {
                cell.setCellStyle(cellStyle);
            }
            cell.setCellValue(field[i]);
        }

        ServletOutputStream outputStream = response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment;filename=model.xls");
        response.setContentType("application/msexcel");
        hssfWorkbook.write(outputStream);
        outputStream.close();

        return 1;
    }


    @RequestMapping("/addData")
    @ResponseBody
    public int addData(MultipartFile multipartFile) throws IOException {
        try {
            InputStream inputStream1 = multipartFile.getInputStream();
            List<User> users = new ArrayList<User>();

            //创建工作簿，接收导入的数据，解析
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream1);
            //获取sheet
            HSSFSheet sheet = workbook.getSheet("用户信息");
            //获取row
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                HSSFRow row = sheet.getRow(i);
                User user = new User();
                user.setUserId(row.getCell(0).getStringCellValue());
                user.setRealname(row.getCell(1).getStringCellValue());
                user.setFaName(row.getCell(2).getStringCellValue());
                user.setEmail(row.getCell(3).getStringCellValue());
                user.setMobile(row.getCell(4).getStringCellValue());
                user.setPassword(row.getCell(5).getStringCellValue());
                user.setSex(row.getCell(6).getStringCellValue());
                user.setAddr(row.getCell(7).getStringCellValue());
                user.setImg(row.getCell(8).getStringCellValue());
                user.setSign(row.getCell(9).getStringCellValue());
                user.setStatus(row.getCell(10).getStringCellValue());
                user.setSalt(row.getCell(11).getStringCellValue());
                user.setRegTime(row.getCell(12).getDateCellValue());
                user.setLastlogTime(row.getCell(13).getDateCellValue());
                Lama lama = new Lama();
                lama.setLamaId(row.getCell(14).getStringCellValue());
                user.setLama(lama);
                users.add(user);
            }
            /*for (User u : users) {
                System.out.println("---=======================");
                System.out.println(u);
            }*/
            int i = userService.importUser(users);
            workbook.close();
            inputStream1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return 1;
    }


    //"用户编号", "真实姓名", "法号", "邮箱", "移动电话", "密码", "性别", "地址", "图片", "个性签名", "状态", "密码后缀", "注册时间", "最后一次登录时间", "跟随上师"
    /*@RequestMapping("/addData")
    @ResponseBody
    public int addData( MultipartFile multipartFile) throws IOException {
        try {
            InputStream inputStream1 = multipartFile.getInputStream();

            HSSFWorkbook workbook = new HSSFWorkbook(inputStream1);

            HSSFSheet sheet = workbook.getSheet("用户信息");

            //创建userList

            List<User> users=new ArrayList<User>();

            HSSFRow row = sheet.getRow(0);
            int lastRowNum = sheet.getLastRowNum();
            System.err.println(lastRowNum+"      12341");
            for (int k = 1; k <=sheet.getLastRowNum(); k++) {
               //创建user对象
                User user = new User();


                String[] fields = new String[]{"userId", "realname", "faName", "email", "mobile", "password", "sex", "addr", "img", "sign", "status", "salt", "regTime", "lastlogTime", "lamaId"};
                short lastCellNum = row.getLastCellNum();


                HSSFCell[] cells = new HSSFCell[lastCellNum];
                for (int i = 0; i < lastCellNum; i++) {
                    row = sheet.getRow(k);
                    cells[i] = row.getCell(i);
                }
                Class<User> userClass = User.class;

                for (int i = 0; i < fields.length; i++) {
                    String field = fields[i];
                    field = "set" + field.substring(0, 1).toUpperCase() + field.substring(1, field.length());
                    if (cells[i].getCellStyle().equals("yyyy-MM-dd")) {
                        Date date =  cells[i].getDateCellValue();
                        Method method = userClass.getMethod(field, Date.class);
                        method.invoke(user,date);
                    }else {
                        Method method = userClass.getMethod(field, String.class);
                        String val= cells[i].getStringCellValue();
                        method.invoke(user,val);
                    }
                }
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return 1;
    }*/


  /*  @RequestMapping("/importXls")
    @ResponseBody
    public int importXls(String text, String[] values, HttpServletResponse response) {

        for (String value : values) {
            System.err.println(value);
        }


        try {
            List<User> userByCondition = userService.findUserByCondition(values);

            HSSFWorkbook hssfWorkbook = new HSSFWorkbook();

            HSSFSheet sheet = hssfWorkbook.createSheet("用户信息");

            HSSFRow row = sheet.createRow(0);

            String[] titles = text.split(",");
            for (int i = 0; i < titles.length; i++) {
                row.createCell(i).setCellValue(titles[i]);
            }


            for (int i = 0; i < userByCondition.size(); i++) {
                User user = userByCondition.get(i);
                Class<? extends User> c = user.getClass();
                row = sheet.createRow(i + 1);

                for (int j = 0; j < values.length; j++) {
                    String field = values[j];
                    field = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);

                    Method method = c.getMethod(field, null);
                    Object obj = method.invoke(user, null);

                    if (obj instanceof Date) {
                        Date date = (Date) obj;
                        row.createCell(j).setCellValue(date);
                    } else {
                        row.createCell(j).setCellValue(obj.toString());
                    }
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String format = simpleDateFormat.format(new Date());
                response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("用户信息" + format + ".xls", "utf-8"));
                response.setContentType("application/vnd.ms-excel");
                hssfWorkbook.write(response.getOutputStream());


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;
    }*/


    @RequestMapping("/exportXlsCostom")
    @ResponseBody
    public int ExportXls(String text, String[] values, HttpServletResponse response) {



        for (String value : values) {
            System.err.println(value);
        }
        try {
            List<User> userByCondition = userService.findUserByCondition(values);

            HSSFWorkbook hssfWorkbook = new HSSFWorkbook();

            HSSFSheet sheet = hssfWorkbook.createSheet("用户信息");

            HSSFRow row = sheet.createRow(0);

            String[] titles = text.split(",");
            for (int i = 0; i < titles.length; i++) {
                row.createCell(i).setCellValue(titles[i]);
            }
            for (int i = 0; i < userByCondition.size(); i++) {
                User user = userByCondition.get(i);
                Class<? extends User> c = user.getClass();
                row = sheet.createRow(i + 1);

                for (int j = 0; j < values.length; j++) {
                    String field = values[j];
                    field = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);

                    Method method = c.getMethod(field, null);
                    Object obj = method.invoke(user, null);

                    if (obj instanceof Date) {
                        Date date = (Date) obj;
                        row.createCell(j).setCellValue(date);
                    } else {
                        row.createCell(j).setCellValue(obj.toString());
                    }
                }
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(new Date());
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("用户信息" + format + ".xls", "utf-8"));
            response.setContentType("application/vnd.ms-excel");
            hssfWorkbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;
    }



    @RequestMapping("/queryUserMan")
    @ResponseBody
    public List<ChinaMap> queryUserMan(){
        ArrayList<ChinaMap> chinaMaps = new ArrayList<ChinaMap>();
        List<User> list = userService.queryUserByMan();
        for (User user : list) {
            ChinaMap chinaMap = new ChinaMap();
            chinaMap.setName(user.getAddr());
            chinaMap.setValue(user.getCount());
            chinaMaps.add(chinaMap);
        }
        return chinaMaps;
    }
    @RequestMapping("/queryUserWaman")
    @ResponseBody
    public List<ChinaMap> queryUserWoman(){
        ArrayList<ChinaMap> chinaMaps = new ArrayList<ChinaMap>();
        List<User> list = userService.queryUserByWoman();
        for (User user : list) {
            ChinaMap chinaMap = new ChinaMap();
            chinaMap.setName(user.getAddr());
            chinaMap.setValue(user.getCount());
            chinaMaps.add(chinaMap);
        }
        return chinaMaps;
    }
}
