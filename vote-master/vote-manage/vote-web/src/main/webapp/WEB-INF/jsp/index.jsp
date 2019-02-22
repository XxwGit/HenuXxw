<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
</body>
<%
    String a = "1";
    String b = request.getContextPath();
    String c = request.getServletPath();
    StringBuffer d = request.getRequestURL();
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
%>
<form action="/get.do" method="get">
    <input type="submit" value="kkk">
</form>
</html>
