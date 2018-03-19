<%--
  Created by IntelliJ IDEA.
  User: wd199
  Date: 2017/6/15
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script type="text/javascript">
    UE.delEditor('update_container')
    var ue = UE.getEditor('update_container');

</script>

<form id="article_up_Form" method="post">
    <table style="text-align: center">

        <tr >
            <td><input type="hidden" name="articleId"></td>
        </tr>
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
        </tr>
    </table>

    <script id="update_container" name="context" type="text/plain">

    </script><br/>

    <a id="article_up_submit">submit</a>
    <input type="reset" value="reset"/>



</form>
<script type="text/javascript">

    setTimeout(function () {
        $("#article_up_Form").form({
            url: "${pageContext.request.contextPath}/article/updateArticle",
            success: function () {
                $.messager.show({
                    title: "保存成功",
                    msg: "修改已完成。",
                    timeout: 3000,
                    showType: "slide"
                });
            }, onLoadSuccess: function (art) {
                console.log(art)
                UE.getEditor('update_container').setContent(art.context);
            }
        }).form("load", "${pageContext.request.contextPath}/article/queryArticle?articleId=" + articleId);
    }, 3000);


    $("#article_up_submit").linkbutton({
        iconCls: 'icon-edit',
        onClick: function () {
            $("#article_up_Form").form("submit", {
                url: "${pageContext.request.contextPath}/article/updateArticle",
                onSubmit: function () {
                    return $("#article_up_Form").form("validate");
                },
                success: function () {
                    $("#updateDia_article").dialog("close");
                    $.messager.show({
                        title: "提示消息",
                        msg: "修改成功，窗口5秒钟后关闭",
                        timeout: 5000
                    });
                    $("#articleTable").datagrid("reload");
                }
            });
        }
    });
</script>
