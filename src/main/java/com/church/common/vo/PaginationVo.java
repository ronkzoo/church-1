package com.church.common.vo;

import java.io.Serializable;

/**
 * <pre>
 * Class Name  : ComPaginationVo.java
 * Description :
 * Modification Information
 *
 *    수정일　　　 　　     수정자　　　      수정내용
 *    -------------   ----------   ---------------------------
 *    2015. 7. 30.      이민욱         최초생성
 * </pre>
 *
 * @author  이민욱
 * @version 1.0
 *          <p/>
 *          Copyright (C) 2014 by SsangDi All right reserved.
 * @since 2015. 7. 30.
 */
public class PaginationVo implements Serializable {
    private static final long serialVersionUID = -7869715162095539641L;

    /**
     * 현재페이지
     */
    private int pageIndex = 1;

    /**
     * 페이지갯수
     */
    private int pageUnit = 10;

    /**
     * 페이지사이즈
     */
    private int pageSize = 10;

    /**
     * firstIndex
     */
    private int firstIndex = 1;

    /**
     * lastIndex
     */
    private int lastIndex = 1;

    /**
     * recordCountPerPage
     */
    private int recordCountPerPage = 10;

    /**
     * 선택한 페이지갯수
     */
    private int searchPageUnit = 0;

    /**
     * 총 게시글 수
     */
    private int totalRecordCount = 0;

    /**
     * pageIndex
     *
     * @return the pageIndex
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * pageIndex
     *
     * @param pageIndex the pageIndex to set
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * pageUnit
     *
     * @return the pageUnit
     */
    public int getPageUnit() {
        return pageUnit;
    }

    /**
     * pageUnit
     *
     * @param pageUnit the pageUnit to set
     */
    public void setPageUnit(int pageUnit) {
        this.pageUnit = pageUnit;
    }

    /**
     * pageSize
     *
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * pageSize
     *
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * firstIndex
     *
     * @return the firstIndex
     */
    public int getFirstIndex() {
        return firstIndex;
    }

    /**
     * firstIndex
     *
     * @param firstIndex the firstIndex to set
     */
    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    /**
     * lastIndex
     *
     * @return the lastIndex
     */
    public int getLastIndex() {
        return lastIndex;
    }

    /**
     * lastIndex
     *
     * @param lastIndex the lastIndex to set
     */
    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    /**
     * recordCountPerPage
     *
     * @return the recordCountPerPage
     */
    public int getRecordCountPerPage() {
        return recordCountPerPage;
    }

    /**
     * recordCountPerPage
     *
     * @param recordCountPerPage the recordCountPerPage to set
     */
    public void setRecordCountPerPage(int recordCountPerPage) {
        this.recordCountPerPage = recordCountPerPage;
    }

    /**
     * @return the searchPageUnit
     */
    public int getSearchPageUnit() {
        return searchPageUnit;
    }

    /**
     * @param searchPageUnit the searchPageUnit to set
     */
    public void setSearchPageUnit(int searchPageUnit) {
        this.searchPageUnit = searchPageUnit;
    }

    /**
     *
     * @return
     */
    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    /**
     *
     * @param totalRecordCount
     */
    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }
}
