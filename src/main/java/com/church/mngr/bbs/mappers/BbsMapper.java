package com.church.mngr.bbs.mappers;

import com.church.mngr.bbs.vo.BoardVO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.mngr.bbs.mappers
 */
@Component(value = "bbsMapper")
public interface BbsMapper {
    List<Map<String, Object>>selectT(Map<String, Object> boardDataMap) throws Exception;
    void deleteBoard(BoardVO boardVO) throws Exception;
    void insertBoard(BoardVO boardVO) throws Exception;
    void updateBoard(BoardVO boardVO) throws Exception;

}
