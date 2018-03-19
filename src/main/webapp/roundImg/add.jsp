<%--
  Created by IntelliJ IDEA.
  User: wd199
  Date: 2017/6/13
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="addForm" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>轮播图描述</td>
            <td><input name="imgDetail"></td>
        </tr>
        <tr>
            <td>轮播图状态</td>
            <td><select name="status">
                <option value="未选中">未选中</option>
                <option value="选中">选中</option>
            </select></td>
        </tr>
        <tr>
            <td>上传轮播图</td>
            <td><input type="file" name="multipartFile"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="1234"></td>
        </tr>
    </table>

</form>
</body>
</html>