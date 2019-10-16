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
        //页面加载完成之后执行
        pageInit();
    });
    function pageInit(){
        //创建jqGrid组件
        jQuery("#list2").jqGrid(
            {
                url : '${pageContext.request.contextPath}/user/all',
                datatype : "json",//请求数据返回的类型。可选json,xml,txt
                colNames : ['编号','状态','创建日期','操作'],
                colModel : [
                    {name : 'id'},
                    {name : 'personalSign'},
                    {name : 'profile',edittype:"file",formatter:function(cellvalue, options, rowObject){
                            return "<img style='width:100px;height:60px' src='${pageContext.request.contextPath}/headPortrait/"+cellvalue+"'/>";
                        }},
                    {formatter:function (cellvalue, options, rowObject) {
                            return "<button class='btn btn-info'  onclick='modify(\""+rowObject["id"]+"\",\""+rowObject["status"]+"\")'>修改</button>";
                        }}
                ],
                rownumbers: true,
                rowNum : 5,//一页显示多少条
                rowList : [5, 10,15, 20],//可供用户选择一页显示多少条
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

<div class="tab-content tab-addtabs">
    <div id="content">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                <section class="content-header hide">
                    <h1>
                        我的提现
                    </h1>
                </section>
                <!-- END RIBBON -->
                <div class="content">
                    <div class="panel panel-default panel-intro">
                        <div class="panel-heading">
                            <div class="panel-lead">我的提现</div>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <table id="list2"></table>
                                <div id="pager2"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>




