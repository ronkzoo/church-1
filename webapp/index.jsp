<%--
  Created by IntelliJ IDEA.
  User: ronkzoo
  Date: 2015. 7. 24.
  Time: 오후 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"              prefix="c"	    %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"         prefix="fn"     %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"               prefix="fmt"    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"             prefix="tiles"  %>
<%@ taglib uri="http://www.springframework.org/tags"            prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"   prefix="sec"    %>
<!DOCTYPE html>
<html lang="${config.language}">
<head>
	<meta charset="utf-8">
	<title>영도복음교회</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<link rel="shortcut icon" href="favicon.png" type="image/x-icon" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
	<link rel="stylesheet" href="/gumby2/css/gumby.css">
	<script src="/gumby2/js/libs/modernizr-2.6.2.min.js"></script>

</head>
<body>

    <!-- Grab Google CDN's jQuery, fall back to local if offline -->
    <!-- 2.0 for modern browsers, 1.10 for .oldie -->
    <script>
        var oldieCheck = Boolean(document.getElementsByTagName('html')[0].className.match(/\soldie\s/g));
        if(!oldieCheck) {
            document.write('<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"><\/script>');
        } else {
            document.write('<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"><\/script>');
        }
    </script>
    <script>
        if(!window.jQuery) {
            if(!oldieCheck) {
                document.write('<script src="/gumby2/js/libs/jquery-2.0.2.min.js"><\/script>');
            } else {
                document.write('<script src="/gumby2/js/libs/jquery-1.10.1.min.js"><\/script>');
            }
        }
    </script>

	<script gumby-touch="/gumby2/js/libs" src="/gumby2/js/libs/gumby.js"></script>
	<script src="/gumby2/js/libs/ui/gumby.retina.js"></script>
	<script src="/gumby2/js/libs/ui/gumby.fixed.js"></script>
	<script src="/gumby2/js/libs/ui/gumby.skiplink.js"></script>
	<script src="/gumby2/js/libs/ui/gumby.toggleswitch.js"></script>
	<script src="/gumby2/js/libs/ui/gumby.checkbox.js"></script>
	<script src="/gumby2/js/libs/ui/gumby.radiobtn.js"></script>
	<script src="/gumby2/js/libs/ui/gumby.tabs.js"></script>
	<script src="/gumby2/js/libs/ui/gumby.navbar.js"></script>
	<script src="/gumby2/js/libs/ui/jquery.validation.js"></script>
	<script src="/gumby2/js/libs/gumby.init.js"></script>
	<script src="/gumby2/js/plugins.js"></script>
	<script src="/gumby2/js/main.js"></script>

<div class="row navbar pretty" id="nav1">
	<!-- Toggle for mobile navigation, targeting the <ul> -->
	<a class="toggle" gumby-trigger="#nav1 > ul" href="#"><i class="icon-menu"></i></a>
	<h1 class="four columns logo">
		<a href="#">
			<img src="/gumby2/img/gumby_mainlogo.png" gumby-retina />
		</a>
	</h1>
	<ul class="eight columns">
		<li><a href="#">Features</a></li>
		<li>
			<a href="#">Documentation</a>
			<div class="dropdown">
				<ul>
					<li><a href="#">The Grid</a></li>
					<li><a href="#">UI Kit</a></li>
					<li><a href="#">Sass</a></li>
					<li><a href="#">JavaScript</a></li>
					<li><a href="#">Demo</a></li>
				</ul>
			</div>
		</li>
		<li><a href="#">Customize</a></li>
	</ul>
</div>

</body>
</html>
