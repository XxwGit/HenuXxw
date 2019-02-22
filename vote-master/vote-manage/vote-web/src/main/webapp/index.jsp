<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>javaweb大作业</title>
    <link rel="shortcut icon" type="image/x-icon" href="/images/faivon.png" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Custom Theme files -->
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/snow.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

</head>
<body>
<div class="snow-container">
    <div class="snow foreground"></div>
    <div class="snow foreground layered"></div>
    <div class="snow middleground"></div>
    <div class="snow middleground layered"></div>
    <div class="snow background"></div>
    <div class="snow background layered"></div>
</div>

<div class="top-buttons-agileinfo">
    <a href="Login.jsp" class="active">管理员登录</a><a href="user/Vote.jsp" >创建投票</a><a href="Result.jsp">投票结果</a><a href="Quit.jsp" >退出</a>
</div>
<h1>管理员登录</h1>
<div class="main-agileits">
    <!--form-stars-here-->
    <div class="form-w3-agile">
        <form action="/admin/login.do" method="post">
            <input type="text" name="username" placeholder="管理员" required="" />
            <input type="password" name="password" placeholder="密码" required="" />
            <div class="submit-w3l">
                <input type="submit" value="登录">

            </div>
        </form>
        <form action="/admin/newUser.do" method="post">
            <div class="submit-w3l">
                <input type="submit" value="注册">
            </div>
        </form>
    </div>
</div>

<div class="copyright w3-agile">
    <p>© 2017 Design By </p>
</div>

<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

</body>
</html>