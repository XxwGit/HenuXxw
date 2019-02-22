<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>javaweb大作业</title>
    <link rel="shortcut icon" type="image/x-icon" href="/images/faivon.png" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<link href="css/snow.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap-table.css"  type="text/css"  />
<link href="css/bootstrap.css" type="text/css" />
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap-table.js"></script>
</head>
<script>
    $(function(){
        $("#tb tbody tr:even").css("color","#3333ff");
        $("#tb tbody tr:odd").css("background","#99ffff");
        change()
    });
    window.operateEvents = {
        'click .RoleOfA': function (e, value, row, index) {
            voteS(row.name)
        },
        'click .RoleOfB': function (e, value, row, index) {
            look(row.name)
        }
    }
    function voteS(name) {
        $(location).attr('href', '/show.do?name='+name);

    }
	function look(name) {
        $(location).attr('href', '/createEWM.do?url=vote.do?name='+name);

    }
    function operateFormatter(value, row, index) {
        return [
            '<button type="button" class="RoleOfA btn-danger btn-default" style="margin-right:15px;">查看投票</button>',
            '<button type="button" class="RoleOfB btn btn-default " >生成投票</button>'
        ].join('');
    }

    function change() {
        $("#re").css({color:"#e95799"})
    }
</script>
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
<a href="Login.jsp" >管理员登录</a><a href="user/Vote.jsp" >创建投票</a><a href="Result.jsp" class="active">投票结果</a><a href="Quit.jsp" >退出</a>
</div>
<h1>投票结果</h1>

<div class="main-agileits">
<div class="form-w3-agile">
<table id="re" data-toggle="table" data-url="/getlist.do" data-height="300" data-striped="true">
<thead>
<tr>
<th data-field="id" >编号</th>
<th data-field="name">名称</th>
<th data-field="enable">是否可用</th>
<th data-field="operate" title="查看投票情况" data-events="operateEvents" data-formatter="operateFormatter">查看投票情况</th>
</tr>
</thead>
</table>
</div>
</div>

<div class="copyright w3-agile" >
<p>© 2017 Design By </p>
</div>

</body>
</html>