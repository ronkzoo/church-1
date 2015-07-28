package com.church.common.util;

import com.church.common.vo.FileInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.*;

/**
 *
 *
 *
 * Created by LeeRyu on 2015-07-28.
 * com.church.common.util
 */
public class FileUploadUtil {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public List uploadFile(MultipartHttpServletRequest request, String userUploadpath)
        throws Exception {

        return uploadFile(request, userUploadpath, "");
    }

    public List uploadFile(MultipartHttpServletRequest multiRequest, String userUploadPath,
        String limitFileExt) throws Exception {

        HashMap fileMap = new HashMap();

        String uploadPath = userUploadPath;
        this.logger.info("파일위치 :: " + uploadPath);

        MultiValueMap files = multiRequest.getMultiFileMap();
        Assert.notNull(files, "files is null");
        Assert.state(files.size() > 0, "0 files exist");

        File saveFolder = new File(uploadPath);

        if ((!(saveFolder.exists())) || (saveFolder.isFile())) {
            saveFolder.mkdirs();
        }

        Iterator itr = files.entrySet().iterator();
        List fileInfoList = new ArrayList();

        int loopcount = 0;
        int fileCnt = 1;
        System.out.print("=================================================================");
        System.out.println();
        System.out.print("파일 루프 카운트");
        System.out.println();
        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();

            List listFiles = (List) entry.getValue();

            for (Object obj : listFiles) {
                MultipartFile file = (MultipartFile) obj;
                System.out.println(file.getName() + " : " + (loopcount++));
                System.out.println();

                if (!("".equals(file.getOriginalFilename()))) {
                    String originalFileName = file.getOriginalFilename();
                    originalFileName = originalFileName.replace("..", "");
                    originalFileName = originalFileName.replace(";", "");
                    originalFileName = originalFileName.replace("%", "");
                    originalFileName = originalFileName.replace(" ", "");
                    if ((!(CommonUtil.Upload_Filter(originalFileName).booleanValue()))
                        || (!(isPermitExt(originalFileName, limitFileExt)))) {
                        throw new Exception("limited file upload extention");
                    }

                    String reFileNm =
                        CommonUtil.generateKey() + CommonUtil.getExtension(originalFileName);
                    String filePath = uploadPath + "/" + reFileNm;
                    file.transferTo(new File(filePath));

                    FileInfoVO fileInfoVO = new FileInfoVO();

                    fileInfoVO.setInputfileNm(file.getName());

                    fileInfoVO.setFilePath(filePath);

                    fileInfoVO.setFileNm(originalFileName);

                    fileInfoVO.setFileMaskNm(reFileNm);

                    fileInfoVO.setFileSize(file.getSize());

                    fileInfoVO.setFileNo(fileCnt);

                    this.logger.info("확장자 ::: " + file.getContentType());
                    fileInfoList.add(fileInfoVO);
                    ++fileCnt;
                } else {
                    FileInfoVO fileInfoVO = new FileInfoVO();
                    fileInfoVO.setFileNm("");
                    fileInfoList.add(fileInfoVO);
                }
            }
        }
        System.out.print("=================================================================");
        System.out.println();
        return fileInfoList;
    }

    public boolean isPermitExt(String originalFileName, String limitFileExt) {
        String file_ext =
            originalFileName.substring(originalFileName.lastIndexOf(46) + 1).toLowerCase();
        if ((limitFileExt == null) || (limitFileExt.equals(""))) {
            return true;
        }
        String[] limitExtArr = limitFileExt.split(",");

        String limitExt = "";

        String passExt = "";

        for (int i = 0; i < limitExtArr.length; ++i) {
            if (limitExtArr[i].indexOf("!") >= 0) {
                if (!(limitExt.equals(""))) {
                    limitExt = limitExt + ",";
                }
                limitExt = limitExt + limitExtArr[i].replace("!", "").toLowerCase();
            } else {
                if (!(passExt.equals(""))) {
                    passExt = passExt + ",";
                }
                passExt = passExt + limitExtArr[i].toLowerCase();
            }

        }

        String[] fileExtArray = limitExt.split(",");
        int i = 0;
        for (String noExt : fileExtArray) {
            if (noExt.toLowerCase().equals(file_ext)) {
                ++i;
            }
        }

        if (i > 0) {
            return false;
        }

        if (!(passExt.equals(""))) {
            String[] fileExtArray2 = passExt.split(",");
            i = 0;
            for (String noExt : fileExtArray2) {
                if (noExt.toLowerCase().equals(file_ext)) {
                    ++i;
                }

            }

            if (i <= 0) {
                return false;
            }
        }
        return true;
    }
}
