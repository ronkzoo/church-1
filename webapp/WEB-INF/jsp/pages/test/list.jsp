<%--
  Created by IntelliJ IDEA.
  User: LeeRyu
  Date: 2015-07-26
  Time: 오후 6:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<<<<<< HEAD
<div>
  ${paginationVo}
</div>
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>관리자</title>
    <link rel="stylesheet" href="/test/css/common.css"/>
    <link rel="stylesheet" href="/test/css/layout.css"/>
    <link rel="stylesheet" href="/test/css/sub.css"/>
</head>
<body>
<table border="0" cellpadding="0" cellspacing="0" class="list_table" summary="번호, 제목, 등록일, 조회, 첨부">
    <caption>모바일 통계 테이블</caption>
    <colgroup>
        <col style="width:10%">
        <col style="width:55%">
        <col style="width:15%">
        <col style="width:10%">
        <col style="width:10%">
    </colgroup>


    <thead>
    <tr>
        <th scope="col">번호</th>
        <th scope="col">제목</th>
        <th scope="col">등록일</th>
    </tr>
    </thead>

    <tbody class="bordernone">
    <c:forEach var="data" items="${bbsList}" varStatus="status">
        <c:set var="totalCnt" value=""/>
        <tr>
            <td><c:out value="${status.count}" /></td>
            <td class="subject">
                <a class="ellipsis" href="javascript:goBoardView('3694');">${data.boardTitle} </a>
            </td>
            <td>
                <c:out value="${data.registerDate}" escapeXml="false" />
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
>>>>>>> leeryu/master
