<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/10
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

%>
    <table>
        <tr>
            <td>用户编号</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td>用户姓名</td>
            <td>${user.username}</td>
        </tr>
        <tr>
            <td>用户密码</td>
            <td>${user.password}</td>
        </tr>
        <tr>
            <td>性别</td>
            <td>${user.sex}</td>
        </tr>
        <tr>
            <td>出生日期</td>
            <td>${user.bornDate}</td>
        </tr>
        <tr>
            <td>用户头像</td>
            <td>${user.userpic}</td>
        </tr>
    </table>
</body>
</html>
