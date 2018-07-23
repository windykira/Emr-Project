package com.haoze.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 文件生成。
 * @author maxl
 * @time 2018-06-21。
 */
public class FileUpload {

    private MultipartFile file;
    private String xmlContent;
    private String path;

    public static void upload(String xmlContent, String path, String fileName) throws IOException {

        if (StringUtils.isEmpty(xmlContent)) {
            return;
        }
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(new File(path + fileName));
        OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
        osw.write(xmlContent);
        osw.flush();

        if (osw != null) {
            osw.close();
        }
        if (out != null) {
            out.close();
        }
    }

    public static void delete(File file) {

        if (file.isDirectory()) {
            String[] children = file.list();
            for (int i = 0; i < children.length; i++) {
                delete(new File(file, children[i]));
            }
        }
        file.delete();
    }
}
