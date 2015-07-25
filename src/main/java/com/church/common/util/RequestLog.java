package com.church.common.util;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * <pre>
 * Class Name  : RequestLogUtil.java
 * Description : 
 * Modification Information  
 * 
 *     수정일　　　 　　         수정자　　　       수정내용
 *    ---------------   -----------  ---------------------------
 *    2014. 8. 12.        이상훈         최초생성
 * </pre>
 *
 * @author 이상훈
 * @since 2014. 8. 12.
 * @version 1.0
 * 
 * Copyright (C) 2014 by Beany All right reserved.
 */
public class RequestLog {
    protected Logger log = LoggerFactory.getLogger(this.getClass());
    
    private static final String HEADER_KEY = "key";
    private static final String HEADER_VALUE = "value";

    private static final String BORDER_TOP_LEFT = "┌";
    private static final String BORDER_TOP_SEPARATION = "┬";
    private static final String BORDER_TOP_RIGHT = "┐";

    private static final String BORDER_MIDDLE_LEFT = "├";
    private static final String BORDER_MIDDLE_SEPARATION = "┼";
    private static final String BORDER_MIDDLE_RIGHT = "┤";

    private static final String BORDER_BOTTOM_LEFT = "└";
    private static final String BORDER_BOTTOM_SEPARATION = "┴";
    private static final String BORDER_BOTTOM_RIGHT = "┘";

    private static final String BORDER_LINE_HORIZONTAL = "─";
    private static final String BORDER_LINE_VERTICAL = "│";

    private static final String SPACE = " ";

    private HttpServletRequest httpServletRequest;
    private String headerName;
    private int keyMaxLen;
    private int valueMaxLen;

    public RequestLog(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    private void init(String headerName) {
        this.headerName = headerName;
        this.keyMaxLen = 0;
        this.valueMaxLen = 0;
    }

    private void setMaxLen() {
        if (this.keyMaxLen < HEADER_KEY.length()) {
            this.keyMaxLen = HEADER_KEY.length();
        }

        if (this.valueMaxLen < HEADER_VALUE.length()) {
            this.valueMaxLen = HEADER_VALUE.length();
        }

        if ((this.keyMaxLen + this.valueMaxLen) < this.headerName.length()) {
            this.valueMaxLen = (this.headerName.length() - this.keyMaxLen);
        }
    }

    private void initParameter(String headerName) {
        this.init(headerName);

        Enumeration<String> parameterNames = this.httpServletRequest.getParameterNames();
        String key = "";

        while (parameterNames.hasMoreElements()) {
            key = parameterNames.nextElement();

            if (key.length() > this.keyMaxLen) {
                this.keyMaxLen = key.length();
            }

            for (String parameter : this.httpServletRequest.getParameterValues(key)) {
                if (parameter.length() > this.valueMaxLen) {
                    this.valueMaxLen = parameter.length();
                }
            }
        }

        this.setMaxLen();
    }

    private void initHeader(String headerName) {
        this.init(headerName);

        String key = "";
        String value = "";
        Enumeration<String> headerNames = this.httpServletRequest .getHeaderNames();

        while (headerNames.hasMoreElements()) {
            key = headerNames.nextElement();
            value = this.httpServletRequest.getHeader(key);

            if (key.length() > this.keyMaxLen) {
                this.keyMaxLen = key.length();
            }

            if (value.length() > this.valueMaxLen) {
                this.valueMaxLen = value.length();
            }
        }

        this.setMaxLen();
    }

    private void printHeader() {
        StringBuilder sb = new StringBuilder();

        int maxLen = (this.keyMaxLen + this.valueMaxLen + 1);

        sb = new StringBuilder();
        sb.append(BORDER_TOP_LEFT);
        sb.append(StringUtils.repeat(BORDER_LINE_HORIZONTAL, maxLen));
        sb.append(BORDER_TOP_RIGHT);
        log.info(sb.toString());

        sb = new StringBuilder();
        sb.append(BORDER_LINE_VERTICAL);
        sb.append(this.headerName);
        sb.append(StringUtils.repeat(SPACE, maxLen - this.headerName.length()));
        sb.append(BORDER_LINE_VERTICAL);
        log.info(sb.toString());

        sb = new StringBuilder();
        sb.append(BORDER_MIDDLE_LEFT);
        sb.append(StringUtils.repeat(BORDER_LINE_HORIZONTAL, this.keyMaxLen));
        sb.append(BORDER_TOP_SEPARATION);
        sb.append(StringUtils.repeat(BORDER_LINE_HORIZONTAL, this.valueMaxLen));
        sb.append(BORDER_MIDDLE_RIGHT);
        log.info(sb.toString());

        /*
        sb = new StringBuilder();
        sb.append(BORDER_TOP_LEFT);
        sb.append(StringUtils.repeat(BORDER_LINE_HORIZONTAL, this.keyMaxLen));
        sb.append(BORDER_TOP_SEPARATION);
        sb.append(StringUtils.repeat(BORDER_LINE_HORIZONTAL, this.valueMaxLen));
        sb.append(BORDER_TOP_RIGHT);
        log.info(sb.toString());
        */

        sb = new StringBuilder();
        sb.append(BORDER_LINE_VERTICAL);
        sb.append(HEADER_KEY);
        sb.append(StringUtils.repeat(SPACE, this.keyMaxLen - HEADER_KEY.length()));
        sb.append(BORDER_LINE_VERTICAL);
        sb.append(HEADER_VALUE);
        sb.append(StringUtils.repeat(SPACE, this.valueMaxLen - HEADER_VALUE.length()));
        sb.append(BORDER_LINE_VERTICAL);
        log.info(sb.toString());

        sb = new StringBuilder();
        sb.append(BORDER_MIDDLE_LEFT);
        sb.append(StringUtils.repeat(BORDER_LINE_HORIZONTAL, this.keyMaxLen));
        sb.append(BORDER_MIDDLE_SEPARATION);
        sb.append(StringUtils.repeat(BORDER_LINE_HORIZONTAL, this.valueMaxLen));
        sb.append(BORDER_MIDDLE_RIGHT);
        log.info(sb.toString());
    }

    private void printBottom() {
        StringBuilder sb = new StringBuilder();

        sb.append(BORDER_BOTTOM_LEFT);
        sb.append(StringUtils.repeat(BORDER_LINE_HORIZONTAL, this.keyMaxLen));
        sb.append(BORDER_BOTTOM_SEPARATION);
        sb.append(StringUtils.repeat(BORDER_LINE_HORIZONTAL, this.valueMaxLen));
        sb.append(BORDER_BOTTOM_RIGHT);
        log.info(sb.toString());
    }

    public void printHeaderLog() {
        this.initHeader(">> HTTP Header : " + this.httpServletRequest.getRequestURL());

        this.printHeader();

        StringBuilder sb = null;
        String headerName = "";
        String headerValue = "";
        Enumeration<String> headerNames = this.httpServletRequest.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            headerName = headerNames.nextElement();
            headerValue = this.httpServletRequest.getHeader(headerName);

            sb = new StringBuilder();
            sb.append(BORDER_LINE_VERTICAL);
            sb.append(headerName);
            sb.append(StringUtils.repeat(SPACE, this.keyMaxLen - headerName.length()));
            sb.append(BORDER_LINE_VERTICAL);
            sb.append(headerValue);
            sb.append(StringUtils.repeat(SPACE, this.valueMaxLen - headerValue.length()));
            sb.append(BORDER_LINE_VERTICAL);
            log.info(sb.toString());
        }

        this.printBottom();
    }

    public void printParameterLog() {
        this.initParameter(">> HTTP Request Parameter : " + this.httpServletRequest.getRequestURL());

        this.printHeader();

        StringBuilder sb = null;
        String key = "";
        Enumeration<String> parameterNames = httpServletRequest.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            key = parameterNames.nextElement();

            for (String parameter : this.httpServletRequest.getParameterValues(key)) {
                sb = new StringBuilder();
                sb.append(BORDER_LINE_VERTICAL);
                sb.append(key);
                sb.append(StringUtils.repeat(SPACE, this.keyMaxLen - key.length()));
                sb.append(BORDER_LINE_VERTICAL);
                sb.append(parameter);
                sb.append(StringUtils.repeat(SPACE, this.valueMaxLen - parameter.length()));
                sb.append(BORDER_LINE_VERTICAL);
                log.info(sb.toString());
            }
        }

        this.printBottom();
    }
}
