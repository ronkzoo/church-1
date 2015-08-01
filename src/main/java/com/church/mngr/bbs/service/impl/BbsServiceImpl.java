package com.church.mngr.bbs.service.impl;

import com.church.mngr.bbs.mappers.BbsMapper;
import com.church.mngr.bbs.service.BbsService;
import com.church.mngr.bbs.vo.BoardVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.mngr.bbs.service.impl
 */
@Service(value = "bbsService")
public class BbsServiceImpl implements BbsService {

    @Resource(name = "bbsMapper") BbsMapper bbsMapper;

    public List<Map<String, Object>> selectT(Map<String, Object> paramMap) throws Exception {
        return bbsMapper.selectT(paramMap);
    }

    public void deleteBoard(BoardVO boardVO) throws Exception {
        bbsMapper.deleteBoard(boardVO);
    }

    public void insertBoard(BoardVO boardVO) throws Exception {
        bbsMapper.insertBoard(boardVO);
    }

    public void updateBoard(BoardVO boardVO) throws Exception {
        bbsMapper.updateBoard(boardVO);
    }
}
