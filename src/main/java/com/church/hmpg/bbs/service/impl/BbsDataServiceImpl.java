package com.church.hmpg.bbs.service.impl;

import com.church.hmpg.bbs.mappers.BbsDataMapper;
import com.church.hmpg.bbs.service.BbsDataService;
import com.church.hmpg.bbs.vo.BbsDataVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.mngr.bbs.service.impl
 */
@Service(value = "bbsDataService")
public class BbsDataServiceImpl implements BbsDataService {

    @Resource(name = "bbsDataMapper") BbsDataMapper bbsDataMapper;

    public List<BbsDataVo> selectList(BbsDataVo bbsDataVo) throws Exception {
        return bbsDataMapper.selectList(bbsDataVo);
    }

    public int selectTotalCount(BbsDataVo bbsDataVo) throws Exception {
        return this.bbsDataMapper.selectTotalCount(bbsDataVo);
    }

    public BbsDataVo select(BbsDataVo bbsDataVo) throws Exception {
        return this.bbsDataMapper.select(bbsDataVo);
    }

    public void delete(BbsDataVo bbsDataVo) throws Exception {
        this.bbsDataMapper.delete(bbsDataVo);
    }

    public void insert(BbsDataVo bbsDataVo) throws Exception {
        this.bbsDataMapper.insert(bbsDataVo);
    }

    public void update(BbsDataVo bbsDataVo) throws Exception {
        this.bbsDataMapper.update(bbsDataVo);
    }
}
