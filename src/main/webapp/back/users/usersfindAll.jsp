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
                url:"${pageContext.request.contextPath}/user/findAll",
                columns:[[
                    {title:'id',field:'id',width:90},
                    {title:'姓名',field:'name',width:90},
                    {title:'电话',field:'phone',width:90},
                    {title:'密码',field:'password',width:90},
                    {title: '地址', field: 'address',width:90},
                    {title: '法名', field: 'rename',width:90},
                    {title: '性别', field: 'sex',width:90},
                    {title: '注册时间', field: 'date',width:90},
                    {title: '个性签名', field: 'signaure',width:90},
                    {title: '头像', field: 'head',width:90},
                    {title: '状态', field: 'staus',width:90},
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


    </script>

<table id="gurudeptDg" class="easyui-datagrid" data-options="fit:true">

</table>





