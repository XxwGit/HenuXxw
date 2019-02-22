<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>javaweb大作业</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<link href="../css/snow.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
<style>
	.wh_font{color:white;}
	tr td:first{text-align: center;}
	.rule{vertical-align: middle;}
	.Textarea{margin-top: 30px; padding: 10px; width:300px; height: 150px; font-size: 20px;}
	button{margin:20px auto; width:150px; height: 40px; color:white; font-size:15px; background-color:#03134E; border:none;}
</style>
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
<a href="../Login.jsp" >管理员登录</a><a href="Vote.jsp" class="active">创建投票</a><a href="../Result.jsp">投票结果</a><a href="../Quit.jsp" >退出</a>
</div>
<h1>创建投票</h1>
<div class="main-agileits">
	<div class="form-w3-agile">
		<form action="/user/createVote.do" method="post">
			<table>
				<tr>
					<td class="wh_font">投票名称</td>
					<td><input type="text" name="voteName" /> </td>
				</tr>
				<tr>
					<td class="wh_font">投票时间</td>
					<td><input type="date" name="startTime" /><span class="wh_font">--</span><input type="date" name="endTime" /></td>
				</tr>
				<tr>
					<td class="wh_font rule">投票描述</td>
					<td><textarea class="Textarea"name="voteDescription" ></textarea></td>
				</tr>
			</table>
			<div class="submit-w3l">
				<input type="submit" value="下一步">
			</div>
		</form>

	</div>
</div>
	<!-- //copyright --> 
	<script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>

</body>
</html>