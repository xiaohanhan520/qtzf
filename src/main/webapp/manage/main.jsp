<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!doctype html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jqGrid/css/ui.jqgrid.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jqGrid/css/ui.jqgrid-bootstrap-ui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jqGrid/js/jquery.jqGrid.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jqGrid/js/i18n/grid.locale-cn.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <title>嘉汇管理系统</title>

</head>
<body>

<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="">嘉汇管理系统<small>V1.0</small></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="javascript:void(0)">欢迎:<shiro:principal/> <span class="glyphicon glyphicon-user"></span></a></li>
                        <li class="dropdown"><a href="${pageContext.request.contextPath}/admin/out">退出登录</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div class="container-fluid">
            <div class="col-sm-2">
                <div class="row">
                    <div class="panel-group" id="accordion">

                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                        控制台
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li role="presentation"><a href="javascript:$('#pictureManagement').load('con.jsp')">控制台</a></li>
                                        <li role="presentation"><a href="javascript:$('#pictureManagement').load('routine.jsp')">常规管理</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion"
                                       href="#collapseTwo">
                                        用户管理
                                    </a>
                                </h4>
                            </div>

                            <div id="collapseTwo" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="javascript:$('#pictureManagement').load('myCash.jsp')">我的提现</a></li>
                                        <li><a href="javascript:$('#pictureManagement').load('2.jsp')">代理信息</a></li>
                                        <li><a href="javascript:$('#pictureManagement').load('2.jsp')">业务员信息</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion"
                                       href="#collapseSix">
                                        提现管理
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseSix" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="javascript:$('#pictureManagement').load('2.jsp')">全部</a></li>
                                        <li><a href="javascript:$('#pictureManagement').load('2.jsp')">未审核</a></li>
                                        <li><a href="javascript:$('#pictureManagement').load('2.jsp')">已审核</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>






                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                                        订单管理
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseThree" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="javascript:$('#pictureManagement').load('4.jsp')">全部</a></li>
                                        <li><a href="javascript:$('#pictureManagement').load('5.jsp')">未支付</a></li>
                                        <li><a href="javascript:$('#pictureManagement').load('6.jsp')">以支付</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion"
                                       href="#collapseFive">
                                        商家管理
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseFive" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="javascript:$('#pictureManagement').load('7.jsp')">商家信息</a></li>
                                        <li><a href="javascript:$('#pictureManagement').load('7.jsp')">审核管理</a></li>
                                        <li><a href="javascript:$('#pictureManagement').load('7.jsp')">商家信息</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion"
                                       href="#collapseFour">
                                        收支明细
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseFour" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="javascript:$('#pictureManagement').load('6.jsp')">用户管理</a></li>
                                        <li><a href="javascript:$('#pictureManagement').load('7.jsp')">离职用户</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
            </div>

                <div class="col-sm-10" id="pictureManagement">

                    <div class="jumbotron">
                        <h2>欢迎来到嘉汇管理系统</h2>
                    </div>

                </div>


        </div>
            <nav class="navbar navbar-default navbar-fixed-bottom">
                <div class="container text-center"><br>
                    @嘉汇管理系统<br><br>
                </div>
            </nav>
        </div>

     </div>
  </div>
</div>
</body>
</html>