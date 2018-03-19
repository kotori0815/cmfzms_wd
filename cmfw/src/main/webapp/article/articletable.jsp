<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wd199
  Date: 2017/6/15
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>


<table id="articleTable">
    <thead>
    <tr>
        <th data-options="field:'articleId',title:'文章编号',width:50"></th>
        <th data-options="field:'title',title:'文章标题',width:50"></th>
        <th data-options="field:'context',title:'文章内容',width:100"></th>
        <th data-options="field:'lamaName',title:'文章作者',formatter:author,width:50"></th>
        <th data-options="field:'createTime',title:'创建时间',width:50"></th>
        <th data-options="field:'publishTime',title:'修改时间',width:50"></th>
        <th data-options="field:'xxx',title:'操作',formatter:up,width:50"></th>
    </tr>
    </thead>
</table>
<div id="addDia_article"></div>
<div id="updateDia_article"></div>
<div id="showarticle"></div>

<script type="text/javascript">
    $(function () {
        $("#articleTable").datagrid({
            title: '文章表',
            url: "${pageContext.request.contextPath}/article/queryArticles",
            fitColumns: true,
            pagination: true,
            pageSize: 3,
            pageList: [3, 5, 7],
            onLoadSuccess: function () {
                $.parser.parse($("a").parent());  // 解析指定节点（该节点下的所有子节点 但不包含自身组件，所以需要加parent）
            }
        })
    });


    function author(val, obj, index) {
        console.log(obj)
        return obj.lama.lamaName;
    }

    function up_article(article_id) {


        articleId = article_id
        alert(articleId)


        $("#updateDia_article").dialog({
            width:400,
            height:200,
            iconCls:"icon-image_edit",
            title:"修改文章",
            collapsible:true,
            minimizable:true,
            maximizable:true,
            resizable:true,
            href:"${pageContext.request.contextPath}/article/update.jsp"
        })
      /*  $("#updateDia_article").dialog("open");*/

    }






    $("#showarticle").window({
        width: 500,
        height: 500,
        iconCls: "icon-image_edit",
        title: "详情",
        collapsible: true,
        minimizable: true,
        maximizable: true,
        resizable: true,
        closed: true

    })

    function show_article(aid) {
        alert(aid)
        $("#showarticle").window({
            href: "${pageContext.request.contextPath}/article/queryOne?articleId=" + aid
        });

        $("#showarticle").window("open");


    }


    function up(val, row, index) {
        return "<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\"  onclick=\"up_article('" + row.articleId + "')\">修改</a>" +
            "<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\"  onclick=\"show_article('" + row.articleId + "')\">展示详情</a>";
    }

</script>


