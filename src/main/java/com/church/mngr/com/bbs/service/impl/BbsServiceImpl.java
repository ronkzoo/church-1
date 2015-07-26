package com.church.mngr.com.bbs.service.impl;

import com.church.mngr.com.bbs.mappers.BbsMapper;
import com.church.mngr.com.bbs.service.BbsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.mngr.com.bbs.service.impl
 */
@Service(value = "bbsService")
public class BbsServiceImpl implements BbsService {

    @Resource(name = "bbsMapper") BbsMapper bbsMapper;

    public List<Map<String, Object>> selectT(Map<String, Object> paramMap) throws Exception {
        return bbsMapper.selectT(paramMap);
    }
}
