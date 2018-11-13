<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<script>
    $(function () {
        $("#carouseedit").form('load','${pageContext.request.contextPath}/carousel/findAllone?id=${param.id}')
    })
</script>

<div style="text-align: center;">
    <form id="carouseedit" class="easyui-from" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px;">
            名称:<input type="text" name="name" class="easyui-textbox"/>
        </div>
        <div style="margin-top: 20px;">
            图片选择:<input id="setgg" type="text"  data-options="multiple:true,accept:'.jpg,.png'" name="file" class="easyui-filebox"  />
        </div>
        <div style="margin-top: 20px;">
            时间:<input type="text" name="date" class="easyui-datebox"/>
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
    </form>


</div>
