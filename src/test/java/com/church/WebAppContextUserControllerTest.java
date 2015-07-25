package com.church;

import com.church.test.web.HelloWorldController2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ronkzoo on 2015. 7. 25..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
            "classpath:/props/common-properties.xml",
            "classpath:/props/datasource-properties.xml",
            "classpath:/spring/context-common.xml",
            "classpath:/spring/context-datasource.xml",
            "classpath:/spring/context-transactionManager.xml"
})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
@WebAppConfiguration
public class WebAppContextUserControllerTest {

    @InjectMocks
    private HelloWorldController2 controller;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void controllerTest() throws Exception {

        this.mockMvc
                .perform(get("/hello2/leeminuk").param("name","leeminuk"))
                .andExpect((status().isOk()));
    }

}
