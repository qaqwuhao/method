<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-tip',
        text: "专辑详情",
        handler: function () {
           var row = $("#album").treegrid("getSelected");
           if(row == null ){
                alert("请选中行！！！！");
           }else{
               if(row.siza == null){  //选中的是专辑
                   $("#album_dialog").dialog("open");
                   /*填充内容*/
                   $("#album_ff").form("load",row);
                   $("#coverImg").prop("src",'${pageContext.request.contextPath}/'+row.pictre);

               }else {
                   alert("请先选择专辑！！！");
               }
           }

        }
    }, '-', {
        iconCls: 'icon-add',
        text: "添加专辑",
        handler: function () {
            $("#album_addg").dialog("open");
        }
    }, '-', {
        iconCls: 'icon-add',
        text: "添加章节",
        handler: function () {
            var row = $("#album").treegrid("getSelected");
            if (row==null){
                alert("请选中行")
            }else {
                if(row.siza == null){
                    $("#chapter_dialog").dialog("open");
                    $("#album_id").textbox("setValue",row.id);

                }else{
                    alert("请先选专辑");
                }
            }

        }
    }, '-', {
        iconCls: 'icon-undo',
        text: "下载音频",
        handler: function () {
            var row = $("#album").treegrid("getSelected");
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
        $("#album").treegrid({
            url: "${pageContext.request.contextPath}/album/findAll",
            idField: 'id',
            treeField: 'name',
            onDblClickRow:function (row){
                if (row == null) {
                    alert("请先选中行！！！")
                } else {
                    if (row.downlad != null) {
                        $("#album_paly").dialog("open");
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
        $('#album_addg').form('submit', {
            url: "${pageContext.request.contextPath}/album/add.do",

        })
    }

</script>


<table id="album"></table>
<%--专辑详情--%>
<div id="album_dialog" class="easyui-dialog" title="专辑详情" style="width:400px;height:600px;"
     data-options="iconCls:'icon-tip',resizable:true,modal:true,closed:true">

    <form id="album_ff" method="post">
        <div style="height: 20px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="title">专辑名称:</label>
            <input id="title" name="name" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

        <div style="height: 20px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="acount">专辑集数:</label>
            <input id="acount" name="number" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

        <div style="height: 20px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="score">专辑星级:</label>
            <input id="score" name="score" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%" value="五星">
        </div>

        <div style="height: 20px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="author">专辑作者:</label>
            <input id="author" name="author" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

        <div style="height: 20px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="broadCast">播音员:</label>
            <input id="broadCast" name="broadcast" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

        <div style="height: 20px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="brief">简介:</label>
            <input id="brief" name="content" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

        <div style="height: 20px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="publishDate">发布日期:</label>
            <input id="publishDate" name="date" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

        <div style="height: 20px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="status">状态:</label>
            <input id="status" name="star" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%" value="yes">
        </div>

        <div style="margin-top: 30px;padding-left:20%;padding-right: 20%">
            <label for="coverImg">封面:</label>
            <img id="coverImg" src="" style="width:100%;height:100%;">
        </div>

        <%--<div style="height: 40px;margin-bottom: 30px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
            <input name="img" required="true"  class="easyui-filebox"  style="width:100%;height: 100%">
        </div>--%>
    </form>

</div>

<%--添加章节--%>
<div id="chapter_dialog" class="easyui-dialog" title="添加章节" style="width:400px;height:500px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                  $('#chapter_ff').form('submit',{
                      url:'${pageContext.request.contextPath}/section/add',
                      success:function(data){
                         $('#chapter_dialog').dialog('close');
                         $('#album').treegrid('reload')

                    }

                  })
				}
			},{
				text:'关闭',
				handler:function(){
                    $('#chapter_dialog').dialog('close');
				}
			}]">

    <form id="chapter_ff" method="post" enctype="multipart/form-data">
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="album_id">id:</label>
            <input class="easyui-textbox" value="0" name="album_id"  readonly="true" id="album_id" style="visibility: hidden;width:100%;height: 100%"/>
        </div>

        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <select class="easyui-combobox" name="score"  data-options="width:159"  style="width:100%;height: 100%">
                <option value="yes">yes</option>
                <option value="no">no</option>
            </select>
        </div>

        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="file">上传:</label>
            <input class="easyui-filebox" id="file"   data-options="multiple:true,accept:'.mp3'" name="addFile"/>
        </div>

    </form>


</div>


<%--双击播放--%>
<div id="album_paly" class="easyui-dialog" title="播放音频" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

    <audio id="audio" src="" controls="controls" autoplay="autoplay"></audio>

</div>



<%--添加专辑--%>
<div id="album_addg" class="easyui-dialog" title="添加专辑" style="width:400px;height:650px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                    $('#album_add').form('submit', {
                     url:'${pageContext.request.contextPath}/album/albumsave',
                    success:function(data){
                            //关闭对话框
                         $('#album_addg').dialog('close');
                         $('#album').treegrid('reload')
                    }
                 });
				}
			},{
				text:'关闭',
				handler:function(){
				$('#album_addg').dialog('close');
				}
			}]">

    <form id="album_add" method="post" enctype="multipart/form-data">
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
            <input name="file"   class="easyui-filebox"  data-options="multiple:true,accept:'.jpg,.png'" style="width:100%;height: 100%">
        </div>
    </form>

</div>




