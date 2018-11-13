<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/datagrid-detailview.js"></script>
    <script>
        $(function () {
            $("#gurudeptDg").datagrid({
                toolbar:'#gurutb',
                pagination:true,
                striped:true,
                checkOnSelect:false,
                singleSelect:false,
                ctrlSelect:true,
                remoteSort:false,
                multiSort:true,
                url:"${pageContext.request.contextPath}/guru/findAll",
                columns:[[
                    {title:'cks',field:"cks",checkbox:true},
                    {title:'id',field:'id',width:120},
                    {title:'名称',field:'name',width:120},
                    {title:'状态',field:'status',width:120},
                    {title:'上师照片路径',field:'head',width:120},
                    {title: "操作", field: 'options',width:150,
                        formatter: function (value, row, index) {
                            return "<a href='javascript:;' class='options' onclick=\"gurudelRow('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>&nbsp;&nbsp;"+
                                    "<a href='javascript:;' class='options' onclick=\"gurupp('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">修改</a>"

                        },
                    }
                ]],
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/' + rowData.head + '" style="height:100px;"></td>' +
                        '<td style="border:0">' +
                        '<p>名称: ' + rowData.name + '</p>' +
                        '</td>' +
                        '</tr></table>';
                },
            onLoadSuccess:function () {
                    $(".options").linkbutton();
                },
            });
        })
        //删除一行
        function gurudelRow(id){
            $.messager.confirm("确认对话框","考虑清楚再删除？？",function(b){
                if(b){
                    $.post("${pageContext.request.contextPath}/guru/delete",{"id":id},function (result) {
                        $.messager.show({title: '提示', msg: result.message});
                        $("#gurudeptDg").datagrid('reload');
                    });
                }
            })

        }
        //删除多选
        function gurudelBatchRows(){
            var rows = $("#gurudeptDg").datagrid('getSelections');
            if (rows<=1){
                $.messager.show({title:'提示',msg:"至少选中一行!!!"});
            }else{
                var ids = [];
                for (var i = 0; i < rows.length ; i++) {
                    ids.push(rows[i].id);
                }
                $.messager.confirm("确认对话框","考虑清楚再删除？？",function(b){
                    if(b){
                        $.ajax({
                            url:"${pageContext.request.contextPath}/guru/deletes",
                            type:"post",
                            //传递数据类型的数据时必须设置这个属性为true
                            traditional:true,
                            data:{id:ids},
                            success:function (result) {
                                //消息提醒
                                $.messager.show({title:'提示',msg:result.message});
                                //刷新
                                $("#gurudeptDg").datagrid('reload');
                            },
                            error:function () {
                                //消息提示
                                $.messager.show({title:'提示',msg:"删除失败!!!"});
                                //刷新
                                $("#gurudeptDg").datagrid('reload');
                            }
                        })
                    }
                })
            }
        }
        //添加
        function guruopenSaveUserDialog(){
            $("#gurusaveUserDialog").dialog({
                buttons:[{
                    iconCls:'icon-save',
                    text:'保存',
                    handler:function(){
                        //保存信息
                        $("#gurusave").form("submit",{
                            url:"${pageContext.request.contextPath}/guru/save",
                            success:function (result) {
                                var resultObj = $.parseJSON(result);
                                $.messager.show({title: '提示', msg:resultObj.message});
                                $("#gurusaveUserDialog").dialog('close');
                                $("#gurudeptDg").datagrid('reload');
                            }
                        })
                    }
                }, {
                    iconCls: 'icon-cancel',
                    text: '关闭',
                    handler: function () {
                        $("#gurusaveUserDialog").dialog('close');
                    }
                }]
            })
        }
        //修改
        function gurupp(id){
            $("#gurueditUserDialog").dialog({
                href:"${pageContext.request.contextPath}/back/guru/edit.jsp?id="+id,
                buttons:[{
                    iconCls:'icon-save',
                    text:'修改',
                    handler:function () {
                        $("#guruedit").form('submit',{
                            url:"${pageContext.request.contextPath}/guru/date",
                            success:function(result){
                                var resultObj = $.parseJSON(result);
                                $.messager.show({title:'提示',msg:resultObj.message});
                                //关闭对话框
                                $("#gurueditUserDialog").dialog('close');
                                //刷新
                                $("#gurudeptDg").datagrid('reload');

                            }
                        })
                    }
                },
                    {
                        iconCls:'icon-cancel',
                        text:'取消',
                        handler:function(){
                            $("#gurueditUserDialog").dialog('close');
                        }
                    }
                ]
            })
        }

    </script>

<table id="gurudeptDg" class="easyui-datagrid" data-options="fit:true">

</table>

<%--datagrid工具栏--%>
<div id="gurutb">
    <a href="#" class="easyui-linkbutton" onclick="guruopenSaveUserDialog();" data-options="iconCls:'icon-add',plain:true">添加</a>
    <a href="#" class="easyui-linkbutton" onclick="gurudelBatchRows();" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
</div>
<%--添加用户对话框--%>
<div id="gurusaveUserDialog" data-options="href:'${pageContext.request.contextPath}/back/guru/save.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存上师信息'">



</div>

<%--修改用户对话框--%>
<div id="gurueditUserDialog" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'更新用户信息'">
</div>