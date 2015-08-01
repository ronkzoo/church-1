package com.church.mngr.bbs.mappers;

import com.church.mngr.bbs.vo.BoardVO;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.mngr.bbs.mappers
 */
@Component(value = "bbsMapper")
public interface BbsMapper {

    List<Map<String, Object>>selectT(Map<String, Object> boardDataMap) throws Exception;
<<<<<<< HEAD:src/main/java/com/church/mngr/com/bbs/mappers/BbsMapper.java

    /**
     *
     * @param paramMap
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> selectBoardList(LinkedHashMap<String, Object> paramMap) throws Exception;

    /**
     *
     * @param paramMap
     * @return
     * @throws Exception
     */
    int selectBoardTotalCount(LinkedHashMap<String, Object> paramMap) throws Exception ;
=======
    void deleteBoard(BoardVO boardVO) throws Exception;
    void insertBoard(BoardVO boardVO) throws Exception;
    void updateBoard(BoardVO boardVO) throws Exception;
>>>>>>> leeryu/master:src/main/java/com/church/mngr/bbs/mappers/BbsMapper.java

}
