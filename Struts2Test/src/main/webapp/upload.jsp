<%--
  Created by IntelliJ IDEA.
  User: wb-chenchaobin
  Date: 2015/12/8
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <form action="upload" method="post" enctype="multipart/form-data">
    <label for="upload">上传图片</label><br>
    <input name="myFile" type="file" id="upload"><br>
    <input type="submit" value="上传">
  </form>

</body>
</html>
