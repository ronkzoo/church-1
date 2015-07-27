package com.church.mngr.bbs.service;

import com.church.mngr.bbs.vo.BoardVO;

import java.util.List;
import java.util.Map;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.mngr.bbs.service
 */
public interface BbsService {
    List<Map<String,Object>> selectT(Map<String, Object> paramMap) throws Exception;
    void deleteBoard(BoardVO boardVO) throws Exception;
    void insertBoard(BoardVO boardVO) throws Exception;
    void updateBoard(BoardVO boardVO) throws Exception;
}
