package com.church.test.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("testController")
@RequestMapping(value = "/test")
public class TestController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping("taglib/{name}")
    public ModelAndView returnString(@PathVariable String name, Model model) {
        return new ModelAndView("/test/taglib/" + name);
    }


    @RequestMapping("{name}")
    public String test(@PathVariable String name, Model model) {

        model.addAttribute("hello","hello");
        logger.debug("leeminuk");
        return "template/test/"+name;
    }


}
