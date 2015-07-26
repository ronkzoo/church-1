<%--
  Created by IntelliJ IDEA.
  User: ronkzoo
  Date: 2015. 7. 25.
  Time: 오후 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row navbar pretty" id="nav1">
    <!-- Toggle for mobile navigation, targeting the <ul> -->
    <a class="toggle" gumby-trigger="#nav1 > ul" href="#"><i class="icon-menu"></i></a>

    <h1 class="four columns logo">
        <a href="#">
            <img src="/gumby2/img/gumby_mainlogo.png" gumby-retina/>
        </a>
    </h1>
    <ul class="eight columns">
        <li><a href="#">Features</a></li>
        <li>
            <a href="#">개발항목</a>
            <div class="dropdown">
                <ul>
                    <li><a href="/test/prop" about="prop Test">spEl Test</a></li>
                    <li><a href="/a/b">공통 게시판</a></li>
                    <li><a href="/member/login">로그인</a></li>
                    <li><a href="/upload">파일업로드</a></li>
                    <li><a href="/hello/list">JSON TEST</a></li>
                    <li><a href="/jodaCalendar">Calendar</a></li>
                </ul>
            </div>
        </li>
        <li><a href="#">Customize</a></li>
    </ul>
</div>
