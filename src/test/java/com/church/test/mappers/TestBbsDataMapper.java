package com.church.test.mappers;

import com.church.test.vo.TestVo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Class Name   : com.church.sql.mappers
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
@Component(value = "testBbsDataMapper")
public interface TestBbsDataMapper {

    /**
     *
     * @param vo
     * @return
     * @throws Exception
     */
    List<? extends Map> selectList(TestVo vo) throws Exception ;

    /**
     *
     * @param vo
     * @return
     * @throws Exception
     */
    int selectListCount(TestVo vo) throws Exception ;

    /**
     *
     * @param vo
     * @return
     * @throws Exception
     */
    List<? extends Map> selectAllList(TestVo vo) throws Exception;

}
