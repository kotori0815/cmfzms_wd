<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

   <%-- <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/IconExtension.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>--%>



<a href="javascript:void(0)" id="add_btn1">新增轮播图</a>
<div id="divRound1">
    <a href="javascript:void(0)" id="add_save">保存</a>
    <a href="javascript:void(0)" id="add_cancle">取消</a>
</div>

<div id="divRound2">
    <a href="javascript:void(0)" id="update_submit">提交</a>
</div>
<div id="updateDia">
    <form id="updateForm" method="post">
        <input type="text" id="roundimgId2" name="imgId" hidden="hidden"/>
        <table>
            <tr>
                <td>轮播图描述:</td>
                <td><input id="roundimgDetail2" name="imgDetail"/></td>
            </tr>
            <tr>
                <td>轮播图状态:</td>
                <td><select id="roundimgStatus2" name="status">
                    <option value="选中">选中</option>
                    <option value="不选中" selected="selected">不选中</option>
                </select></td>
            </tr>

        </table>
    </form>

</div>
<table id="dataView"></table>
<div id="addDia"></div>




<script type="text/javascript">
    dataView=$("#dataView");
    addDia=$("#addDia");
    updateDia=$("#updateDia");
    $(function () {

        dataView.datagrid({
            title:'DataGrid - DetailView',
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            pagination:true,
            pageSize:3,
            pageList:[3,5,7],
            url:"${pageContext.request.contextPath}/roundImg/queryAll",
            columns:[[
                {field:'imgId',title:'imgId',width:80},
                {field:'imgDetail',title:'imgDetail',width:100,sortable:true,align:'center'},
                {field:'src',title:'name',width:80,sortable:true,align:'center'},
                {field:'status',title:'status',width:80,sortable:true,align:'center'},
                {field:'createTime',title:'createTime',width:100,sortable:true,align:'center'},
                {field:'updateTime',title:'updateTime',width:100,sortable:true,align:'center'},
                {field:'xx',title:'option',width:100,align:'center',formatter:options}
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/uploading/' + rowData.src+ '"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            },
            onLoadSuccess:function(){
                $.parser.parse($("a").parent());  // 解析指定节点（该节点下的所有子节点 但不包含自身组件，所以需要加parent）
            }

        });


    })

    addDia.dialog({
        width:400,
        height:300,
        iconCls:"icon-image_edit",
        title:"新增轮播图",
        collapsible:true,
        minimizable:true,
        maximizable:true,
        resizable:true,
        closed: true,
        href:"${pageContext.request.contextPath}/roundImg/add.jsp",
        buttons:"#divRound1"
    });

    $("#add_btn1").linkbutton({
        iconCls:"icon-image_edit",
        plain:true,
        onClick:function () {
            $("#addDia").dialog("open");
        }
    });

    $("#add_save").linkbutton({
        iconCls:"icon-bullet_disk",
        onClick:function () {
            $("#addForm").form("submit",{
                url:"${pageContext.request.contextPath}/roundImg/add",
                success:function () {
                    $("#addDia").dialog("close");
                    $.messager.show({
                        title:"提示消息",
                        msg:"上传成功",
                        timeout:5000
                    });
                    $("#dataView").datagrid("load");
                }
            });
        }
    });

    $("#add_cancle").linkbutton({
        iconCls:"icon-cancel",
        onClick:function () {
            $("#addForm").form("reset");
        }
    });

    $("#updateDia").dialog({
        width:400,
        height:200,
        iconCls:"icon-image_edit",
        title:"修改轮播图",
        collapsible:true,
        minimizable:true,
        maximizable:true,
        resizable:true,
        closed: true,

        buttons:"#update_submit"
    });

    function update(roundimgId,roundimgDetail) {
        console.log(roundimgId);
        console.log(roundimgDetail);
        /* riId=roundimgId;
         riDetail=roundimgDetail;*/

        $("#roundimgId2").val(roundimgId);
        $("#roundimgDetail2").val(roundimgDetail);

        $("#updateDia").dialog("open");

        $("#update_submit").linkbutton({
            iconCls:'icon-edit',
            onClick:function () {
                $("#updateForm").form("submit",{
                    url:"${pageContext.request.contextPath}/roundImg/update",
                    onSubmit:function () {
                        return $("#updateForm").form("validate");
                    },
                    success:function () {
                        $("#updateDia").dialog("close");
                        $.messager.show({
                            title:"提示消息",
                            msg:"修改成功，窗口5秒钟后关闭",
                            timeout:5000
                        });
                        $("#dataView").datagrid("reload");
                    }
                });
            }
        });
    }

    function options(val,row,index) {
        return "<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\"  onclick=\"update('"+row.imgId+"','"+row.imgDetail+"')\">修改</a>";
    }

</script>
