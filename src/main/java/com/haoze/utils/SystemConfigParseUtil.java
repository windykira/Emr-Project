package com.haoze.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties配置文件操作工具。
 * @author maxl
 * @time 2018-05-02
 */
public class SystemConfigParseUtil {

    public static String getProperty(String key) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = SystemConfigParseUtil.class.getClassLoader().getResourceAsStream("env.properties");
        properties.load(inputStream);
        properties.get(key);
        return properties.get(key) == null ? "" : properties.get(key).toString();
    }
}
