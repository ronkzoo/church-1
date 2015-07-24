<%@ page import="java.util.Calendar" %>
<%--
  Created by IntelliJ IDEA.
  User: com
  Date: 2015. 7. 18.
  Time: 오후 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <title>HelloWorld</title>
    <script src="<c:url value="/resources/gumby2/js/main.js" />"></script>
</head>
<body>

<table border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td align="center">
            <a href="/${route}/${calendar.prevYear}/${calendar.prevMonth}">◁</a>
            ${calendar.curYear}년 ${calendar.curMonth}월
            <a href="/${route}/${calendar.nextYear}/${calendar.nextMonth}">▷</a></td>
    </tr>
    <tr>
        <td>

            <table border="1">
                <tr>
                    <td>일</td>
                    <td>월</td>
                    <td>화</td>
                    <td>수</td>
                    <td>목</td>
                    <td>금</td>
                    <td>토</td>
                </tr>
                <tr>
                    <c:forEach begin="1" end="${calendar.bgnWeek - 1}" var="item" varStatus="status">
                       <td>&nbsp;</td>
                    </c:forEach>
                    <c:set var="loopIndex" value="${calendar.bgnWeek - 1}"/>
                    <c:forEach begin="1" end="${calendar.lastDay}" var="item"  varStatus="status">
                        <c:set var="loopIndex" value="${loopIndex + 1}"/>
                        <td> ${status.index} </td>
                        <c:if test="${loopIndex % 7 == 0}">
                 </tr>
                 <tr>
                        </c:if>
                    </c:forEach>
            </table>

        </td>
    </tr>
</table>
</body>
</html>
