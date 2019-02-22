<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>javaweb大作业</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Custom Theme files -->
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/snow.css" rel="stylesheet" type="text/css" media="all" />
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>

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

            <div class="row" >
                <div class="col-xs-12 col-sm-12 " >
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5 style="color: white">添加子选项</h5>
                        </div>

                        <div class="ibox-content">
                            <form action="/user/InsertVoteItemBefore.do" method="post" id="addVoteItem" name="addVoteItem">
                                <div class="form-group">
                                    <label for="Account" class="sr-only">用户名</label>
                                    <input type="text" placeholder="请输入选项名字" id="Account" name="voteItemName" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="BianHao" class="sr-only">工号</label>
                                    <input type="text" placeholder="请输入选项描述" id="BianHao" name="voteItemDescription" class="form-control">
                                </div>
                                <div class="submit-w3l">
                                    <%--<<input type="submit" value="添加选项">--%>
                                    <button onclick="a()">添加选项</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h1 style="color: white">选项列表</h1>
                        </div>
                        <div class="ibox-content">
                            <table class="table table-striped">
                                <thead>
                                <tr style="color: white">
                                    <th>选项名字</th>
                                    <th>选项描述</th>
                                    <th>投票id</th>
                                </tr>
                                </thead>

                                <tbody style="color: white;background: #ffffff">
                                <c:choose>
                                    <c:when test="${ list!= null}">
                                        <c:forEach var="item" items="${list}">
                                            <tr>
                                                <td style="background: black">${item.name}</td>
                                                <td style="background: black">${item.description}</td>
                                                <td style="background: black">${item.parent}</td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise >
                                        <h2 style="color: white">暂无选项，请添加!</h2>
                                    </c:otherwise>
                                </c:choose>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
    </div>

</div>
</body>

<script type="text/javascript">

    function a() {

        $.post("/user/newvoteItem.do",$("#addVoteItem").serialize(),function (data) {
            alert(data.code);
            if (data.code==1){
                alert("添加成功");
                $("#addVoteItem").submit();
                window.location.reload();
            }else{
                alert("添加失败");
            }
        });
    }
    function addItem() {
        alert("开始添加")
        
        $.post("/user/newvoteItem.do",function (data) {
            alert(data.code);
            if (data.code==1){
                alert("添加成功");
                $("#addVoteItem").submit();
                window.location.reload();
            }else{
                alert("添加失败");
            }
        });
    }
</script>
</html>