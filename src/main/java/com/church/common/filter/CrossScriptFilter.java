package com.church.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by LeeRyu on 2015-07-24.
 * com.church.common.filter
 */
public class CrossScriptFilter  extends HttpServletRequestWrapper {
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public CrossScriptFilter(HttpServletRequest request) {
        super(request);
    }

}
