<%--
  Created by IntelliJ IDEA.
  User: wd199
  Date: 2017/6/20
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<table id="logTable">
    <thead>
    <tr>
        <th data-options="field:'advId',title:'编号'"></th>
        <th data-options="field:'createName',title:'创建者'"></th>
        <th data-options="field:'createTime',title:'创建时间'"></th>
        <th data-options="field:'content',title:'操作内容'"></th>
    </tr>
    </thead>
</table>

<script type="text/javascript">
    $(function () {
        $("#logTable").datagrid({
            title:'日志表',
            url:"${pageContext.request.contextPath}/advice/findAdvices",
            fitColumns:true,
            pagination:true,
            pageSize:3,
            pageList:[3,5,7]
        })
    })
</script>
