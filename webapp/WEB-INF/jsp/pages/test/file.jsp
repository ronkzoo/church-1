<%--
  Created by IntelliJ IDEA.
  User: LeeRyu
  Date: 2015-07-28
  Time: 오후 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div><h1>FILE TEST</h1></div>
    <form action="${pageContext.request.contextPath}/mngr/file-act" method="post" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="submit" value="submit" />
    </form>
    <footer>
    </footer>
</body>
</html>
