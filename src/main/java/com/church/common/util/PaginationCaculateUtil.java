package com.church.common.util;

import com.church.common.ComConstants;
import com.church.common.vo.PaginationVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Class Name   : com.church.common.util
 * Description  :
 * <p/>
 * <p/>
 * Modification Information
 * -----------------------------------------------------------
 * 수정일                 수정자                 수정내용
 * -----------------------------------------------------------
 * <p/>
 * 2015. 7. 26.             ronkzoo             최초생성
 */
public class PaginationCaculateUtil {

    private static Logger logger = LoggerFactory.getLogger(PaginationCaculateUtil.class);

    private PaginationCaculateUtil(){}

    public static void cacualtePagination(PaginationVo vo){
        setFirstPageIndex(vo);
        setRecordCountPerPage(vo);
    }

    private static void setFirstPageIndex(PaginationVo vo){
        vo.setFirstIndex(((vo.getPageIndex() - 1) * vo.getPageUnit()));
    }

    private static void setRecordCountPerPage(PaginationVo vo) {
        vo.setRecordCountPerPage(vo.getPageUnit());
    }

    private static void setTotalPageCount(PaginationVo vo) {
        vo.setTotalRecordCount((vo.getTotalRecordCount() / vo.getPageUnit()) +  (int)((vo.getTotalRecordCount() % vo.getPageUnit()) * 1));
    }

}
