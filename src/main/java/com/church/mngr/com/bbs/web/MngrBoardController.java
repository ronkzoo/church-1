package com.church.mngr.com.bbs.web;

import com.church.mngr.com.bbs.service.BbsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.mngr.com.bbs.web
 */
@RequestMapping(value = "/a")
@Controller
public class MngrBoardController {

    @Resource(name = "bbsService") BbsService bbsService;

    @RequestMapping(value = {"/b", "/b/"})
    public String mngrBoardList(HttpServletRequest request, HttpServletResponse response,
        ModelMap model) throws Exception{

        if(bbsService == null)  {
            System.out.println("--------------- ");
            System.out.println("null ");
            System.out.println("-----------------");
        }

        model.addAttribute("bbsList", bbsService.selectT(new HashMap<String, Object>()));

        return "/test/list";
    }
}
