<%--
  Created by IntelliJ IDEA.
  User: wd199
  Date: 2017/6/15
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script type="text/javascript">
    UE.delEditor('add_container')
    var ue = UE.getEditor('add_container');
</script>

<form id="articleForm" method="post">
<table style="text-align: center">

        <tr >
            <td>文章标题</td>
            <td><input name="title"></td>
        </tr>

    <tr >
        <td>上师</td>
        <td><input id="cc" class="easyui-combobox" name="lama.lamaId"
                   data-options="valueField:'lamaId',textField:'lamaName',url:'${pageContext.request.contextPath}/lama/queryAll'"/></td>
    </tr>
        <tr>
            <td >文章状态:</td>
            <td><input class="easyui-switchbutton" data-options="onText:'Yes',offText:'No'" name="status"></td>
        </tr>
        <tr >
            <td>文章内容:</td>
            <td></td>
        </tr>
</table>

    <script id="add_container" name="context" type="text/plain"></script><br/>

    <a id="article_submit">submit</a>
    <input type="reset" value="reset"/>



</form>
<script type="text/javascript">
    $(function () {
        UE.getEditor('add_container').execCommand( "clearlocaldata" );
    })
    $("#article_submit").linkbutton({
        onClick:function () {
            $("#articleForm").form("submit",{
                url:"${pageContext.request.contextPath}/article/addArticle",
                success:function (resu) {
                    $.messager.show({
                        title:"提示消息",
                        msg:"上传成功",
                        timeout:5000
                    });

                    $("#tt").tabs("close","文章2");

                }
            })
        }
    })
</script>
