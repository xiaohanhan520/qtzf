<%--
  Created by IntelliJ IDEA.
  User: h
  Date: 2019/7/15
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){
        $("#albumTable").jqGrid({
            styleUI:"Bootstrap",
            url:"${pageContext.request.contextPath}/album/all",
            datatype:"json",
            colNames:["编号","专辑名称","专辑封面","章节数量","专辑得分","专辑作者","播音员","专辑简介","出版时间"],
            colModel:[
                {name : "id"},
                {name : "title", editable:true},
                {name : "cover",editable:true,edittype:"file",formatter:function(cellvalue, options, rowObject){
                        return "<img style='width:70px;height:80px' src='${pageContext.request.contextPath}/album/"+cellvalue+"'/>";
                    }},
                {name : "count",editable:true},
                {name : "score",editable:true},
                {name : "author",editable:true},
                {name : "broadcast",editable:true},
                {name : "brief",editable:true},
                {name : "publishTime"}
                ],
            rownumbers: true,
            rowNum : 3,//一页显示多少条
            rowList : [3, 5, 7, 9],//可供用户选择一页显示多少条
            pager : '#albumDiv',//表格页脚的占位符(一般是div)的id
            autowidth:true,
            mtype : "post",//向后台请求数据的ajax的类型。可选post,get
            viewrecords : true,
            multiselect : true,//是否允许多选
            multiboxonly:true,
            height:"100%",
            editurl:"${pageContext.request.contextPath}/album/edit",
            subGrid : true,
            subGridRowExpanded : function(subgrid_id, row_id) {
                var subgrid_table_id, pager_id;
                subgrid_table_id = subgrid_id + "_t";
                pager_id = "p_" + subgrid_table_id;
                $("#" + subgrid_id).html(
                    "<table id='" + subgrid_table_id
                    + "' class='scroll'></table><div id='"
                    + pager_id + "' class='scroll'></div>");
                jQuery("#" + subgrid_table_id).jqGrid(
                    {
                        url : "${pageContext.request.contextPath}/chapter/all?id=" + row_id,
                        datatype : "json",
                        colNames : [ '编号', '专辑编号', '音频名称', '音频大小','音频路径','上传时间','操作' ],
                        colModel : [
                            {name : "id"},
                            {name : "albumId",editable:true},
                            {name : "title",editable:true},
                            {name : "size"},
                            {name : "downPath",editable:true,edittype:"file"},
                            {name : "uploadTime"},
                            {formatter:function (cellvalue, options, rowObject) {
                                    return "<a class='btn btn-info' href='${pageContext.request.contextPath}/chapter/download?fileName="+rowObject["downPath"]+"'>下载</a>";
                                }}
                        ],
                        rownumbers: true,
                        multiselect : true,//是否允许多选
                        multiboxonly:true,
                        autowidth:true,
                        rowNum : 3,
                        rowList : [3, 5, 7, 9],
                        pager : pager_id,
                        sortname : 'num',
                        sortorder : "asc",
                        height : '100%',
                        editurl:"${pageContext.request.contextPath}/chapter/edit",
                    });
                jQuery("#" + subgrid_table_id).jqGrid('navGrid',
                    "#" + pager_id, {
                        edit : true,
                        add : true,
                        del : true
                    },{
                        //修改的部分
                        closeAfterEdit:true,
                        afterSubmit:function(response){
                            $("#carouselTable").trigger("reloadGrid");
                            return "[true]";
                        }
                    },{
                        //添加的部分
                        closeAfterAdd:true,
                        afterSubmit:function(response){
                            $.ajaxFileUpload({
                                url:"${pageContext.request.contextPath}/chapter/upload",
                                fileElementId:"downPath",
                                data:{"id":response.responseText},
                                type:"post",
                                success:function(){
                                    $("#albumTable").trigger("reloadGrid");
                                }
                            })
                            return "[true]";
                        }

                    },{
                        afterSubmit:function(response){
                            $("#albumTable").trigger("reloadGrid");
                            return "[true]";
                        }
                    });
            },
        })
        jQuery("#albumTable").jqGrid("navGrid","#albumDiv",{},{
            //修改的部分
            closeAfterEdit:true
        },{
            //添加的部分
            closeAfterAdd:true,
            afterSubmit:function(response){
                $.ajaxFileUpload({
                    url:"${pageContext.request.contextPath}/album/upload",
                    fileElementId:"cover",
                    data:{"id":response.responseText},
                    type:"post",
                    success:function(){
                        $("#albumTable").trigger("reloadGrid");
                    }
                })
                return "[true]";
            }
        })
    })
</script>

<div class="page-header">
    <h2>专辑管理</h2>
</div>


<table id="albumTable"></table>
<div id="albumDiv"></div>