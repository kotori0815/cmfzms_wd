<%--
  Created by IntelliJ IDEA.
  User: wd199
  Date: 2017/6/14
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<a href="javascript:void(0)" id="add_lama">新增上师</a>
<div id="lama_add">
    <a href="javascript:void(0)" id="lama_save">保存</a>
    <a href="javascript:void(0)" id="lama_cancle">取消</a>
</div>
<div id="lama_update">
    <a href="javascript:void(0)" id="lama_update_sub">提交</a>
</div>
    <table id="lamaTable">
        <thead>
            <tr>
                <th data-options="field:'lamaId',title:'上师id'"></th>
                <th data-options="field:'lamaName',title:'上师法号'"></th>
                <th data-options="field:'img',title:'上师头像'"></th>
                <th data-options="field:'xxx',title:'操作',formatter:up"></th>
            </tr>
        </thead>
    </table>
<div id="addDia_lama"></div>
<div id="updateDia_lama"></div>

<script type="text/javascript">
    $(function () {
        $("#lamaTable").datagrid({
            title:'上师表',
            url:"${pageContext.request.contextPath}/lama/queryLamas",
            fitColumns:true,
            pagination:true,
            pageSize:3,
            pageList:[3,5,7],
            onLoadSuccess:function(){
                $.parser.parse($("a").parent());  // 解析指定节点（该节点下的所有子节点 但不包含自身组件，所以需要加parent）
            }
        })
    });


    $("#addDia_lama").dialog({
        width:400,
        height:300,
        iconCls:"icon-image_edit",
        title:"新增上师",
        collapsible:true,
        minimizable:true,
        maximizable:true,
        resizable:true,
        closed: true,
        href:"${pageContext.request.contextPath}/lama/add.jsp",
        buttons:"#lama_add"
    });

    $("#add_lama").linkbutton({
        iconCls:"icon-image_edit",
        plain:true,
        onClick:function () {
            $("#addDia_lama").dialog("open");
        }
    });

    $("#lama_save").linkbutton({
        iconCls:"icon-bullet_disk",
        onClick:function () {
            $("#addForm_lama").form("submit",{
                url:"${pageContext.request.contextPath}/lama/add",
                success:function () {
                    $("#addDia_lama").dialog("close");
                    $.messager.show({
                        title:"提示消息",
                        msg:"上传成功",
                        timeout:5000
                    });
                    $("#lamaTable").datagrid("load");
                }
            });
        }
    });


    $("#lama_cancle").linkbutton({
        iconCls:"icon-cancel",
        onClick:function () {
            $("#addForm").form("reset");
        }
    });


    $("#updateDia_lama").dialog({
        width:400,
        height:200,
        iconCls:"icon-image_edit",
        title:"修改上师姓名",
        collapsible:true,
        minimizable:true,
        maximizable:true,
        resizable:true,
        closed:true,
        buttons:"#lama_update"

    });

    function up_lama(code) {
       lamaId=code

        $("#updateDia_lama").dialog({
            href:"${pageContext.request.contextPath}/lama/update.jsp"
        });


        $("#lama_update_sub").linkbutton({
            iconCls:'icon-edit',
            onClick:function () {
                $("#updateForm_lama").form("submit",{
                    url:"${pageContext.request.contextPath}/lama/updateLama",
                    onSubmit:function () {
                        return $("#updateForm_lama").form("validate");
                    },
                    success:function () {
                        $("#updateDia_lama").dialog("close");
                        $.messager.show({
                            title:"提示消息",
                            msg:"修改成功，窗口5秒钟后关闭",
                            timeout:5000
                        });
                        $("#lamaTable").datagrid("reload");
                    }
                });
            }
        });

    }

    function up(val,row,index) {
        return "<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\"  onclick=\"up_lama('"+row.lamaId+"')\">修改</a>";
    }

</script>