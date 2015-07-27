package com.church.mngr.com.bbs.mappers;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.mngr.com.bbs.mappers
 */
@Component(value = "bbsMapper")
public interface BbsMapper {

    List<Map<String, Object>>selectT(Map<String, Object> boardDataMap) throws Exception;

    /**
     *
     * @param paramMap
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> selectBoardList(LinkedHashMap<String, Object> paramMap) throws Exception;

    /**
     *
     * @param paramMap
     * @return
     * @throws Exception
     */
    int selectBoardTotalCount(LinkedHashMap<String, Object> paramMap) throws Exception ;

}
