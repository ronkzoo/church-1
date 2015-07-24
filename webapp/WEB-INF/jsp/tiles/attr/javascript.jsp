<%--
  Created by IntelliJ IDEA.
  User: ronkzoo
  Date: 2015. 7. 24.
  Time: 오후 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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