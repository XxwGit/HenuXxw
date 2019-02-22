<%--
  Created by IntelliJ IDEA.
  User: syl
  Date: 2017/12/15
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="/images/faivon.png" />
    <meta charset="utf-8">
    <title>投票结果</title>
    <!-- 引入 echarts.js -->
    <script src="../../js/echarts.js"></script>
    <script src="../../js/jquery-1.11.3.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<input type="hidden" name="name" id="name" value="${name}">
<div id="main" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    var map = new Array();
    goUpdate()
    function goUpdate(){

        var name =$("#name").val()
        try {
            var fut = 'a('+name+')'
            var time  = setInterval(fut,1000);
            window.map.push(time)
        }catch (err){
            window.clearInterval(window.map.pop())
        }
    }

    function a(name) {
        $.post("/getBollotJSON.do",{name:name},function (data) {
            if(data.pd.code == 1){
                var vote = data.pd.vote
                var voteItems = new Array();
                voteItems = data.pd.voteItemList;
                setVote(vote,voteItems)
            }else{
                throw 'error'
            }
        })
    }
    function xData(list) {
        var arry = new Array()
        for(i in list){
            arry[i] = list[i].name;
        }
        return arry
    }
    function yData(list) {
        var arry = new Array()
        for(i in list){
            arry[i] = list[i].ballot
        }
        return arry
    }

    function setVote(vote,list){
        var vv = document.getElementById("main")
        var myChart = echarts.init(vv);
        myChart.setOption({
            title: {
                text: vote.name
            },
            tooltip : {
//                trigger: 'axis',
//                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
//                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
//                },
//                formatter: function (params) {
//                    var tar = params[1];
//                    return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
//                }
            },
            legend: {
                data:['票数']
            },
            xAxis: {
                data:xData(list)
            },
            yAxis: {},
            series: [{
                name: '票数',
                type: 'bar',
                itemStyle : { normal: {label : {show: true}}},
                data: yData(list)
            }],

        });
    }
</script>
</body>

</html>