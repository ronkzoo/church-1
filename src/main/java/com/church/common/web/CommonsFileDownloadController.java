package com.church.common.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
/**
 * Created by LeeRyu on 2015-07-20.
 * com.church.common.web
 */
@Controller
public class CommonsFileDownloadController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/d/{fileName:\\w*.\\w{3}}", method = RequestMethod.GET)
    public void CommonsFileDownload(HttpServletRequest request, HttpServletResponse response,
        @PathVariable String fileName) throws  Exception {

        File file = new File("D:\\new-source\\church\\webapp\\upload_data\\" + "aaa.txt");

        logger.debug("fileName :  " + fileName);
        /* found not file */
        if(!file.exists()) {
            throw new FileNotFoundException(fileName);
        }

        int fSize = (int)file.length();

        response.setContentType("application/octet-stream");
        setDispostion(fileName, request, response);
        response.setContentLength(fSize);
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Cache-Control", "cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");

        ServletOutputStream fileOut = response.getOutputStream();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);

            FileCopyUtils.copy(fis, fileOut);

            response.flushBuffer();

        } catch (IOException e) {
            logger.debug("IGNORED : " + e.getMessage());
        } finally {
            if (fis != null) {
                try { fis.close(); } catch (Exception ignore) { logger.debug("IGNORED: " + ignore.getMessage()); }
            }
        }

        fileOut.flush();
        fileOut.close();
    }


    /**
     * @param fileName
     * @param request
     * @param response
     * @throws Exception
     */
    private void setDispostion(String fileName, HttpServletRequest request,
        HttpServletResponse response) throws  Exception{

        String browser = getBrowser(request);

        String dispositionPrefix = "attachment; filename=";
        String encodedFilename = null;

        encodedFilename= URLEncoder.encode(fileName, "UTF-8");

        response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);

        if ("Opera".equals(browser)){
            response.setContentType("application/octet-stream;charset=UTF-8");
        }
    }

    private String getBrowser(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        if (header.indexOf("MSIE") > -1) {
            return "MSIE";
        } else if (header.indexOf("Chrome") > -1) {
            return "Chrome";
        } else if (header.indexOf("Opera") > -1) {
            return "Opera";
        } else if (header.indexOf("Safari") > -1) {
            return "Safari";
        }
        return "Firefox";
    }

}
