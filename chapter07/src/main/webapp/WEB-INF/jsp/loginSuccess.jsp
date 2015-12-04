<%--
  Created by IntelliJ IDEA.
  User: wb-chenchaobin
  Date: 2015/12/3
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登入成功</title>
</head>
<body>
${subject.principal}登入成功
<a href="${pageContext.request.contextPath}/logout">登出</a>
</body>
</html>
