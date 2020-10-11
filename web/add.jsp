<%@ page import="com.cs.service.impl.UserServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/10
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="UserServlet?comm=doadd" method="post">
        <%
            UserServiceImpl userService=new UserServiceImpl();
            int index=userService.findByCountUser()+1;
        %>
        编号<input type="tel" name="userId" readonly value="<%=index%>">
        名称<input type="text" name="username"><br>
        密码<input type="text" name="password"><br>
        性别<input type="text" name="sex"><br>
        出生日期（年-月-日）<input type="text" name="date"><br>
        头像<input type="file" name="pic"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
