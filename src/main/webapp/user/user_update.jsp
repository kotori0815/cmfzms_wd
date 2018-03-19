<%--
  Created by IntelliJ IDEA.
  User: wd199
  Date: 2017/6/16
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="updateForm_user" method="post">
    <table>
        <tr>
        <td colspan="2"><input type="hidden" name="userId"></td>
    </tr>
        <tr>
            <td>真实姓名</td>
            <td><input name="realname"></td>
        </tr>
        <tr>
            <td>状态</td>
            <td><input name="status"></td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    $("#updateForm_user").form("load","${pageContext.request.contextPath}/user/queryUser?userId="+userId);
</script>

</body>
</html>
