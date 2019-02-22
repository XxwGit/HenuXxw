<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="/images/faivon.png" />

    <title>欢迎投票</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="//fonts.googleapis.com/css?family=Ubuntu:300,400,500,700" rel="stylesheet">
    <link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link href="css/font-awesome.css" rel="stylesheet"> <!-- Font-awesome-CSS -->
    <link href="css/styleeee.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/bootstrap.css" type="text/css"/>
    <script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
    <script src="js/jquery-2.1.4.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="css/raccordion.css" />
    <script type="text/javascript">
        $(window).load(function () {
            $('#accordion-wrapper').raccordion({
                speed: 1000,
                sliderWidth: 700,
                sliderHeight: 300,
                autoCollapse: false
            });
            cip = returnCitySN["cip"];
            cname = returnCitySN["cname"]
            $("#cip").val(cip)
            $("#cname").val(cname)
        });
        function vote() {
            var name = $("#name").val()
            $(location).attr('href','/show.do?name='+name);
        }
    </script>
</head>
<body>
<div class="content" id="Main-Content" >
    <h1>${pd.vote.name}</h1>
    <div class="wrapper">
        <div id="accordion-wrapper">
            <div class="slide">
                <img src="images/1.jpg" alt="image" />
                <div class="caption">
                    <div class="pricing">
                        <div class="pricing-top green-top">
                            <i class="fa fa-check-square-o" aria-hidden="true"></i>
                        </div>
                        <div class="pricing-bottom">
                            <div class="pricing-bottom-bottom">
                                <h2>请为他们投上一票吧！</h2>
                                <p>${pd.vote.description}</p>
                            </div>
                            <div class="buy-button green-button">
                                <ul>
                                    <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                </ul>
                            </div>
                            <div>
                                <p style="color: #ce8483">投票详情</p>
                                <img src="images/tt.png" onclick="vote()">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="slide slide-two-w3ls">
                <img src="images/3.jpg" alt="image" />
                <div class="caption">
                    <div class="pricing">
                        <div class="pricing-top blue-top">
                            <h3>开始投票</h3>
                        </div>
                        <div class="pricing-bottom two">
                            <div class="pricing-bottom-bottom">
                                <form action="/doVote.do" method="post">
                                    <input type="hidden" id="name" name="name" value="${pd.vote.name}">
                                    <input type="hidden" id="vote" name="vote" value="${pd.vote.id}">
                                    <input type="hidden" id="code" name="code" value="${pd.code}">
                                    <input type="hidden" id="cip" name="cip" >
                                    <input type="hidden" id="cname" name="cname" >
                                    <div class="content-wthree2">
                                        <div class="grid-w3layouts1">
                                            <div class="w3-agile1">
                                                <label class="rating">1星是1号呦</label>
                                                <ul>
                                                    <c:choose>
                                                        <c:when test="${pd.code == 1}">
                                                            <c:forEach var="item" items="${pd.voteItemList}" varStatus="i">
                                                                <li>
                                                                <input type="radio" id='option${i.index}' name="voteItem" value="${item.id}">
                                                                <label for='option${i.index}'>
                                                                    <h3>${item.name}</h3>
                                                                <%--<c:forEach begin="0" end="${i.index}">--%>
                                                                    <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                                <%--</c:forEach>--%>
                                                                </label>
                                                                <div class="check"></div>
                                                                </li>
                                                            </c:forEach>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <h2>服务器出错，请重新加载页面.......</h2>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <%--<li>--%>
                                                        <%--<input type="radio" id="a-option" name="selector1">--%>
                                                        <%--<label for="a-option">--%>
                                                            <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                        <%--</label>--%>
                                                        <%--<div class="check"></div>--%>
                                                    <%--</li>--%>
                                                    <%--<li>--%>
                                                        <%--<input type="radio" id="b-option" name="selector1">--%>
                                                        <%--<label for="b-option">--%>
                                                            <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                            <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                        <%--</label>--%>
                                                        <%--<div class="check"><div class="inside"></div></div>--%>
                                                    <%--</li>--%>
                                                    <%--<li>--%>
                                                        <%--<input type="radio" id="c-option" name="selector1">--%>
                                                        <%--<label for="c-option">--%>
                                                            <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                            <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                            <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                        <%--</label>--%>
                                                        <%--<div class="check"><div class="inside"></div></div>--%>
                                                    <%--</li>--%>
                                                    <%--<li>--%>
                                                        <%--<input type="radio" id="d-option" name="selector1">--%>
                                                        <%--<label for="d-option">--%>
                                                            <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                            <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                            <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                            <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                        <%--</label>--%>
                                                        <%--<div class="check"></div>--%>
                                                    <%--</li>--%>
                                                    <%--<li>--%>
                                                        <%--<input type="radio" id="e-option" name="selector1">--%>
                                                        <%--<label for="e-option">--%>
                                                            <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                            <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                            <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                            <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                            <%--<i class="fa fa-star-o" aria-hidden="true"></i>--%>
                                                        <%--</label>--%>
                                                        <%--<div class="check"></div>--%>
                                                    <%--</li>--%>
                                                </ul>
                                                <div class="clear"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <input type="submit" name="submit" value="投票">
                                    <button id="start" class="btn btn-warning" onclick="doVote()">投票</button>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--copyright-->
    <div class="w3ls-copyright">
        <p>© 2017 技术支持 伟哥的98k 随大大的7.62mm </p>
    </div>
</div>
<script src="js/jquery.raccordion.js" type="text/javascript"></script>
<script src="js/jquery.animation.easing.js" type="text/javascript"></script>
</body>
</html>
