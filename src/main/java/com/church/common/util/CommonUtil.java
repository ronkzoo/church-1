package com.church.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LeeRyu on 2015-07-28.
 * com.church.common.util
 */
public class CommonUtil {
    private static final Logger log = LoggerFactory.getLogger(CommonUtil.class);

    public static String getCommonReturnUrl(HttpServletRequest request)
        throws UnsupportedEncodingException {
        String param = "";
        String returnUrl = "";
        String serverUrl = "";
        String url = request.getRequestURI();
        for (Enumeration e = request.getParameterNames(); e.hasMoreElements();) {
            String key = (String) e.nextElement();
            String value = request.getParameter(key);
            if (e.hasMoreElements())
                param = param + key + "=" + value + "&";
            else {
                param = param + key + "=" + value;
            }
        }

        if ((request.getServerPort() == 80) || (request.getServerPort() == 443))
            serverUrl = request.getServerName();
        else {
            serverUrl = request.getServerName() + ":" + request.getServerPort();
        }

        if (param.length() > 0)
            returnUrl = URLEncoder.encode("http://" + serverUrl + url + "?" + param, "UTF-8");
        else {
            returnUrl = URLEncoder.encode("http://" + serverUrl + url, "UTF-8");
        }

        return returnUrl;
    }

    public static String getDate(Date date, String format) {
        if ((date == null) || (format == null)) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
        return sdf.format(date);
    }

    public static String getCurrentDate() {
        Date dateNow = Calendar.getInstance(new SimpleTimeZone(32400000, "KST")).getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        return formatter.format(dateNow);
    }

    public static String get7DayAgoDate() {
        Calendar cal = Calendar.getInstance(new SimpleTimeZone(32400000, "KST"));
        cal.add(5, -7);
        Date weekago = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        return formatter.format(weekago);
    }

    public static String getMonthAgoDate() {
        Calendar cal = Calendar.getInstance(new SimpleTimeZone(32400000, "KST"));
        cal.add(2, -1);
        Date monthago = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        return formatter.format(monthago);
    }

    public static String generateKey() {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        return String.valueOf(System.currentTimeMillis())
            + decimalFormat.format(Math.random() * 99.0D);
    }

    public static String getExtension(String extension) {
        String extensionType = "";
        try {
            int extensionIndex = extension.trim().indexOf(".");
            int extensionIndexs = extension.trim().lastIndexOf(".");
            if (extensionIndex > 0)
                extensionType = extension.substring(extensionIndexs, extension.length());
        } catch (Exception e) {
            extensionType = ".CommonUtil.Error";
        }
        return extensionType.toLowerCase();
    }

    public static String getPrimaryDomain(String serverName) {
        HashMap domainPros = messageProperties("");
        String totalDomains = ((String) domainPros.get("Globals.primaryNameWr")) + ","
            + ((String) domainPros.get("Globals.primaryNameKr1")) + ","
            + ((String) domainPros.get("Globals.primaryNameKr2")) + ","
            + ((String) domainPros.get("Globals.primaryNameKr3"));
        String krDomains = ((String) domainPros.get("Globals.primaryNameKr2")) + ","
            + ((String) domainPros.get("Globals.primaryNameKr3"));
        String domainName = "";
        String[] totalDomainsArr = totalDomains.split("[,]");
        String[] krDomainsArr = krDomains.split("[,]");
        if ((serverName != null) && (!(serverName.equals("")))) {
            for (int i = 0; i < totalDomainsArr.length; ++i) {
                if (serverName.indexOf(totalDomainsArr[i]) <= -1)
                    continue;
                int continueCnt = 0;
                for (int j = 0; j < krDomainsArr.length; ++j) {
                    if ((serverName.indexOf(krDomainsArr[j]) <= -1)
                        || (!(totalDomainsArr[i].equals(".kr"))))
                        continue;
                    ++continueCnt;
                }

                if (continueCnt > 0)
                    continue;
                log.debug("totalDomainsArr:" + totalDomainsArr[i]);
                int lastNum = serverName.indexOf(totalDomainsArr[i]);
                String startName = serverName.substring(0, lastNum);
                log.debug("startName:" + startName);
                int middleNum = startName.lastIndexOf(".");

                log.debug("middleNum:" + middleNum);
                log.debug("lastNum:" + lastNum);
                domainName = serverName.substring(middleNum + 1, lastNum) + totalDomainsArr[i];
                log.debug("domainName:" + domainName);

                return domainName;
            }

        }

        return domainName;
    }

    public static HashMap messageProperties(String baseName) {
        HashMap events = new HashMap();
        ResourceBundle resourcebundle = null;
        try {
            if ((baseName == null) || ("".equals(baseName)))
                resourcebundle = ResourceBundle.getBundle("egovframework.message.key-common");
            else {
                resourcebundle = ResourceBundle.getBundle(baseName);
            }

            Enumeration enumeration = resourcebundle.getKeys();
            while (enumeration.hasMoreElements()) {
                String bkey = (String) enumeration.nextElement();

                events.put(bkey, resourcebundle.getString(bkey));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return events;
    }

    public static String getCookieObject(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if ((cookies == null) || (cookies.length == 0)) {
            return "";
        }

        for (int i = 0; i < cookies.length; ++i) {
            if (cookieName.equals(cookies[i].getName())) {
                return cookies[i].getValue();
            }
        }
        return "";
    }

    public static String checkCrossAttackTextArea(String str) {
        log.info("---- checkCrossAttackTextArea start ---------");
        if (str == null)
            return "";

        String str_low = "";
        str_low = str.toLowerCase();

        if ((str_low.contains("javascript")) || (str_low.contains("script"))
            || (str_low.contains("iframe")) || (str_low.contains("document"))
            || (str_low.contains("vbscript")) || (str_low.contains("applet"))
            || (str_low.contains("embed")) || (str_low.contains("<object"))
            || (str_low.contains("frame")) || (str_low.contains("grameset"))
            || (str_low.contains("layer")) || (str_low.contains("bgsound"))
            || (str_low.contains("alert")) || (str_low.contains("onblur"))
            || (str_low.contains("onchange")) || (str_low.contains("onclick"))
            || (str_low.contains("ondblclick")) || (str_low.contains("enerror"))
            || (str_low.contains("onerror")) || (str_low.contains("eval"))
            || (str_low.contains("onfocus")) || (str_low.contains("onload"))
            || (str_low.contains("onmouse")) || (str_low.contains("onscroll"))
            || (str_low.contains("onsubmit")) || (str_low.contains("onunload"))
            || (str_low.contains("<meta")) || (str_low.contains("onrowsinserted"))
            || (str_low.contains("innerhtml")) || (str_low.contains("ondataavailable"))
            || (str_low.contains("oncopy")) || (str_low.contains("onactivae"))
            || (str_low.contains("expression")) || (str_low.contains("charset"))
            || (str_low.contains("onafterprint")) || (str_low.contains("oncut"))
            || (str_low.contains("onafterupdate")) || (str_low.contains("onkeydown"))
            || (str_low.contains("xml")) || (str_low.contains("onbeforeactivate"))
            || (str_low.contains("onbeforecut")) || (str_low.contains("onkeyup"))
            || (str_low.contains("blink")) || (str_low.contains("onbeforecopy"))
            || (str_low.contains("ondatasetchanged")) || (str_low.contains("ondeactivate"))
            || (str_low.contains("onbeforedeactivate")) || (str_low.contains("ondrag"))
            || (str_low.contains("msgbox")) || (str_low.contains("onbeforeeditfocus"))
            || (str_low.contains("cookie")) || (str_low.contains("onpropertychange"))
            || (str_low.contains("ondrop")) || (str_low.contains("ondatasetcomplete"))
            || (str_low.contains("void")) || (str_low.contains("oncellchange"))
            || (str_low.contains("onlayoutcomplete")) || (str_low.contains("onfilterchange"))
            || (str_low.contains("onabort")) || (str_low.contains("onpaste"))
            || (str_low.contains("onfinish")) || (str_low.contains("onstart"))
            || (str_low.contains("oncontextmenu")) || (str_low.contains("onreset"))
            || (str_low.contains("onresize")) || (str_low.contains("oncontrolselect"))
            || (str_low.contains("onmove")) || (str_low.contains("onrowexit"))
            || (str_low.contains("onreadystatechage")) || (str_low.contains("onstop"))
            || (str_low.contains("onselect"))) {
            str = str_low;

            str = str.replaceAll("javascript", "x-javascript");
            str = str.replaceAll("script", "x-script");
            str = str.replaceAll("iframe", "x-iframe");
            str = str.replaceAll("document", "x-document");
            str = str.replaceAll("vbscript", "x-vbscript");
            str = str.replaceAll("applet", "x-applet");
            str = str.replaceAll("embed", "x-embed");
            str = str.replaceAll("<object", "<x-object");
            str = str.replaceAll("frame", "x-frame");
            str = str.replaceAll("grameset", "x-grameset");
            str = str.replaceAll("layer", "x-layer");
            str = str.replaceAll("bgsound", "x-bgsound");
            str = str.replaceAll("alert", "x-alert");
            str = str.replaceAll("onblur", "x-onblur");
            str = str.replaceAll("onchange", "x-onchange");
            str = str.replaceAll("onclick", "x-onclick");
            str = str.replaceAll("ondblclick", "x-ondblclick");
            str = str.replaceAll("enerror", "x-enerror");
            str = str.replaceAll("onerror", "x-onerror");
            str = str.replaceAll("eval", "x-eval");
            str = str.replaceAll("onfocus", "x-onfocus");
            str = str.replaceAll("onload", "x-onload");
            str = str.replaceAll("onmouse", "x-onmouse");
            str = str.replaceAll("onscroll", "x-onscroll");
            str = str.replaceAll("onsubmit", "x-onsubmit");
            str = str.replaceAll("onunload", "x-onunload");
            str = str.replaceAll("meta", "x-meta");

            str = str.replaceAll("onrowsinserted", "x-onrowsinserted");
            str = str.replaceAll("innerhtml", "x-innerhtml");
            str = str.replaceAll("ondataavailable", "x-ondataavailable");
            str = str.replaceAll("oncopy", "x-oncopy");
            str = str.replaceAll("onactivae", "x-onactivae");
            str = str.replaceAll("expression", "x-expression");
            str = str.replaceAll("charset", "x-charset");
            str = str.replaceAll("onafterprint", "x-onafterprint");
            str = str.replaceAll("oncut", "x-oncut");
            str = str.replaceAll("onafterupdate", "x-onafterupdate");
            str = str.replaceAll("onkeydown", "x-onkeydown");
            str = str.replaceAll("xml", "x-xml");
            str = str.replaceAll("onbeforeactivate", "x-onbeforeactivate");
            str = str.replaceAll("onbeforecut", "x-onbeforecut");
            str = str.replaceAll("onkeyup", "x-onkeyup");
            str = str.replaceAll("blink", "x-blink");
            str = str.replaceAll("onbeforecopy", "x-onbeforecopy");
            str = str.replaceAll("ondatasetchanged", "x-ondatasetchanged");
            str = str.replaceAll("ondeactivate", "x-ondeactivate");
            str = str.replaceAll("onbeforedeactivate", "x-onbeforedeactivate");
            str = str.replaceAll("ondrag", "x-ondrag");
            str = str.replaceAll("msgbox", "x-msgbox");
            str = str.replaceAll("onbeforeeditfocus", "x-onbeforeeditfocus");
            str = str.replaceAll("cookie", "x-cookie");
            str = str.replaceAll("onpropertychange", "x-onpropertychange");
            str = str.replaceAll("ondrop", "x-ondrop");
            str = str.replaceAll("ondatasetcomplete", "x-ondatasetcomplete");
            str = str.replaceAll("void", "x-void");
            str = str.replaceAll("oncellchange", "x-oncellchange");
            str = str.replaceAll("onlayoutcomplete", "x-onlayoutcomplete");
            str = str.replaceAll("onfilterchange", "x-onfilterchange");
            str = str.replaceAll("onabort", "x-onabort");
            str = str.replaceAll("onpaste", "x-onpaste");
            str = str.replaceAll("onfinish", "x-onfinish");
            str = str.replaceAll("onstart", "x-onstart");
            str = str.replaceAll("oncontextmenu", "x-oncontextmenu");
            str = str.replaceAll("onreset", "x-onreset");
            str = str.replaceAll("onresize", "x-onresize");
            str = str.replaceAll("oncontrolselect", "x-oncontrolselect");
            str = str.replaceAll("onmove", "x-onmove");
            str = str.replaceAll("onrowexit", "x-onrowexit");
            str = str.replaceAll("onreadystatechage", "x-onreadystatechage");
            str = str.replaceAll("onstop", "x-onstop");
            str = str.replaceAll("onselect", "x-onselect");
        }
        log.info("---- checkCrossAttackTextArea end ---------:" + str);

        return str;
    }

    public static String checkCrossAttackTextField(String str) {
        log.info("---- checkCrossAttackTextField start ---------");
        if (str == null)
            return "";

        str = str.replaceAll("<", "&lt");
        str = str.replaceAll(">", "&gt");
        str = str.replaceAll("'", "");
        str = str.replaceAll(";", "");

        str = str.replaceAll("alert", "");
        str = str.replaceAll("\r\n", "<br>");
        str = str.replaceAll("--", "- -");
        str = str.replaceAll("'", "");
        str = str.replaceAll("\"", "");

        String str_low = "";

        log.info("---- checkCrossAttackTextField end ---------:" + str);
        return str;
    }

    public static String checkSQLinjectionAttack(String str) {
        log.info("---- checkSQLinjectionAttack start ---------");
        if (str == null)
            return "";

        str = str.replaceAll("<", "");
        str = str.replaceAll(">", "");
        str = str.replaceAll("'", "");
        str = str.replaceAll(";", "");
        str = str.replaceAll("\r\n", "");
        str = str.replaceAll("--", "");
        str = str.replaceAll("'", "");
        str = str.replaceAll("\"", "");
        str = str.replaceAll("#", "");
        str = str.replaceAll("\\(", "");
        str = str.replaceAll("\\)", "");
        str = str.replaceAll("=", "");
        str = str.replaceAll("\\+", "");
        str = str.replaceAll("|", "");
        str = str.replaceAll("&", "");
        str = str.replaceAll("%", "");
        str = str.replaceAll("CR", "");
        str = str.replaceAll("LF", "");
        str = str.replaceAll(",", "");
        str = str.replaceAll(";", "");

        String str_low = "";

        int strLength = str.length();
        if (strLength > 30)
            str = str.substring(0, 30);

        log.info("---- checkSQLinjectionAttack end ---------:" + str);
        return str;
    }

    public static String formatTime(long lTime) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(lTime);
        return c.get(11) + "시 " + c.get(12) + "분 " + c.get(13) + "." + c.get(14) + "초";
    }

    public static String parseHtmlText(String content) {
        if ((content == null) || ("".equals(content)))
            return "";

        Pattern tagPattern = Pattern.compile("\\<(\\/?)(\\w+)*([^<>]*)>");
        Matcher matcher = tagPattern.matcher(content);
        StringBuffer sb = new StringBuffer(content.length());
        while (matcher.find()) {
            log.info("--matcher.group()--:" + matcher.group());

            if (matcher.group().toLowerCase().indexOf("<br") > -1)
                matcher.appendReplacement(sb, matcher.group());
            else {
                matcher.appendReplacement(sb, "");
            }
        }

        matcher.appendTail(sb);

        String parsedText = sb.toString();
        parsedText = parsedText.replaceAll("&nbsp;", "");
        parsedText = parsedText.replaceAll("\n", "<BR/>");

        return parsedText;
    }

    public static String parseHtml(String content) {
        if ((content == null) || ("".equals(content)))
            return "";
        try {
            Pattern SCRIPTS = Pattern.compile("(<)(no)?(script)([^?]+)(.*)(<)(no)?(/script>)", 32);

            Pattern STYLE = Pattern.compile("<style[^>]*>.*</style>", 32);
            Pattern SELECT = Pattern.compile("<select[^>]*>.*</select>", 32);
            Pattern TAGS = Pattern.compile("<%[^<%]+.*%>", 32);
            Pattern STAGS = Pattern.compile("<(/)?s:.*(/)?>", 32);
            Pattern DOC = Pattern.compile("<!-{2,}.*?-{2,}>", 32);
            Pattern WHITESPACE = Pattern.compile("\\s\\s+");

            content = content.replaceAll("<%[^<][^%]+.*%>", "");

            Matcher m = STAGS.matcher(content);
            content = m.replaceAll("");

            m = DOC.matcher(content);
            content = m.replaceAll("");

            m = SCRIPTS.matcher(content);
            content = m.replaceAll("");

            m = STYLE.matcher(content);
            content = m.replaceAll("");

            m = SELECT.matcher(content);
            content = m.replaceAll("");

            m = WHITESPACE.matcher(content);
            content = m.replaceAll(" ");

            content = content.replaceAll("&nbsp;", " ");
        } catch (Exception localException) {
        }

        return content;
    }

    public static String removeTag(String s) {
        if (s == null) {
            return "";
        }
        int NORMAL_STATE = 0;
        int TAG_STATE = 1;
        int START_TAG_STATE = 2;
        int END_TAG_STATE = 3;
        int SINGLE_QUOT_STATE = 4;
        int DOUBLE_QUOT_STATE = 5;
        int state = 0;
        int oldState = 0;
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < chars.length; ++i) {
            char a = chars[i];
            switch (state) {
                case 0:
                    if (a == '<')
                        state = 1;
                    else
                        sb.append(a);
                    break;
                case 1:
                    if (a == '>') {
                        state = 0;
                    } else if (a == '"') {
                        oldState = state;
                        state = 5;
                    } else if (a == '\'') {
                        oldState = state;
                        state = 4;
                    } else if (a == '/') {
                        state = 3;
                    } else if ((a != ' ') && (a != '\t') && (a != '\n') && (a != '\r')
                        && (a != '\f')) {
                        state = 2;
                    }
                    break;
                case 2:
                case 3:
                    if (a == '>') {
                        state = 0;
                    } else if (a == '"') {
                        oldState = state;
                        state = 5;
                    } else if (a == '\'') {
                        oldState = state;
                        state = 4;
                    } else if (a == '"') {
                        state = 5;
                    } else if (a == '\'') {
                        state = 4;
                    }
                    break;
                case 5:
                    if (a == '"')
                        state = oldState;
                    break;
                case 4:
                    if (a == '\'') {
                        state = oldState;
                    }
            }
        }

        String result = sb.toString();

        result = result.replaceAll("&quot;", "\"");
        result = result.replaceAll("&lt;", "<");
        result = result.replaceAll("&gt;", ">");
        result = result.replaceAll("&middot;", "·");
        result = result.replaceAll("&lsquo;", "‘");
        result = result.replaceAll("&rsquo;", "’");

        result = result.replaceAll("\n", "");
        result = result.replaceAll("\r", "");

        return result;
    }

    public static String getRandomText(int textSize, int rmSeed) {
        String rmText = "";

        Random random = new Random(System.currentTimeMillis());
        int rmNum = 0;
        char ch = 'a';
        for (int i = 0; i < textSize; ++i) {
            random.setSeed(System.currentTimeMillis() * rmSeed * i + rmSeed + i);
            rmNum = random.nextInt(25);
            ch = (char) (ch + rmNum);
            rmText = rmText + ch;
            ch = 'a';
        }

        return rmText;
    }

    public static Boolean Upload_Filter(String fileName) {
        String file_ext = fileName.substring(fileName.lastIndexOf(46) + 1).toLowerCase();

        Boolean result = Boolean.valueOf(true);

        String[] bad_ext = {"php3", "php4", "asp", "jsp", "php", "html", "htm", "inc", "js", "pl",
            "cgi", "java", "exe"};

        for (int i = 0; i < bad_ext.length; ++i) {
            if (bad_ext[i].equals(file_ext)) {
                return Boolean.valueOf(false);
            }
        }
        if (fileName.contains(";")) {
            return Boolean.valueOf(false);
        }

        if (file_ext.length() == 0) {
            return Boolean.valueOf(false);
        }

        if (fileName.contains("..")) {
            return Boolean.valueOf(false);
        }
        if (fileName == null) {
            return Boolean.valueOf(false);
        }
        return result;
    }
}
