package com.church;

import com.church.test.web.BbsController;
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
 * Created by LeeRyu on 2015-07-26.
 * com.church
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/props/common-properties.xml",
    "classpath:/spring/context-common.xml",
    "classpath:/spring/context-datasource.xml",
    "classpath:/spring/context-transactionManager.xml",
    "classpath:/spring/context-sqlmap.xml",
    "classpath:/sqlmap/mybatis-config.xml"
})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
@WebAppConfiguration
public class WebAppContextBoardControllerTest {

    @InjectMocks private BbsController bbsController;

    @Autowired private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bbsController).build();
    }

    @Test
    public void controllerTest() throws Exception {
        this.mockMvc
            .perform(get("/a/b/2222"))
            .andExpect((status().isOk()));
    }
}

