<%--
  Created by IntelliJ IDEA.
  User: ronkzoo
  Date: 2015. 7. 24.
  Time: 오후 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <title><tiles:insertAttribute name="title"/></title>
    <tiles:insertAttribute name="head"/>

</head>
<body>
    <tiles:insertAttribute name="top"/>
    <tiles:insertAttribute name="left"/>

    <div class="container">
        <tiles:insertAttribute name="contents"/>
    </div>
    <tiles:insertAttribute name="bottom"/>
</body>
</html>
