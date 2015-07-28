package com.church;

import com.church.common.util.PaginationCaculateUtil;
import com.church.common.vo.PaginationVo;
import com.church.mngr.com.bbs.service.BbsService;
import com.church.test.service.TestBbsDataService;
import com.church.test.vo.TestVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Name   : com.church
 * Description  :
 * <p/>
 * <p/>
 * Modification Information
 * -----------------------------------------------------------
 * 수정일                 수정자                 수정내용
 * -----------------------------------------------------------
 * <p/>
 * 2015. 7. 27.             ronkzoo             최초생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/props/common-properties.xml",
    "classpath:/props/datasource-properties.xml",
    "classpath:/spring/context-common.xml",
    "classpath:/spring/context-datasource.xml",
    "classpath:/spring/context-sqlmap.xml",
    "classpath:/spring/context-transactionManager.xml",
    "classpath:/sqlmap/mybatis-config.xml"
})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestBoardMain extends Assert {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "testBbsDataService") TestBbsDataService testBbsDataService;

    @Test
    public void test() throws Exception {

        TestVo tvo = new TestVo();
        tvo.setPageIndex(1);
        PaginationCaculateUtil.cacualtePagination(tvo);
        logger.debug(" firstIndex :::: "+tvo.getFirstIndex());
        // 리스트
        List<Map<String, Object>> list =
            (List<Map<String, Object>>) testBbsDataService.selectList(tvo);

        tvo.setTotalRecordCount(this.testBbsDataService.selectListCount(tvo));
        // 게시물 건수
        logger.debug(tvo.toString());

    }


}
