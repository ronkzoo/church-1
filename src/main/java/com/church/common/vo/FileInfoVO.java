package com.church.common.vo;

/**
 * Created by LeeRyu on 2015-07-28.
 * com.church.common.vo
 */
public class FileInfoVO extends ComDefaultVO{

    private String filePath;
    private String fileNm;
    private long fileSize;
    private int fileNo;
    private String inputfileNm;
    private String fileMaskNm;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileNm() {
        return fileNm;
    }

    public void setFileNm(String fileNm) {
        this.fileNm = fileNm;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public int getFileNo() {
        return fileNo;
    }

    public void setFileNo(int fileNo) {
        this.fileNo = fileNo;
    }

    public String getInputfileNm() {
        return inputfileNm;
    }

    public void setInputfileNm(String inputfileNm) {
        this.inputfileNm = inputfileNm;
    }

    public String getFileMaskNm() {
        return fileMaskNm;
    }

    public void setFileMaskNm(String fileMaskNm) {
        this.fileMaskNm = fileMaskNm;
    }
}
