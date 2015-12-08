<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/12/9
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
</head>
<body>
  <s:form action="emp" >
    <s:textfield name="username" label="username" size="20"/>
    <s:textfield name="age1" label="age1" size="20"/>
    <s:submit label="submit" align="center"/>
  </s:form>
</body>
</html>
