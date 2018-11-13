<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<h2>持名法州后台管理系统</h2>
<div style="font-size: 16px;color: #5cfa1e;font-family: 楷体;width: 300px;float:right;padding-top:15px">
    欢迎您:${sessionScope.administrator.username }&nbsp;<a href="javascript:;" class="easyui-linkbutton" onclick="update('${sessionScope.administrator.id}');" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;
    <a href="javascript:;" onclick="baibai();" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a>
</div>
<div id="time1"
     style="font-size: 16px;color: #22fa08;font-family: 楷体;width: 260px;float:left;padding-top:15px;padding-left: -30px">
    <script type="text/javascript">
        //非动态显示
        //document.getElementById('time1').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());
        //动态显示
        setInterval("document.getElementById('time1').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());", 1000);
    </script>
</div>