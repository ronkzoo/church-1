package com.church.common.util;

import com.church.common.ComConstants;
import com.church.common.vo.PaginationVo;

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

    private PaginationCaculateUtil(){}

    public static void cacualtePagination(PaginationVo vo){
        setFirstPageIndex(vo);
    }

    private static void setFirstPageIndex(PaginationVo vo){
        if(vo.getPageIndex() != 1)
            vo.setFirstIndex(vo.getPageIndex() * vo.getPageUnit());
    }



}
