<%--
  Created by IntelliJ IDEA.
  User: wd199
  Date: 2017/6/13
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<form id="updateForm_lama" method="post">
    <table>
        <tr>
            <td colspan="2"><input type="hidden" name="lamaId"></td>
        </tr>
        <tr>
            <td>法号</td>
            <td><input name="lamaName"></td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    $("#updateForm_lama").form("load","${pageContext.request.contextPath}/lama/queryLama?lamaId="+lamaId);
</script>
