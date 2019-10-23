<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2019-10-23
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="cn">
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
    <!-- 网站标题 -->
    <title>覔亖甴愢丢的网站</title>
    <style type="text/css">
        .navbar{
            opacity: 0.5;
        }
        .page-header{
            opacity: 0.8;
        }
        nav.navbar.bootsnav{
            border: none;
            margin-bottom: 150px;
        }
        .navbar-nav{
            float: left;
        }
        nav.navbar.bootsnav ul.nav > li > a{
            color: #474747;
            text-transform: uppercase;
            padding: 30px;
        }
        nav.navbar.bootsnav ul.nav > li:hover{
            background: #f4f4f4;
        }
        .nav > li:after{
            content: "";
            width: 0;
            height: 5px;
            background: #34c9dd;
            position: absolute;
            bottom: 0;
            left: 0;
            transition: all 0.5s ease 0s;
        }
        .nav > li:hover:after{
            width: 100%;
        }
        nav.navbar.bootsnav ul.nav > li.dropdown > a.dropdown-toggle:after{
            content: "+";
            font-family: 'FontAwesome';
            font-size: 16px;
            font-weight: 500;
            position: absolute;
            top: 35%;
            right: 10%;
            transition: all 0.4s ease 0s;
        }
        nav.navbar.bootsnav ul.nav > li.dropdown.on > a.dropdown-toggle:after{
            content: "\f105";
            transform: rotate(90deg);
        }
        .dropdown-menu.multi-dropdown{
            position: absolute;
            left: -100% !important;
        }
        nav.navbar.bootsnav li.dropdown ul.dropdown-menu{
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            border: none;
        }
        @media only screen and (max-width:990px){
            nav.navbar.bootsnav ul.nav > li.dropdown > a.dropdown-toggle:after,
            nav.navbar.bootsnav ul.nav > li.dropdown.on > a.dropdown-toggle:after{ content: " "; }
            .dropdown-menu.multi-dropdown{ left: 0 !important; }
            nav.navbar.bootsnav ul.nav > li:hover{ background: transparent; }
            nav.navbar.bootsnav ul.nav > li > a{ margin: 0; }
        }



      /*  body {
            background-image: url("./img/banner.jpg");
            background-position: center 0;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
            -webkit-background-size: cover;
            -o-background-size: cover;
            -moz-background-size: cover;
            -ms-background-size: cover;
        }*/


    </style>
<body>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-4">
            <div class="page-header">
                <h1>覔亖甴愢丢的网站<small>欢迎你</small></h1>
            </div>
        </div>

        <div class="col-sm-8">
            <%--顶部导航栏--%>
            <nav class="navbar navbar-default  navbar-mobile bootsnav on navbar-right navbar-static-top" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                        <i class="fa fa-bars"></i>
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="navbar-menu">
                    <ul class="nav navbar-nav" data-in="fadeInDown" data-out="fadeOutUp">
                        <li><a href="#"><h4 style="color: #0f0f0f">主页</h4></a></li>
                        <li><a href="#">About Us</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Shortcodes</a>
                            <ul class="dropdown-menu animated">
                                <li><a href="#">Custom Menu</a></li>
                                <li><a href="#">Custom Menu</a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Sub Menu</a>
                                    <ul class="dropdown-menu animated">
                                        <li><a href="#">Custom Menu</a></li>
                                        <li><a href="#">Custom Menu</a></li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Sub Menu</a>
                                            <ul class="dropdown-menu multi-dropdown animated">
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Custom Menu</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">Custom Menu</a></li>
                                <li><a href="#">Custom Menu</a></li>
                                <li><a href="#">Custom Menu</a></li>
                                <li><a href="#">Custom Menu</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Pages</a>
                            <ul class="dropdown-menu animated">
                                <li><a href="#">Custom Menu</a></li>
                                <li><a href="#">Custom Menu</a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Sub Menu</a>
                                    <ul class="dropdown-menu animated">
                                        <li><a href="#">Custom Menu</a></li>
                                        <li><a href="#">Custom Menu</a></li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Sub Menu</a>
                                            <ul class="dropdown-menu multi-dropdown animated">
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Custom Menu</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">Custom Menu</a></li>
                                <li><a href="#">Custom Menu</a></li>
                                <li><a href="#">Custom Menu</a></li>
                                <li><a href="#">Custom Menu</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Portfolio</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                </div>
            </nav>
            </div>


        </div>
    </div>

<div class="row">
        <div class="col-md-2" align="center">
            sss
        </div>
        <div class="col-md-5" align="center">
            ss
        </div>
        <div class="col-md-5" align="center">
            s
        </div>

</div>
           <%--底部导航栏--%>
<div class="row " >
    <nav class="navbar navbar-default navbar-fixed-bottom">
        <ul class="nav nav-tabs nav-tabs-justified">
            <div class="row" align="center">
                <div class="col-md-4 col-sm-4 col-xs-4" align="center">

                    <li>
                        <div class="panel-body">
                            <a href="#">
                                Panel content1
                            </a>
                        </div>
                    </li>

                    <li>
                        <div class="panel-body">
                            <a href="#">
                                Panel content2
                            </a>
                        </div>
                    </li>

                    <li>
                        <div class="panel-body">
                            <a href="#">
                                Panel content3
                            </a>
                        </div>
                    </li>

                </div>

                <div class="col-md-4 col-sm-4 col-xs-4" align="center">
                    <li>
                        <div class="panel-body">
                            <a href="#">
                                Panel content1
                            </a>
                        </div>
                    </li>

                    <li>
                        <div class="panel-body">
                            <a href="#">
                                Panel content2
                            </a>
                        </div>
                    </li>


                    <li>
                        <div class="panel-body">
                            <a href="#">
                                Panel content3
                            </a>
                        </div>
                    </li>


                </div>

                <div class="col-md-4 col-sm-4 col-xs-4" align="center">
                    <li>
                        <div class="panel-body">
                            <a href="#">
                                Panel content1
                            </a>
                        </div>
                    </li>

                    <li>
                        <div class="panel-body">
                            <a href="#">
                                Panel content2
                            </a>
                        </div>
                    </li>


                    <li>
                        <div class="panel-body">
                            <a href="#">
                                Panel content3
                            </a>
                        </div>
                    </li>

                </div>
            </div>

        </ul>
    </nav>

</div>

</div>

</body>
</html>
