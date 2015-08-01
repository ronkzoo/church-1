package com.church.test.web;

<<<<<<< HEAD
import com.church.common.util.PaginationCaculateUtil;
import com.church.common.vo.PaginationVo;
import com.church.mngr.com.bbs.service.BbsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
=======
import com.church.common.util.FileUploadUtil;
import com.church.mngr.bbs.service.BbsService;
>>>>>>> leeryu/master
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.sql.web
 */
@RequestMapping("/test/board")
@Controller("bbsController")
public class BbsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "bbsService") BbsService bbsService;

<<<<<<< HEAD
    /**
     * 게시판 페이징 처리 테스트
     * @param request
     * @param response
     * @param paginationVo
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("list")
    public String selectBoardList(HttpServletRequest request, HttpServletResponse response,
        @ModelAttribute("paginationVo") PaginationVo paginationVo, ModelMap model) throws Exception{

        // 리스트
        model.addAttribute("bbsList", bbsService.selectBoardList(model));
        paginationVo.setTotalRecordCount(this.bbsService.selectBoardTotalCount(model));
        // 게시물 건수
        PaginationCaculateUtil.cacualtePagination(paginationVo);

        model.addAttribute("paginationVo", paginationVo);

        return "template/sql/list";
    }
=======
    @RequestMapping("/mngr/file")
    public String doInsertFile(HttpServletRequest request, HttpServletResponse response,
        ModelMap model) throws Exception {
>>>>>>> leeryu/master

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
