package com.church.test.web;

import com.church.common.util.FileUploadUtil;
import com.church.mngr.bbs.service.BbsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.test.web
 */
@Controller
public class BbsController {

    @Resource(name = "bbsService") BbsService bbsService;

    @RequestMapping("/mngr/file")
    public String doInsertFile(HttpServletRequest request, HttpServletResponse response,
        ModelMap model) throws Exception {

        return "/test/file";
    }

    @RequestMapping(value = "/mngr/file-act", method = RequestMethod.POST)
    public String doInsertFileAct(HttpServletRequest request, HttpServletResponse response,
        ModelMap model) throws Exception {


        if (!(request instanceof MultipartHttpServletRequest)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                "EXpected multipart request");
            return null;
        }

        FileUploadUtil fileUploadUtil = new FileUploadUtil();

        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;

        fileUploadUtil.uploadFile(multipartHttpServletRequest, "D:\\");

        return "/test/list";
    }

    /**
     * @param request
     * @param response
     * @throws Exception
     */
    private void doFileUpload(HttpServletRequest request,
        HttpServletResponse response, String boardSid) throws Exception {
        /** **/
        if(!(request instanceof MultipartHttpServletRequest)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, " Expcted Multipart request");
        }

        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
    }
}
