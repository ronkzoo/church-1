package com.church;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Calendar;

/**
 * Created by com on 2015. 7. 14..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( {
                    "classpath:context-datasource.xml",
                    "classpath:context-transactionManager.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestMain extends Assert{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DataSource dataSource;

    @Before
    public void init(){


    }
    @Test
    public void test(){
        StringBuffer query = new StringBuffer();

        query.append("select * from category ");

        JdbcTemplate select = new JdbcTemplate(dataSource);
        int cnt = select.queryForInt("select count(*) from ");
        logger.debug(" cnt:::::: "+cnt);
        assertTrue(cnt > 0);

    }








}
