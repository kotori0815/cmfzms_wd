<%--
  Created by IntelliJ IDEA.
  User: wd199
  Date: 2017/6/16
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>




<div id="work_update">
    <a href="javascript:void(0)" id="work_update_sub">提交</a>
</div>


<table id="work_table">
    <thead>
    <tr>
        <th data-options="field:'workId'">id</th>
        <th data-options="field:'workName'">功课名</th>
        <th data-options="field:'type'">类型</th>
        <th data-options="field:'user',formatter:us">所属用户</th>
        <th data-options="field:'xxx',formatter:opt">操作</th>


    </tr>
    </thead>
</table>

<div id="updateDia_work"></div>
<div id="showwork">
    <form id="work_form">
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
</div>


<script type="text/javascript">

    $(function () {
        $("#work_table").datagrid({
            title:'用户表',
            url:"${pageContext.request.contextPath}/work/queryWorks",
            fitColumns:true,
            pagination:true,
            pageSize:3,
            pageList:[3,5,7],
            onLoadSuccess:function(){
                $.parser.parse($("a").parent());  // 解析指定节点（该节点下的所有子节点 但不包含自身组件，所以需要加parent）
            }
        })


    });


    $("#showwork").window({
        width: 600,
        height: 300,
        iconCls: "icon-image_edit",
        title: "详情",
        collapsible: true,
        minimizable: true,
        maximizable: true,
        resizable: true,
        closed: true
    })


    function opt(val,row,index) {
        return "<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\"  onclick=\"up_work('"+row.workId+"')\">修改</a>" +
            "<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\"  onclick=\"show_work('"+row.workId+"')\">展示详情</a>";
    }

    function show_work(uid) {
        $("#work_form").form("load","${pageContext.request.contextPath}/work/queryWork?workId="+uid)

        $("#showwork").window("open");
    }


    $("#updateDia_work").dialog({
        width:400,
        height:200,
        iconCls:"icon-image_edit",
        title:"修改",
        collapsible:true,
        minimizable:true,
        maximizable:true,
        resizable:true,
        closed:true,
        buttons:"#work_update",
        href:"${pageContext.request.contextPath}/work/work_update.jsp"

    });

    function up_work(code) {
        workId=code

        $("#updateDia_work").dialog("open");


        $("#work_update_sub").linkbutton({
            iconCls:'icon-edit',
            onClick:function () {
                $("#updateForm_work").form("submit",{
                    url:"${pageContext.request.contextPath}/work/updateWork",
                    onSubmit:function () {
                        return $("#updateForm_work").form("validate");
                    },
                    success:function () {
                        $("#updateDia_work").dialog("close");
                        $.messager.show({
                            title:"提示消息",
                            msg:"修改成功，窗口5秒钟后关闭",
                            timeout:5000
                        });
                        $("#work_table").datagrid("reload");
                    }
                });
            }
        });

    }
    function us(val,obj,index){
        return obj.user.realname;
    }



</script>
