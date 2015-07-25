package com.church.test.web;

import com.church.test.vo.HelloWorldVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by com on 2015. 7. 18..
 */
@RestController
public class HelloWorldController2 {

       private Logger logger= LoggerFactory.getLogger(this.getClass());

       @RequestMapping(value = "/hello2")
       public HelloWorldVo getAllEmployees()
       {
           HelloWorldVo hello = new HelloWorldVo();
           hello.setName("이민욱");
           hello.setId("com");

           logger.debug(hello.toString());

           return hello;
       }

       @RequestMapping(value = "/hello2/{name}")
       public HelloWorldVo getAllHelloByName(@PathVariable("name") String name)
       {
           HelloWorldVo hello = new HelloWorldVo();
           hello.setName(name);
           hello.setId("com");

            logger.debug(hello.toString());

           return hello;
       }


}
