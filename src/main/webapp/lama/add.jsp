<%--
  Created by IntelliJ IDEA.
  User: wd199
  Date: 2017/6/14
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>


<head>
    <title>Title</title>
</head>
<body>


<form id="addForm_lama" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>上师法号</td>
            <td><input name="lamaName"></td>
        </tr>
        <tr>
            <td>上传上师头像</td>
            <td><input type="file" name="multipartFile"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="1234"></td>
        </tr>
    </table>
    </form>
</body>
</html>
