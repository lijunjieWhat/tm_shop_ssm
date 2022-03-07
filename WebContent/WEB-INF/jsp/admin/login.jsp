<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2019/1/20
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理系统</title>
         <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
     <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/back/style.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script>
        $(function () {
        	 $("#loginForm").submit(function () {
                 if (0 == $("#name").val().length || 0 == $("#password").val().length) {
                     $("#msg").html("请输入账号密码");
                     return false;
                 }
                 return true;
             });
        })
    </script>

    <style>
        #adminlogin{
            background: #93defe;
        }
    </style>
</head>
<body>
<div class="login_box">
    <div class="login_l_img">
        <img src="/img/login-img.png" />
    </div>

    <div class="login">

        <div class="login_logo">
            <a href="#"><img src="/img/login_logo.png" /></a>
        </div>

        <div class="login_name">
            <p>后台管理系统</p>
        </div>

        <form id="loginForm" action="loginCheck.action" method="post">
            <input id="name" name="name" type="text" placeholder="用户名"/>
            <input name="password" type="password" id="password" placeholder="密码"/>
            <input value="登录" id="adminlogin"  type="submit" style="width:100%; height:40px  "/>
        </form>
        <div style="color: red" id="msg">${msg}</div>

    </div>

    <div class="copyright">天猫 版权所有©2020 技术支持电话：000-00000000</div>
</div>


</body>
</html>
