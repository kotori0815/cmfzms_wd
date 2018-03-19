<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wd199
  Date: 2017/6/25
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
<form id="frm" method="post" action="<c:url value="/poetry/query"/>">
    <input type="text" name="keyWord" value=""/>
    <input type="text" name="page" value="1"/>
    <%--<input type="text" name="type" value="1"/>--%>
    <select name="type">
        <option value="poet">诗人</option>
        <option value="poem">内容</option>
    </select>
    <a href="javascript:void(0)" onclick="click123()">搜索</a>
</form>
<div id="content"></div>

<script>
    function click123() {
        console.log(123);
        $.post("<c:url value="/poetry/query"/>", $("#frm").serialize(), function (data) {
            console.log(data);
//            $("#content").clear();
            $("content").append("<p>"+data.total+"</p>");

            for (var i = 0; i < data.poetryList.length; i++) {
                $("#content").append("<div>" +
                    "<a href=\"javascript:void(0)\" onclick='query(" + data.poetryList[i].id + ")'><h3>" +
                    data.poetryList[i].title +
                    "</h3></a>" +
                    "<p>" +
                    data.poetryList[i].poet.name +
                    "</p>" +
                    "<p>" +
                    data.poetryList[i].content +
                    "</p>" +
                    "</div>");
            }
        }, "json");

    }

    function query(id) {
        console.log("id " + id);
    }
</script>
</body>
</html>
