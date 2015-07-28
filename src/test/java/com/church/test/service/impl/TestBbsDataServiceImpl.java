package com.church.test.service.impl;

import com.church.test.mappers.TestBbsDataMapper;
import com.church.test.service.TestBbsDataService;
import com.church.test.vo.TestVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Class Name   : com.church.sql.service.impl
 * Description  :
 * <p/>
 * <p/>
 * Modification Information
 * -----------------------------------------------------------
 * 수정일                 수정자                 수정내용
 * -----------------------------------------------------------
 * <p/>
 * 2015. 7. 28.             ronkzoo             최초생성
 */
@Service(value = "testBbsDataService")
public class TestBbsDataServiceImpl implements TestBbsDataService {

    @Resource(name = "testBbsDataMapper") TestBbsDataMapper mapper;

    public List<? extends Map> selectList(TestVo vo) throws Exception {
        return this.mapper.selectList(vo);
    }

    public int selectListCount(TestVo vo) throws Exception {
        return this.mapper.selectListCount(vo) ;
    }

    public List<? extends Map> selectAllList(TestVo vo) throws Exception {
        return this.selectAllList(vo);
    }
}
