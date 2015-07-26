package com.church.mngr.com.bbs.service;

import java.util.List;
import java.util.Map;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.mngr.com.bbs.service
 */
public interface BbsService {
    List<Map<String,Object>> selectT(Map<String, Object> paramMap) throws Exception;
}
