package com.church.test.web;

import com.church.common.ComConstants;
import com.church.common.util.PaginationCaculateUtil;
import com.church.common.vo.PaginationVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("testController")
@RequestMapping(value = "/test")
public class TestController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping("{name}")
    public String test(@PathVariable String name,
        @ModelAttribute("paginationVo") PaginationVo paginationVo, Model model) {

        PaginationCaculateUtil.cacualtePagination(paginationVo);

        model.addAttribute("hello", "hello");
        logger.debug("paginationVo.getFirstIndex() :::: ", paginationVo.getFirstIndex());

        return "template/test/"+name;
    }




}
