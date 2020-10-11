<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/10
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="UserServlet?id=${updateId}&comm=updateOne" method="post">
    编号<input type="tel" readonly name="userId" value="${updateId}"><br>
    名称<input type="text" name="username"><br>
    密码<input type="text" name="password"><br>
    性别<input type="text" name="sex"><br>
    出生日期（年-月-日）<input type="text" name="date"><br>
    头像<input type="file" name="pic"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
