<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/ui-cupertino/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/form.validator.rules.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/treegrid-dnd.js"></script>
    <script>
        <%--强制登陆--%>
        var amd="${sessionScope.administrator.username}";
       if(amd==""){
            location.href='${pageContext.request.contextPath}/back/login.jsp';
       }


        $(function () {
            //页面加载完成之后显示菜单数据
            $.post("${pageContext.request.contextPath}/menu/find",function (menu) {
                //通过accordion的添加方法追加菜单

                //遍历一级菜单
                $.each(menu,function (index,m) {

                    //遍历二级菜单
                    var content = "<div style='text-align: center;'>";
                    $.each(m.menus,function(idx,child){
                        content += "<a onclick=\"addTabs('"+child.title+"','"+child.iconCls+"','"+child.href+"')\" style='width:95%;margin:10px 0px; border: 2px #eea096 solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\">"+child.title+"</a><br>";
                    });
                    content += "</div>"
                    //添加菜单
                    $("#menu").accordion('add',{
                        title:m.title,
                        iconCls:m.iconCls,
                        content:content,
                    })
                });

            });
        });

        //点击菜单追加选项卡
        function addTabs(title,iconCls,href){
           // alert(href);
            //添加以前先判断tabs中是否存在这个选项卡
            if(!$("#tabs").tabs('exists',title)){
                $("#tabs").tabs('add',{
                    title:title,
                    iconCls:iconCls,
                    closable:true,
                    fit:true,
                    href:"${pageContext.request.contextPath}"+href,
                });
            }else{
                $("#tabs").tabs('select',title);
            }

        }
        function update(id){
            $("#amdeditUserDialog").dialog({
                href:"${pageContext.request.contextPath}/back/main/edit.jsp?id="+id,
                buttons:[{
                    iconCls:'icon-save',
                    text:'修改',
                    handler:function () {
                        $("#hehe").form('submit',{
                            url:"${pageContext.request.contextPath}/login/update",
                            success:function(result){
                                var res=$.parseJSON(result);
                                //关闭对话框
                                $("#amdeditUserDialog").dialog('close');
                                //提示信息
                                $.messager.show({title:'提示',msg:res.message});
                                //刷新页面
                              location.href="${pageContext.request.contextPath}/login/baibai"
                                $.messager.show({title:'提示',msg:"密码修改成功，请重新登陆！！"});
                            }
                        })
                    }
                },
                    {
                        iconCls:'icon-cancel',
                        text:'取消',
                        handler:function(){
                            $("#amdeditUserDialog").dialog('close');
                        }
                    }
                ]
            })
        }
        function baibai(){
          $.messager.confirm("确认对话框","确定退出么？？",function(b){
              if(b){
                  location.href="${pageContext.request.contextPath}/login/baibai"
              }
          })
        }
    </script>
</head>
<body class="easyui-layout">

<%--头--%>
<div data-options="region:'north',split:false,href:'${pageContext.request.contextPath}/back/main/head.jsp'" style="height:100px;text-align: center;background: #8885ff;">

</div>


<%--页面的左侧位置--%>
<div data-options="region:'west',title:'系统菜单',split:false" style="width:200px;">

    <div id="menu" class="easyui-accordion" data-options="fit:true"></div>

</div>

<%--页面的中文位置--%>
<div data-options="region:'center'" >

    <%--主页选项卡--%>
    <div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background: url(${pageContext.request.contextPath}/back/main/image/shouye.jpg) no-repeat;background-size:100% 100%; "></div>
    </div>

</div>
<%--页面的尾部分--%>
<div data-options="region:'south',split:false,href:'${pageContext.request.contextPath}/back/main/footer.jsp'" style="height:60px;text-align: center;background: #a7d1ff;"></div>

<%--修改用户对话框--%>
<div id="amdeditUserDialog" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'更新用户信息'">

</body>
</html>
