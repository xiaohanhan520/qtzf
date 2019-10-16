<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<script type="text/javascript">
    $(function(){
        //页面加载完成之后执行
        pageInit();
    });
    function pageInit(){
        //创建jqGrid组件
        jQuery("#list2").jqGrid(
            {
                url : '${pageContext.request.contextPath}/user/all',
                datatype : "json",//请求数据返回的类型。可选json,xml,txt
                colNames : ['编号', '手机', '密码', '盐','法名','省', '市','性别', '签名','头像','状态','创建日期','操作'],
                colModel : [
                    {name : 'id'},
                    {name : 'phone'},
                    {name : 'password'},
                    {name : 'salt'},
                    {name : 'dharmaName'},
                    {name : 'province'},
                    {name : 'city'},
                    {name : 'gender'},
                    {name : 'personalSign'},
                    {name : 'profile',edittype:"file",formatter:function(cellvalue, options, rowObject){
                            return "<img style='width:100px;height:60px' src='${pageContext.request.contextPath}/headPortrait/"+cellvalue+"'/>";
                        }},
                    {name : 'status'},
                    {name : 'registTime'},
                    {formatter:function (cellvalue, options, rowObject) {
                            return "<button class='btn btn-info'  onclick='modify(\""+rowObject["id"]+"\",\""+rowObject["status"]+"\")'>修改</button>";
                        }}
                ],
                rownumbers: true,
                rowNum : 5,//一页显示多少条
                rowList : [5, 10,15, 20, 25,30],//可供用户选择一页显示多少条
                pager : '#pager2',//表格页脚的占位符(一般是div)的id
                autowidth:true,
                mtype : "post",//向后台请求数据的ajax的类型。可选post,get
                viewrecords : true,
                height:"100%",
            });
        jQuery("#list2").jqGrid('navGrid', '#pager2',{edit: false, add: false, del: false, search: false, refresh: false});
    };

    function modify(id,status) {
        $.ajax({
            url:"${pageContext.request.contextPath}/user/modifyStatus",
            type:"post",
            data:{id:id,status:status},
            success:function (data) {
                $("#list2").trigger("reloadGrid");
            }

        })
    }
    function excelUpload() {
        var f = new FormData($("#fileUp")[0]);
        $.ajax({
            url:"${pageContext.request.contextPath}/user/uploadExcel",
            type:"post",
            data:f,
            cache: false,
            processData: false,
            contentType: false,
            success:function(){
                alert("上传成功")
               $("#fileOver").val('');
               $("#list2").trigger("reloadGrid");
            }
        })
    }
</script>

<div class="page-header">
    <h2>用户管理</h2>
</div>
<form id="fileUp"  class="form-inline" method="post" action="javascript:void(0)" enctype="multipart/form-data">
    <div class="form-group">
        <span>导入Excel</span>
        <input type="file"  id="fileOver" name="file"  multiple="multiple">
    </div>
    <div class="form-group">
        <input type="button" class="btn btn-info" value="提交" onclick="excelUpload()">
       <a class="btn btn-info" href="${pageContext.request.contextPath}/user/downloadExcel">导出表格</a>
    </div>
</form>

<table id="list2"></table>
<div id="pager2"></div>
