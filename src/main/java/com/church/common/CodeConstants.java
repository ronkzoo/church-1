package com.church.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <pre>
 * Class Name  : CodeConstants.java
 * Description : 
 * Modification Information  
 * 
 *    수정일　　　 　　     수정자　　　      수정내용
 *    -------------   ----------   ---------------------------
 *    2015. 9. 3.      이민욱         최초생성
 * </pre>
 *
 * @author  이민욱
 * @since 2015. 9. 3.
 * @version 1.0
 * 
 */
public class CodeConstants {
	// 성별 구분
    public static final Map<String, String> SEX_DSTN;
    // 탈퇴 여부
    public static final Map<String, String> SECSN_AT;
    // 승인 여부
    public static final Map<String, String> CNFM_AT;
    // 사용 여부
    public static final Map<String, String> USE_AT;
    // 완료 여부
    public static final Map<String, String> FINISH_AT;
    // Y/N 여부 공통
    public static final Map<String, String> YN_AT;
    // 행정표준용어 구분
    public static final Map<String, String> WORD_DICARY_REGIST_SE;
    // 평가포함 여부
    public static final Map<String, String> EVL_INCLS_AT;
    // 게시글 페이징 갯수 선택
    public static final Map<Integer, String> PAGE_UNIT_LIST;
    // 토론구분
    public static final Map<String, String> DSCSN_AT;
    // 온오프구분
    public static final Map<String, String> REGIST_AT;
    //토론/발표 구분
    public static final Map<String, String> DSCSNSE_OPERTN;
    //토론구분  찬반 여부
    public static final Map<String, String> DSCSNSE_AT;
    // 월
    public static final Map<String, String> MONTH_VAL;
    // 시간
    public static final Map<String, String> TIME_VAL;
    // 분
    public static final Map<String, String> MIN_VAL;
    // 분(1분 단위)
    public static final Map<String, String> MIN_VAL2;
    // 승인 여부
    public static final Map<String, String> CONFM_AT;
    // 노출 여부
    public static final Map<String, String> EXPSR_AT;

    static {
        // 성별 구분
    	SEX_DSTN = new LinkedHashMap<String, String>();
    	SEX_DSTN.put("1", "남성");
    	SEX_DSTN.put("2", "여성");

    	// 탈퇴 여부
    	SECSN_AT = new LinkedHashMap<String, String>();
    	SECSN_AT.put("Y", "Y");
    	SECSN_AT.put("N", "N");

    	// 승인 구분
    	CNFM_AT = new LinkedHashMap<String, String>();
    	CNFM_AT.put("Y", "승인완료");
    	CNFM_AT.put("N", "가입대기");
        
        // 사용 여부
        USE_AT = new LinkedHashMap<String, String>();
        USE_AT.put("Y", "사용");
        USE_AT.put("N", "미사용");

        // 완료 여부
        FINISH_AT = new LinkedHashMap<String, String>();
        FINISH_AT.put("Y", "완료");
        FINISH_AT.put("N", "미완료");
        
        // Y/N 여부 공통
        YN_AT = new LinkedHashMap<String, String>();
        YN_AT.put("Y", "Y");
        YN_AT.put("N", "N");
        
        // 행정표준용어 구분
        WORD_DICARY_REGIST_SE = new LinkedHashMap<String, String>();
        WORD_DICARY_REGIST_SE.put("S", "행정표준용어");
        WORD_DICARY_REGIST_SE.put("T", "서브시스템구분");
        WORD_DICARY_REGIST_SE.put("U", "사용자정의");
        
        // 평가포함 여부
        EVL_INCLS_AT = new LinkedHashMap<String, String>();
        EVL_INCLS_AT.put("Y", "포함");	
        EVL_INCLS_AT.put("N", "미포함");	

        // 게시글 페이징 갯수 선택
        PAGE_UNIT_LIST = new LinkedHashMap<Integer, String>();
        PAGE_UNIT_LIST.put(10,  "10개씩 보기");
        PAGE_UNIT_LIST.put(20,  "20개씩 보기");
        PAGE_UNIT_LIST.put(30,  "30개씩 보기");
        PAGE_UNIT_LIST.put(50,  "50개씩 보기");
        PAGE_UNIT_LIST.put(100, "100개씩 보기");
        
        //온오프 구분
        DSCSN_AT = new LinkedHashMap<String, String>();
        DSCSN_AT.put("F", "오프라인 토론·발표·실습");
        DSCSN_AT.put("O", "온라인 토론");
        
        //토론/발표/실습 구분 
        DSCSNSE_OPERTN = new LinkedHashMap<String, String>();
        DSCSNSE_OPERTN.put("D", "토론");
        DSCSNSE_OPERTN.put("A", "발표");
        DSCSNSE_OPERTN.put("B", "실습");
        
        //온라인 토론구분
        REGIST_AT = new LinkedHashMap<String, String>();
        REGIST_AT.put("I", "이슈토론");
        REGIST_AT.put("O", "찬반토론");
        
        //토론구분  찬반 여부
        DSCSNSE_AT = new LinkedHashMap<String, String>();
        DSCSNSE_AT.put("Y", "찬성");
        DSCSNSE_AT.put("N", "반대");
        
      //월
        MONTH_VAL = new LinkedHashMap<String, String>();
        MONTH_VAL.put("1", "01월");
        MONTH_VAL.put("2", "02월");
        MONTH_VAL.put("3", "03월");
        MONTH_VAL.put("4", "04월");
        MONTH_VAL.put("5", "05월");
        MONTH_VAL.put("6", "06월");
        MONTH_VAL.put("7", "07월");
        MONTH_VAL.put("8", "08월");
        MONTH_VAL.put("9", "09월");
        MONTH_VAL.put("10", "10월");
        MONTH_VAL.put("11", "11월");
        MONTH_VAL.put("12", "12월");
        
        //시간
        TIME_VAL = new LinkedHashMap<String, String>();
        TIME_VAL.put("00", "00시");
        TIME_VAL.put("01", "01시");
        TIME_VAL.put("02", "02시");
        TIME_VAL.put("03", "03시");
        TIME_VAL.put("04", "04시");
        TIME_VAL.put("05", "05시");
        TIME_VAL.put("06", "06시");
        TIME_VAL.put("07", "07시");
        TIME_VAL.put("08", "08시");
        TIME_VAL.put("09", "09시");
        TIME_VAL.put("10", "10시");
        TIME_VAL.put("11", "11시");
        TIME_VAL.put("12", "12시");
        TIME_VAL.put("13", "13시");
        TIME_VAL.put("14", "14시");
        TIME_VAL.put("15", "15시");
        TIME_VAL.put("16", "16시");
        TIME_VAL.put("17", "17시");
        TIME_VAL.put("18", "18시");
        TIME_VAL.put("19", "19시");
        TIME_VAL.put("20", "20시");
        TIME_VAL.put("21", "21시");
        TIME_VAL.put("22", "22시");
        TIME_VAL.put("23", "23시");
        
        //분
        //5분단위까지 설정하도록 변경
        MIN_VAL = new LinkedHashMap<String, String>();
        MIN_VAL.put("00", "00분");
        MIN_VAL.put("05", "05분");
        MIN_VAL.put("10", "10분");
        MIN_VAL.put("15", "15분");
        MIN_VAL.put("20", "20분");
        MIN_VAL.put("25", "25분");
        MIN_VAL.put("30", "30분");
        MIN_VAL.put("35", "35분");
        MIN_VAL.put("40", "40분");
        MIN_VAL.put("45", "45분");
        MIN_VAL.put("50", "50분");
        MIN_VAL.put("55", "55분");
        
        //분
        //1분단위까지 설정하도록 변경  
        MIN_VAL2 = new LinkedHashMap<String, String>();
        MIN_VAL2.put("00", "00분");
        MIN_VAL2.put("01", "01분");
        MIN_VAL2.put("02", "02분");
        MIN_VAL2.put("03", "03분");
        MIN_VAL2.put("04", "04분");
        MIN_VAL2.put("05", "05분");
        MIN_VAL2.put("06", "06분");
        MIN_VAL2.put("07", "07분");
        MIN_VAL2.put("08", "08분");
        MIN_VAL2.put("09", "09분");
        MIN_VAL2.put("10", "10분");
        MIN_VAL2.put("11", "11분");
        MIN_VAL2.put("12", "12분");
        MIN_VAL2.put("13", "13분");
        MIN_VAL2.put("14", "14분");
        MIN_VAL2.put("15", "15분");
        MIN_VAL2.put("16", "16분");
        MIN_VAL2.put("17", "17분");
        MIN_VAL2.put("18", "18분");
        MIN_VAL2.put("19", "19분");
        MIN_VAL2.put("20", "20분");
        MIN_VAL2.put("21", "21분");
        MIN_VAL2.put("22", "22분");
        MIN_VAL2.put("23", "23분");
        MIN_VAL2.put("24", "24분");
        MIN_VAL2.put("25", "25분");
        MIN_VAL2.put("26", "26분");
        MIN_VAL2.put("27", "27분");
        MIN_VAL2.put("28", "28분");
        MIN_VAL2.put("29", "29분");
        MIN_VAL2.put("30", "30분");
        MIN_VAL2.put("31", "31분");
        MIN_VAL2.put("32", "32분");
        MIN_VAL2.put("33", "33분");
        MIN_VAL2.put("34", "34분");
        MIN_VAL2.put("35", "35분");
        MIN_VAL2.put("36", "36분");
        MIN_VAL2.put("37", "37분");
        MIN_VAL2.put("38", "38분");
        MIN_VAL2.put("39", "39분");
        MIN_VAL2.put("40", "40분");
        MIN_VAL2.put("41", "41분");
        MIN_VAL2.put("42", "42분");
        MIN_VAL2.put("43", "43분");
        MIN_VAL2.put("44", "44분");
        MIN_VAL2.put("45", "45분");
        MIN_VAL2.put("46", "46분");
        MIN_VAL2.put("47", "47분");
        MIN_VAL2.put("48", "48분");
        MIN_VAL2.put("49", "49분");
        MIN_VAL2.put("50", "50분");
        MIN_VAL2.put("51", "51분");
        MIN_VAL2.put("52", "52분");
        MIN_VAL2.put("53", "53분");
        MIN_VAL2.put("54", "54분");
        MIN_VAL2.put("55", "55분");
        MIN_VAL2.put("56", "56분");
        MIN_VAL2.put("57", "57분");
        MIN_VAL2.put("58", "58분");
        MIN_VAL2.put("59", "59분");
        
        //권한여부
        CONFM_AT  = new LinkedHashMap<String, String>();
        CONFM_AT.put("W", "쓰기");
        CONFM_AT.put("R", "읽기");
        CONFM_AT.put("X", "권한없음");
        
        EXPSR_AT = new LinkedHashMap<String, String>();
        EXPSR_AT.put("Y", "노출");
        EXPSR_AT.put("N", "미노출");
    }
}
