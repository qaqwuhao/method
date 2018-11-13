<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center;">
    <form id="carouselsave" class="easyui-from" method="post" enctype="multipart/form-data">

    <div style="margin-top: 20px;">
        名称:<input type="text" name="name" class="easyui-textbox"  />
    </div>
    <div style="margin-top: 20px;">
        图片选择:<input type="text" name="file"  data-options="multiple:true,accept:'.jpg,.png'" class="easyui-filebox"  />
    </div>
    <div style="margin-top: 20px;">
        时间:<input type="text" name="date" class="easyui-datebox"  />
    </div>
    <div style="margin-top: 20px;">
        描述:<input type="text" name="desc" class="easyui-textbox"  />
    </div>
    <div style="margin-top: 20px;">
        <select class="easyui-combobox" name="status"  data-options="width:159">
            <option value="yes">yes</option>
            <option value="no">no</option>
        </select>
    </div>
    </form>


</div>
