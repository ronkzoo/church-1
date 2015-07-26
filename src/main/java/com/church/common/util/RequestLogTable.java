package com.church.common.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * Class Name  : RequestLogTable.java
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
public class RequestLogTable {
    protected Logger log = LoggerFactory.getLogger(this.getClass());
    
    private enum Border {
        TOP_LEFT("┌"), TOP_SEPARATION("┬"), TOP_RIGHT("┐"),

        MIDDLE_LEFT("├"), MIDDLE_SEPARATION("┼"), MIDDLE_RIGHT("┤"),

        BOTTOM_LEFT("└"), BOTTOM_SEPARATION("┴"), BOTTOM_RIGHT("┘"),

        HORIZONTAL_LINE("─"), VERTICAL_LINE("│");

        private String value = "";

        private Border(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    private static final String HEADER_KEY = "key";
    private static final String HEADER_VALUE = "value";

    private static final String SPACE = " ";

    private HttpServletRequest httpServletRequest;

    private String currentUrl;
    private int keyMaxLen;
    private int valueMaxLen;
    private int maxLen;

    public RequestLogTable(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
        this.currentUrl = this.httpServletRequest.getRequestURL().toString();

        this.init();
    }

    private void init() {
        this.initParameter();
        this.initHeader();

        if (this.keyMaxLen < HEADER_KEY.length()) {
            this.keyMaxLen = HEADER_KEY.length();
        }

        if (this.valueMaxLen < HEADER_VALUE.length()) {
            this.valueMaxLen = HEADER_VALUE.length();
        }

        // 데이터 최대 길이 (컬럼 구분자 한자리 포함)
        this.maxLen = (this.keyMaxLen + this.valueMaxLen) + 1;

        if (this.maxLen < this.currentUrl.length()) {
            this.valueMaxLen = (this.currentUrl.length() - this.keyMaxLen);
        }
    }

    private void initParameter() {
        String key = "";

        Enumeration<String> parameterNames = this.httpServletRequest.getParameterNames();

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
    }

    private void initHeader() {
        String key = "";
        String value = "";

        Enumeration<String> headerNames = this.httpServletRequest.getHeaderNames();

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
    }

    public void printLog() {
        String httpHeader = ">> HTTP Header ";
        String httpParameter = ">> HTTP Request Parameter  ";

        StringBuilder sb = new StringBuilder();

        this.printBorderTop();

        this.printUrlHeader();

        sb = new StringBuilder();
        sb.append(Border.VERTICAL_LINE);
        sb.append(httpHeader);
        sb.append(StringUtils.repeat(SPACE, this.maxLen - httpHeader.length()));
        sb.append(Border.VERTICAL_LINE);
        this.logWrite(sb.toString());

        this.printKeyValueHeader();

        String key = "";
        Enumeration<String> headerNames = this.httpServletRequest.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            key = headerNames.nextElement();

            this.printKeyValueData(key, this.httpServletRequest.getHeader(key));
        }

        sb = new StringBuilder();
        sb.append(Border.MIDDLE_LEFT);
        sb.append(StringUtils.repeat(Border.HORIZONTAL_LINE.toString(), this.keyMaxLen));
        sb.append(Border.BOTTOM_SEPARATION);
        sb.append(StringUtils.repeat(Border.HORIZONTAL_LINE.toString(), this.valueMaxLen));
        sb.append(Border.MIDDLE_RIGHT);
        this.logWrite(sb.toString());

        sb = new StringBuilder();
        sb.append(Border.VERTICAL_LINE);
        sb.append(httpParameter);
        sb.append(StringUtils.repeat(SPACE, this.maxLen - httpParameter.length()));
        sb.append(Border.VERTICAL_LINE);
        this.logWrite(sb.toString());

        this.printKeyValueHeader();

        Enumeration<String> parameterNames = this.httpServletRequest.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            key = parameterNames.nextElement();

            for (String parameter : this.httpServletRequest.getParameterValues(key)) {
                this.printKeyValueData(key, parameter);
            }
        }

        this.printBorderBottom();
    }

    private void printBorderTop() {
        StringBuilder sb = new StringBuilder();
        sb.append(Border.TOP_LEFT);
        sb.append(StringUtils.repeat(Border.HORIZONTAL_LINE.toString(), this.maxLen));
        sb.append(Border.TOP_RIGHT);
        this.logWrite(sb.toString());
    }

    private void printBorderBottom() {
        StringBuilder sb = new StringBuilder();
        sb.append(Border.BOTTOM_LEFT);
        sb.append(StringUtils.repeat(Border.HORIZONTAL_LINE.toString(), this.keyMaxLen));
        sb.append(Border.BOTTOM_SEPARATION);
        sb.append(StringUtils.repeat(Border.HORIZONTAL_LINE.toString(), this.valueMaxLen));
        sb.append(Border.BOTTOM_RIGHT);
        this.logWrite(sb.toString());
    }

    private void printUrlHeader() {
        StringBuilder sb = new StringBuilder();
        sb.append(Border.VERTICAL_LINE);
        sb.append(this.currentUrl);
        sb.append(StringUtils.repeat(SPACE, this.maxLen - this.currentUrl.length()));
        sb.append(Border.VERTICAL_LINE);
        this.logWrite(sb.toString());

        sb = new StringBuilder();
        sb.append(Border.MIDDLE_LEFT);
        sb.append(StringUtils.repeat(Border.HORIZONTAL_LINE.toString(), this.maxLen));
        sb.append(Border.MIDDLE_RIGHT);
        this.logWrite(sb.toString());
    }

    private void printKeyValueHeader() {
        StringBuilder sb = new StringBuilder();
        sb.append(Border.MIDDLE_LEFT);
        sb.append(StringUtils.repeat(Border.HORIZONTAL_LINE.toString(), this.keyMaxLen));
        sb.append(Border.TOP_SEPARATION);
        sb.append(StringUtils.repeat(Border.HORIZONTAL_LINE.toString(), this.valueMaxLen));
        sb.append(Border.MIDDLE_RIGHT);
        this.logWrite(sb.toString());

        sb = new StringBuilder();
        sb.append(Border.VERTICAL_LINE);
        sb.append(HEADER_KEY);
        sb.append(StringUtils.repeat(SPACE, this.keyMaxLen - HEADER_KEY.length()));
        sb.append(Border.VERTICAL_LINE);
        sb.append(HEADER_VALUE);
        sb.append(StringUtils.repeat(SPACE, this.valueMaxLen - HEADER_VALUE.length()));
        sb.append(Border.VERTICAL_LINE);
        this.logWrite(sb.toString());

        sb = new StringBuilder();
        sb.append(Border.MIDDLE_LEFT);
        sb.append(StringUtils.repeat(Border.HORIZONTAL_LINE.toString(), this.keyMaxLen));
        sb.append(Border.MIDDLE_SEPARATION);
        sb.append(StringUtils.repeat(Border.HORIZONTAL_LINE.toString(), this.valueMaxLen));
        sb.append(Border.MIDDLE_RIGHT);
        this.logWrite(sb.toString());
    }

    private void printKeyValueData(String key, String value) {
        StringBuilder sb = new StringBuilder();
        sb.append(Border.VERTICAL_LINE);
        sb.append(key);
        sb.append(StringUtils.repeat(SPACE, this.keyMaxLen - key.length()));
        sb.append(Border.VERTICAL_LINE);
        sb.append(value);
        sb.append(StringUtils.repeat(SPACE, this.valueMaxLen - value.length()));
        sb.append(Border.VERTICAL_LINE);
        this.logWrite(sb.toString());
    }

    private void logWrite(String value) {
        log.info(value);
    }
}
