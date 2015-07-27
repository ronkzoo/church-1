package com.church.mngr.bbs.vo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by LeeRyu on 2015-07-27.
 * com.church.mngr.bbs.vo
 */
@Alias("boardVO")
public class BoardVO implements Serializable{

    /**
     *
     */
    private int boardSid;
    /**
     *
     */
    private String boardTitle;
    /**
     *
     */
    private String boardSummary;
    /**
     *
     */
    private String boardId;
    /**
     *
     */
    private Date modifyDate;
    /**
     *
     */
    private Date registerDate;
    /**
     *
     */
    private String boardDelFn;
    /**
     *
     */
    private int boardRow;
    /**
     *
     */
    private int boardFileSize;
    /**
     *
     */
    private int boardFileCnt;
    /**
     *
     */
    private int extSid;

    public int getBoardSid() {
        return boardSid;
    }

    public void setBoardSid(int boardSid) {
        this.boardSid = boardSid;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardSummary() {
        return boardSummary;
    }

    public void setBoardSummary(String boardSummary) {
        this.boardSummary = boardSummary;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getBoardDelFn() {
        return boardDelFn;
    }

    public void setBoardDelFn(String boardDelFn) {
        this.boardDelFn = boardDelFn;
    }

    public int getBoardRow() {
        return boardRow;
    }

    public void setBoardRow(int boardRow) {
        this.boardRow = boardRow;
    }

    public int getBoardFileSize() {
        return boardFileSize;
    }

    public void setBoardFileSize(int boardFileSize) {
        this.boardFileSize = boardFileSize;
    }

    public int getBoardFileCnt() {
        return boardFileCnt;
    }

    public void setBoardFileCnt(int boardFileCnt) {
        this.boardFileCnt = boardFileCnt;
    }

    public int getExtSid() {
        return extSid;
    }

    public void setExtSid(int extSid) {
        this.extSid = extSid;
    }
}
