<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<script>
    $(function () {

        $.extend($.fn.validatebox.defaults.rules, {
            equals: {
                validator: function(value,param){
                    return value == $(param[0]).val();
                },
                message: '确认密码有误'
            }
        });

    })




</script>
<div style="text-align: center;">
    <form id="hehe" class="easyui-from" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px;">
            旧密码:<input type="text" id="p" value="${sessionScope.administrator.password}" readonly="true" />
        </div>
        <div style="margin-top: 20px;">
            新密码:<input id="pwd" name="password" type="password" class="easyui-validatebox" data-options="required:true" /><br><br>
            确认密码:<input id="rpwd" type="password" class="easyui-validatebox"
                        required="required" validType="equals['#pwd']" />
        </div>
    </form>
</div>
