package com.church.test.web;

import com.church.common.util.PaginationCaculateUtil;
import com.church.common.vo.PaginationVo;
import com.church.mngr.com.bbs.service.BbsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.test.web
 */
@RequestMapping("/test/board")
@Controller("bbsController")
public class BbsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "bbsService") BbsService bbsService;

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

        PaginationCaculateUtil.setFirstPageIndex(paginationVo);

        // 리스트
        model.addAttribute("bbsList", bbsService.selectBoardList(model));
        paginationVo.setTotalRecordCount(this.bbsService.selectBoardTotalCount(model));
        // 게시물 건수
        PaginationCaculateUtil.cacualtePagination(paginationVo);

        model.addAttribute("paginationVo", paginationVo);

        return "template/test/list";
    }

}
