package com.church.test.web;

import com.church.mngr.bbs.service.BbsService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.test.web
 */
@Controller
public class BbsController {

    @Resource(name = "bbsService") BbsService bbsService;


}
