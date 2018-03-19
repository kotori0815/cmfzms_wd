<%--
  Created by IntelliJ IDEA.
  User: wd199
  Date: 2017/6/16
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="updateForm_work" method="post">
    <table>
        <tr>
            <td colspan="2"><input type="hidden" name="workId"></td>
        </tr>
        <tr>
            <td>功课名</td>
            <td><input name="workName"></td>
        </tr>
        <tr>
            <td>所属用户</td>
            <td><input name="user.realname"></td>
        </tr>
        <tr>
            <td>类型</td>
            <td><input name="type"></td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    $("#updateForm_work").form("load","${pageContext.request.contextPath}/work/queryWork?workId="+workId);
</script>

</body>
</html>