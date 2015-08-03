package com.church.hmpg.bbs.service;

import com.church.hmpg.bbs.vo.BbsDataVo;

import java.util.List;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.mngr.bbs.service
 */
public interface BbsDataService {

    /**
     *
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    List<BbsDataVo> selectList(BbsDataVo bbsDataVo) throws Exception;

    /**
     *
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    BbsDataVo select(BbsDataVo bbsDataVo) throws Exception;
    /**
     *
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    int selectTotalCount(BbsDataVo bbsDataVo) throws Exception;
    /**
     *
     * @param bbsDataVo
     * @throws Exception
     */
    void delete(BbsDataVo bbsDataVo) throws Exception;

    /**
     *
     * @param bbsDataVo
     * @throws Exception
     */
    void insert(BbsDataVo bbsDataVo) throws Exception;

    /**
     *
     * @param bbsDataVo
     * @throws Exception
     */
    void update(BbsDataVo bbsDataVo) throws Exception;

}
