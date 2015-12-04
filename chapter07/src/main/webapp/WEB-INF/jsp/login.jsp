<%--
  Created by IntelliJ IDEA.
  User: wb-chenchaobin
  Date: 2015/12/3
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登入</title>
</head>
<body>
    <form method="post" action="login">
       用户名： <input name="username"><br>
       密码： <input name="password"><br>
        <input type="submit" value="登入"/>
    </form>
    <div name="error">${error}</div>
</body>
</html>
