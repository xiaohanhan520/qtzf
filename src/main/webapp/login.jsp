<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2019-09-06
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>嘉汇后台管理系统</title>
<script>
    function fm(){
        $.ajax({
            url:"${pageContext.request.contextPath}/admin/login",
            type:"post",
            data:$("#login-form").serialize(),
            success:function(data){
                if(data.code == 200){
                    location.href="./jsp/main.jsp"
                }else {
                    $("#message").text(data.message);
                   /* $("#message").text(${sessionScope.message})*/
                }
            }
        })
    }
</script>
    <style type="text/css">
        body {
            color:#999;
            background:url('./img/loginbg.jpg');
            background-size:cover;
        }
        a {
            color:#fff;
        }
        .login-screen {
            max-width:400px;
            padding:0;
            margin:100px auto 0 auto;

        }
        .login-screen .well {
            border-radius: 3px;
            -webkit-box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background: rgba(255,255,255, 0.2);
        }
        .login-screen .copyright {
            text-align: center;
        }
        @media(max-width:767px) {
            .login-screen {
                padding:0 20px;
            }
        }
        .profile-img-card {
            width: 100px;
            height: 100px;
            margin: 10px auto;
            display: block;
            -moz-border-radius: 50%;
            -webkit-border-radius: 50%;
            border-radius: 50%;
        }
        .profile-name-card {
            text-align: center;
        }

        #login-form {
            margin-top:20px;
        }
        #login-form .input-group {
            margin-bottom:15px;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div class="login-screen">
            <div class="well">
                <div class="login-form">
                    <img id="profile-img" class="profile-img-card" src="./img/avatar.png" />
                    <p id="profile-name" class="profile-name-card"></p>
                    <h4><span id="message" style="color: red"></span></h4>
                    <form action="javascript:void(0)" method="post" id="login-form">

                        <div class="input-group">

                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        </div>
                        <input type="text" class="form-control"  placeholder="用户名" name="username" />
                    </div>

                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                            </div>
                            <input type="password" class="form-control"  placeholder="密码" name="password"/>
                        </div>

                        <div class="form-group">
                            <input type="submit" class="btn btn-success btn-lg btn-block" onclick="fm()" value="登录" />
                        </div>
                    </form>
                </div>
            </div>

            <p class="copyright"><a href="#">@嘉汇支付</a></p>
        </div>
    </div>
</div>


</body>
</html>
