package com.church.test.web;

import com.church.mngr.com.bbs.service.BbsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
