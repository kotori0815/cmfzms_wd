<%--
  Created by IntelliJ IDEA.
  User: wd199
  Date: 2017/6/18
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>

    <script type="text/javascript">
        $(function () {
            $("#dia").dialog({
                width:350,
                height:250,
                closed:true
            });

            $("#btn").linkbutton({
                text: "自定义导出",
                onClick:function(){
                    // 初始化dialog
                    $("#dia").dialog("open")

                    $("#ct").combotree({
                        multiple:true,
                        onlyLeafCheck:true,
                        data:[{
                            text:"自定义导出",
                            children:[{
                                id:"userId",
                                text:"编号",
                                iconCls:"icon-edit",
                            },{
                                id:"faName",
                                text:"法号",
                                iconCls:"icon-edit",
                            },{
                                id:"realname",
                                text:"真实姓名",
                                iconCls:"icon-edit",
                            },{
                                id:"email",
                                text:"邮箱",
                                iconCls:"icon-edit",
                            },{
                                id:"mobile",
                                text:"移动电话",
                                iconCls:"icon-edit",
                            },{
                                id:"password",
                                text:"密码",
                                iconCls:"icon-edit",
                            },{
                                id:"sex",
                                text:"性别",
                                iconCls:"icon-edit",
                            },{
                                id:"addr",
                                text:"地址",
                                iconCls:"icon-edit",
                            },{
                                id:"img",
                                text:"头像",
                                iconCls:"icon-edit",
                            },{
                                id:"sign",
                                text:"签名",
                                iconCls:"icon-edit",
                            },{
                                id:"salt",
                                text:"密码后缀",
                                iconCls:"icon-edit",
                            },{
                                id:"regTime",
                                text:"注册时间",
                                iconCls:"icon-edit",
                            },{
                                id:"lastlogTime",
                                text:"最后登录时间",
                                iconCls:"icon-edit",
                            },{
                                id:"status",
                                text:"状态",
                                iconCls:"icon-edit",
                            }]
                        }],
                    });
                }
            });


            $("#sub").linkbutton({
                onClick:function () {
                    //1. 标题信息  项的value
                    var text = $("#ct").combotree("getText");
                    var values = $("#ct").combotree("getValues");
                    console.log(text);
                    console.log(values);
                    $("#form").form("submit",{
                        url:"${pageContext.request.contextPath}/user/exportXlsCostom",
                        queryParams:{"text":text,"values":values}
                    });
                }
            });
        });
    </script>


<a id="btn"></a>
<div id="dia">
    <form id="form">
        <input id="ct"/>
        <a id="sub"></a>
    </form>
</div>

<div>
    <form id="formdown" action="${pageContext.request.contextPath}/user/downLoad" method="post">
        <input type="submit" title="导出模板">
    </form>
</div>

<div>
    <form id="formup" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/user/addData">
        <input type="file" name="multipartFile">
        <input type="submit" title="上传">
    </form>
</div>

<div>
    <form id="downLoadAll" action="${pageContext.request.contextPath}/user/downLoadall" method="post">
        <input type="submit" value="导出数据">
    </form>
</div>

