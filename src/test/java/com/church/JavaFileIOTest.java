package com.church;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import java.io.*;

/**
 * Created by LeeRyu on 2015-07-19.
 * com.church
 */
public class JavaFileIOTest {

    private static Logger logger = LoggerFactory.getLogger(JavaFileIOTest.class);

    @Test public void Test() {

        String fromPath = "D:\\new-source\\church\\webapp\\upload_data\\sql.txt";
        String toPath = "D:\\new-source\\church\\webapp\\upload_data\\aaa.txt";

        copyFile(fromPath, toPath);

    }

    private void copyFile(String fromPath, String toPath) {

        InputStream in   = null;
        OutputStream out = null;
        byte[] buffer = new byte[1024 * 4];
        try {

            in  = new BufferedInputStream(new FileInputStream(fromPath));
            out = new BufferedOutputStream(new FileOutputStream(toPath));
            int bytesRead = 0;
            while (true) {
                bytesRead = in.read(buffer);
                if (bytesRead == -1)  break;
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) try { in.close(); } catch (IOException e) { e.printStackTrace(); }
            if (out != null) try { out.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    }
    public void AA() {

        File file = new File("D:\\new-source\\church\\webapp\\upload_data\\sql.txt");
        try {
            FileInputStream fis = null;
            FileOutputStream fos = null;
            BufferedOutputStream bs = null;
            fis = new FileInputStream(file);
            fos = new FileOutputStream("D:\\new-source\\church\\webapp\\upload_data\\test1.txt");

            bs = new BufferedOutputStream(fos);

            FileCopyUtils.copy(fis, bs);

            String s = null;

        } catch (FileNotFoundException e) {
            logger.debug("File Not Found" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 버퍼 생성
        BufferedReader br = null;

        // Input 스트림 생성
        InputStreamReader isr = null;

        // File Input 스트림 생성
        FileInputStream fis = null;

        FileOutputStream fileOutputStream = null;

        // 버퍼로 읽어들일 임시 변수
        String temp = "";

        // 최종 내용 출력을 위한 변수
        String content = "";

        try {

            // 파일을 읽어들여 File Input 스트림 객체 생성
            fis = new FileInputStream(file);

            // File Input 스트림 객체를 이용해 Input 스트림 객체를 생서하는데 인코딩을 UTF-8로 지정
            isr = new InputStreamReader(fis, "UTF-8");

            // Input 스트림 객체를 이용하여 버퍼를 생성
            br = new BufferedReader(isr);

            // 버퍼를 한줄한줄 읽어들여 내용 추출
            while ((temp = br.readLine()) != null) {
                content += temp + "\n";
            }

            System.out.println("================== 파일 내용 출력 ==================");
            System.out.println(content);
            System.out.println("================== END ==================");
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try { fis.close(); } catch (IOException e) { e.printStackTrace(); }
            try { isr.close(); } catch (IOException e) { e.printStackTrace(); }
            try { br.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    }
}



