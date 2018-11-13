<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center;">
    <form id="gurusave" class="easyui-from" method="post" enctype="multipart/form-data">
    <div style="margin-top: 20px;">
        名称:<input type="text" name="name" class="easyui-textbox"  />
    </div>
    <div style="margin-top: 20px;">
        图片选择:<input type="text" name="file" class="easyui-filebox" data-options="multiple:true,accept:'.jpg,.png'" />
    </div>

    <div style="margin-top: 20px;">
        状态:<select class="easyui-combobox" name="status"  data-options="width:159">
            <option value="yes">yes展示</option>
            <option value="no">no不展示</option>
        </select>
    </div>
    </form>
</div>
