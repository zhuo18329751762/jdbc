<%--
  Created by IntelliJ IDEA.
  User: 卓阳阳
  Date: 2023/3/19
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>hello jsp</h1>

    <!--     第一种脚本
    内容直接放到_jspService方法之中
    -->
    <%
        System.out.println("hello jsp");
        int i=3;
    %>

    <!--     第二种脚本
    内容会放到out.print()中，作为out.print()的参数
    -->
    <%="hello"%>
    <%=i%>

    <!--     第三种脚本
    内容会放到_jspService()方法之外，被类直接包含
    -->
    <%!
        void show(){}
        String name="zhangsan";
    %>
</body>
</html>
