package com.church.test.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ronkzoo on 2015. 7. 25..
 */
@Controller("testController")
@RequestMapping("/test")
public class TestController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "taglib/{name}")
    public String returnString(@PathVariable String name, Model model) {
        logger.debug("do here ");
        return "/test/taglib/" + name;
    }

}
