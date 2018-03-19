<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wd199
  Date: 2017/6/16
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div id="asdasd" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('asdasd'));
    //    require.config

    $.get('<c:url value="/user/queryTime"/>').done(function (data) {
        myChart.setOption({
            title: {
                text: '异步数据加载示例'
            },
            tooltip: {},
            legend: {
                data: ['销量']
            },
            xAxis: {
                data: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: data
            }]
        });
    });
</script>
