<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
    var toolbar = [ {
        iconCls: 'icon-add',
        text: "添加专辑",
        handler: function () {
            $("#section_addg").dialog("open");
        }
    }, '-', {
        iconCls: 'icon-add',
        text: "添加章节",
        handler: function () {
            var row = $("#section").treegrid("getSelected");
            if (row==null){
                alert("请选中行")
            }else {
                if(row.siza == null){
                    $("#section_dialog").dialog("open");
                    $("#section_id").textbox("setValue",row.id);

                }else{
                    alert("请先选专辑");
                }
            }

        }
    }, '-', {
        iconCls: 'icon-undo',
        text: "下载音频",
        handler: function () {
            var row = $("#section").treegrid("getSelected");
            if (row == null) {
                alert("请先选中行！！！")
            } else {
            if(row.downlad !=null){
            location.href = "${pageContext.request.contextPath}/chapter/download?fileName=" + row.downlad + "&title=" + row.name;
            }else{
             alert("请选择妙音！！！")
            }
            }
        }
    }]

    $(function () {
        $("#section").treegrid({
            url: "${pageContext.request.contextPath}/album/findAll",
            idField: 'id',
            treeField: 'name',
            onDblClickRow:function (row){
                if (row == null) {
                    alert("请先选中行！！！")
                } else {
                    if (row.downlad != null) {
                        $("#section_paly").dialog("open");
                        $("#audio").prop("src", "${pageContext.request.contextPath}/"+row.downlad)
                    } else {
                        alert("请选择妙音！！！")
                    }
                }

            },
            columns: [[

                {field:'name',title:'名称',width:50,align:'left'},
                {field:'siza',title:'章节大小',width:50,align:'center'},
                {field:'duration',title:'章节时长',width:50,align:'center'},
                {field:'downlad',title:'下载路径',width:50,align:'center'},
                {field:'date',title:'上传时间',width:50,align:'center'},
                //{field:'status',title:'状态',width:50,align:'center',},
             ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageList: [10, 20, 30, 50, 100, 300, 500, 1000],
            pageSize: 10,
            toolbar: toolbar,


        })

    })


    function submit() {
        $('#section_addg').form('submit', {
            url: "${pageContext.request.contextPath}/album/add.do",

        })
    }

</script>


<table id="section"></table>


<%--添加章节--%>
<div id="section_dialog" class="easyui-dialog" title="添加章节" style="width:400px;height:500px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                  $('#section_ff').form('submit',{
                      url:'${pageContext.request.contextPath}/section/add',
                      success:function(data){
                         $('#section_dialog').dialog('close');
                         $('#section').treegrid('reload')

                    }

                  })
				}
			},{
				text:'关闭',
				handler:function(){
                    $('#section_dialog').dialog('close');
				}
			}]">

    <form id="section_ff" method="post" enctype="multipart/form-data">
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="section_id">id:</label>
            <input class="easyui-textbox" value="0" name="a_id" id="section_id" readonly="true" style="visibility: hidden;width:100%;height: 100%"/>
        </div>

        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <select class="easyui-combobox" name="score"  data-options="width:159"  style="width:100%;height: 100%">
                <option value="yes">yes</option>
                <option value="no">no</option>
            </select>
        </div>

        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="file">上传:</label>
            <input class="easyui-filebox" id="file"  data-options="multiple:true,accept:'.mp3'" name="addFile"/>
        </div>

    </form>


</div>


<%--双击播放--%>
<div id="section_paly" class="easyui-dialog" title="播放音频" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

    <audio id="audio" src="" controls="controls" autoplay="autoplay"></audio>

</div>



<%--添加专辑--%>
<div id="section_addg" class="easyui-dialog" title="添加专辑" style="width:400px;height:650px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                    $('#section_add').form('submit', {
                     url:'${pageContext.request.contextPath}/album/albumsave',
                    success:function(data){
                            //关闭对话框
                         $('#section_addg').dialog('close');
                         $('#section').treegrid('reload')
                    }
                 });
				}
			},{
				text:'关闭',
				handler:function(){
				$('#section_addg').dialog('close');
				}
			}]">

    <form id="section_add" method="post" enctype="multipart/form-data">
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="name"  required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'专辑名称'" style="width:100%;height: 100%">
        </div>
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="star" required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'星级'" style="width:100%;height: 100%">
        </div>
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="author" required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'作者'" style="width:100%;height: 100%">
        </div>
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="broadcast" required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'播音员'" style="width:100%;height: 100%">
        </div>
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="content" required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'简介'" style="width:100%;height: 100%">
        </div>

        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <select class="easyui-combobox" name="score"  data-options="width:159"  style="width:100%;height: 100%">
                <option value="yes">yes</option>
                <option value="no">no</option>
            </select>
        </div>
        <%--<div style="height: 40px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
            <input id="pdate" required="true"   class="easyui-datebox" data-options="prompt:'最后修改时间'" style="width:100%;height: 100%">
        </div>--%><%--name="pdate"--%>
        <div style="height: 40px;margin-bottom: 30px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
            <input name="file"   class="easyui-filebox"  data-options="multiple:true,accept:'.jpg,.png'"  style="width:100%;height: 100%">
        </div>
    </form>

</div>




