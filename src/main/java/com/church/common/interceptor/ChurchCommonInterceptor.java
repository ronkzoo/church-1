package com.church.common.interceptor;

import com.church.common.util.PaginationCaculateUtil;
import com.church.common.util.RequestLogTable;
import com.church.common.vo.PaginationVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by LeeRyu on 2015-07-24.
 * com.church.common.interceptor
 */
public class ChurchCommonInterceptor extends HandlerInterceptorAdapter{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {

        logger.debug("preHandle");

        if (this.logger.isDebugEnabled()) {
            RequestLogTable requestLogTable = new RequestLogTable(request);
            requestLogTable.printLog();
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {
        logger.debug("postHandle");

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
        Object handler, Exception ex) throws Exception {

    }
}
