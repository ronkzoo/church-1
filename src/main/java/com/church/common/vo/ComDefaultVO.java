package com.church.common.vo;

/**
 * Created by LeeRyu on 2015-07-28.
 * com.church.common.vo
 */
public class ComDefaultVO extends PaginationVo{

    private static final long serialVersionUID = 1L;

    /** 검색조건 */
    private String searchCondition = "";

    /** 검색 Keyword */
    private String searchKeyword = "";
    /** 검색 사용여부 */
    private String searchUseYn = "";

    /** 검색 등록 시작일 */
    private String searchRegistBeginDt = "";

    /** 검색 등록 종료일 */
    private String searchRegistEndDt = "";

    /** 파일업로드 경로1 */
    private String korEngSe = "";

    /** 파일업로드 경로2 */
    private String dirName = "";

    // 게시판 마스터 일련번호
    private Integer bbsMastrSn;

    /** 게시판 번호 */
    private Integer bbsSn;

    //제한된 갯수 가져옴
    private Integer limitCnt;

    //메뉴 구분 코드
    private String clCode;

    //부서 구분 코드
    private String deptCode;

    //사용유무 검색조건
    private String searchUseAt = "";

    //사용자가 등록한 등록일시
    private String searchUserRegistDt = "";

    /** 카테고리 검색 */
    private String searchCtgry = "";

    private String searchRegisterId = "";

    private String mssageId;
    /** 발신자 */
    private String dsptchPerson;

    private String dsptchMail;

    /** 발신자 아이디 */
    private String dsptchId;

    /** 수신자 */
    private String recptnPerson;

    private String recptnMail;

    private String recptnId;

    /** 제목 */
    private String sj;

    /** 발송결과코드 */
    private String sndngResultCode;

    /** 메일내용 */
    private String emailCn;

    /** 첨부파일ID */
    private String atchFileId;



    /**
     * @return the searchRegisterId
     */
    public String getSearchRegisterId() {
        return searchRegisterId;
    }

    /**
     * @param searchRegisterId the searchRegisterId to set
     */
    public void setSearchRegisterId(String searchRegisterId) {
        this.searchRegisterId = searchRegisterId;
    }

    /**
     * @return the searchCtgry
     */
    public String getSearchCtgry() {
        return searchCtgry;
    }

    /**
     * @param searchCtgry the searchCtgry to set
     */
    public void setSearchCtgry(String searchCtgry) {
        this.searchCtgry = searchCtgry;
    }

    /**
     * 조회수 증가 여부
     */
    private boolean plusCount = false;

    /**
     * 검색조건을 반환합니다.
     *
     * @return the searchCondition
     */
    public String getSearchCondition() {
        return searchCondition;
    }

    /**
     * 검색조건을 설정합니다.
     *
     * @param searchCondition the searchCondition to set
     */
    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }

    /**
     * 검색 Keyword 를 반환합니다.
     *
     * @return the searchKeyword
     */
    public String getSearchKeyword() {
        return searchKeyword;
    }

    /**
     * 검색 Keyword 를 설정합니다.
     *
     * @param searchKeyword the searchKeyword to set
     */
    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    /**
     * 검색 사용여부를 반환합니다.
     *
     * @return the searchUseYn
     */
    public String getSearchUseYn() {
        return searchUseYn;
    }

    /**
     * 검색 사용여부를 설정합니다.
     *
     * @param searchUseYn the searchUseYn to set
     */
    public void setSearchUseYn(String searchUseYn) {
        this.searchUseYn = searchUseYn;
    }

    /**
     * 게시판 마스터 일련번호 을/를 반환합니다.
     *
     * @return the bbsMastrSn
     */
    public Integer getBbsMastrSn() {
        return bbsMastrSn;
    }

    /**
     * 게시판 마스터 일련번호 을/를 설정합니다.
     *
     * @param bbsMastrSn the bbsMastrSn to set
     */
    public void setBbsMastrSn(Integer bbsMastrSn) {
        this.bbsMastrSn = bbsMastrSn;
    }

    /**
     * @return the bbsSn
     */
    public Integer getBbsSn() {
        return bbsSn;
    }

    /**
     * @param bbsSn the bbsSn to set
     */
    public void setBbsSn(Integer bbsSn) {
        this.bbsSn = bbsSn;
    }

    /**
     * 조회수증가에 대한 여부
     *
     */
    public boolean isPlusCount() {
        return plusCount;
    }

    /**
     * 조회수증가에 대한 여부를 설정한다.
     *
     * @param plusCount
     */
    public void setPlusCount(boolean plusCount) {
        this.plusCount = plusCount;
    }

    /**
     * 제한된 글갯수를 반환한다.
     *
     * @return
     * @author 강행호
     */
    public Integer getLimitCnt() {
        return limitCnt;
    }

    /**
     * 제한된 글갯수를 수정한다.
     *
     * @param limitCnt
     * @author 강행호
     */
    public void setLimitCnt(Integer limitCnt) {
        this.limitCnt = limitCnt;
    }

    /**
     * 검색 등록 시작일을 반환합니다.
     *
     * @return the searchRegistBeginDt
     */
    public String getSearchRegistBeginDt() {
        return searchRegistBeginDt;
    }

    /**
     * 검색 등록 시작일을 설정합니다.
     *
     * @param searchRegistBeginDt the searchRegistBeginDt to set
     */
    public void setSearchRegistBeginDt(String searchRegistBeginDt) {
        this.searchRegistBeginDt = searchRegistBeginDt;
    }

    /**
     * 검색 등록 종료일을 반환합니다.
     *
     * @return the searchRegistEndDt
     */
    public String getSearchRegistEndDt() {
        return searchRegistEndDt;
    }

    /**
     * 검색 등록 종료일을 설정합니다.
     *
     * @param searchRegistEndDt the searchRegistEndDt to set
     */
    public void setSearchRegistEndDt(String searchRegistEndDt) {
        this.searchRegistEndDt = searchRegistEndDt;
    }

    /**
     * 메뉴 구분 코드를 반환한다.
     *
     * @return
     * @author 강행호
     */
    public String getClCode() {
        return clCode;
    }

    /**
     * 메뉴구분코드를 설정한다.
     *
     * @param clCode
     * @author 강행호
     */
    public void setClCode(String clCode) {
        this.clCode = clCode;
    }

    /**
     * 경로구분을 반환합니다.
     *
     * @return the korEngSe
     */
    public String getKorEngSe() {
        return korEngSe;
    }

    /**
     * 경로구분을 설정합니다.
     *
     * @param korEngSe the korEngSe to set
     */
    public void setKorEngSe(String korEngSe) {
        this.korEngSe = korEngSe;
    }

    /**
     * 경로구분을 반환합니다.
     *
     * @return the dirName
     */
    public String getDirName() {
        return dirName;
    }

    /**
     * 경로구분을 설정합니다.
     *
     * @param dirName the dirName to set
     */
    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    /**
     * 부서구분코드값 반환
     *
     * @return the deptCode
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 부서구분코드값 설정
     *
     * @param deptCode the deptCode to set
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * 사용 여부 을/를 반환합니다.
     *
     * @return the useAt
     */
    public String getSearchUseAt() {
        return searchUseAt;
    }

    /**
     * 사용 여부 을/를 설정합니다.
     *
     * @param searchUseAt the searchUseAt to set
     */
    public void setSearchUseAt(String searchUseAt) {
        this.searchUseAt = searchUseAt;
    }

    /**
     * 사용자가 등록한 등록일시를 반환한다.
     *
     * @return
     * @author 강행호
     */
    public String getSearchUserRegistDt() {
        return searchUserRegistDt;
    }

    /**
     * 사용자가 등록한 등록일시를 설정한다.
     *
     * @param searchUserRegistDt
     * @author 강행호
     */
    public void setSearchUserRegistDt(String searchUserRegistDt) {
        this.searchUserRegistDt = searchUserRegistDt;
    }

    /**
     * @return the mssageId
     */
    public String getMssageId() {
        return mssageId;
    }

    /**
     * @param mssageId the mssageId to set
     */
    public void setMssageId(String mssageId) {
        this.mssageId = mssageId;
    }

    /**
     * @return the dsptchPerson
     */
    public String getDsptchPerson() {
        return dsptchPerson;
    }

    /**
     * @param dsptchPerson the dsptchPerson to set
     */
    public void setDsptchPerson(String dsptchPerson) {
        this.dsptchPerson = dsptchPerson;
    }

    /**
     * @return the dsptchMail
     */
    public String getDsptchMail() {
        return dsptchMail;
    }

    /**
     * @param dsptchMail the dsptchMail to set
     */
    public void setDsptchMail(String dsptchMail) {
        this.dsptchMail = dsptchMail;
    }

    /**
     * @return the dsptchId
     */
    public String getDsptchId() {
        return dsptchId;
    }

    /**
     * @param dsptchId the dsptchId to set
     */
    public void setDsptchId(String dsptchId) {
        this.dsptchId = dsptchId;
    }

    /**
     * @return the recptnPerson
     */
    public String getRecptnPerson() {
        return recptnPerson;
    }

    /**
     * @param recptnPerson the recptnPerson to set
     */
    public void setRecptnPerson(String recptnPerson) {
        this.recptnPerson = recptnPerson;
    }

    /**
     * @return the recptnMail
     */
    public String getRecptnMail() {
        return recptnMail;
    }

    /**
     * @param recptnMail the recptnMail to set
     */
    public void setRecptnMail(String recptnMail) {
        this.recptnMail = recptnMail;
    }

    /**
     * @return the recptnId
     */
    public String getRecptnId() {
        return recptnId;
    }

    /**
     * @param recptnId the recptnId to set
     */
    public void setRecptnId(String recptnId) {
        this.recptnId = recptnId;
    }

    /**
     * @return the sj
     */
    public String getSj() {
        return sj;
    }

    /**
     * @param sj the sj to set
     */
    public void setSj(String sj) {
        this.sj = sj;
    }

    /**
     * @return the sndngResultCode
     */
    public String getSndngResultCode() {
        return sndngResultCode;
    }

    /**
     * @param sndngResultCode the sndngResultCode to set
     */
    public void setSndngResultCode(String sndngResultCode) {
        this.sndngResultCode = sndngResultCode;
    }

    /**
     * @return the emailCn
     */
    public String getEmailCn() {
        return emailCn;
    }

    /**
     * @param emailCn the emailCn to set
     */
    public void setEmailCn(String emailCn) {
        this.emailCn = emailCn;
    }

    /**
     * @return the atchFileId
     */
    public String getAtchFileId() {
        return atchFileId;
    }

    /**
     * @param atchFileId the atchFileId to set
     */
    public void setAtchFileId(String atchFileId) {
        this.atchFileId = atchFileId;
    }
}
