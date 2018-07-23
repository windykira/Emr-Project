package com.haoze.utils;

import com.haoze.service.emr.enumeration.HisCallTypeEnum;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Map;

/**
 * 构建Http请求工具。
 * @author maxl
 * @time 2018-05-04。
 */
public class JsoupHttpRequest {

    public static Connection.Response sendHttpRequest(String url, String cookie, Map<String, Object> dataMap) throws IOException {
        Connection connection = Jsoup.connect(url);
        connection.header("Accept", "text/html, application/xhtml+xml, */*");
        connection.header("Content-Type", "application/x-www-form-urlencoded");
        if (StringUtils.isNotEmpty(cookie)) {
            connection.header("Cookie", cookie);
        }
        if (dataMap != null) {
            for (Map.Entry<String, Object> map : dataMap.entrySet()) {
                connection.data(map.getKey(), String.valueOf(map.getValue()));
            }
        }
        Connection.Response response = connection.ignoreContentType(true).timeout(18000).execute();
        //Connection.Response response = connection.method(Connection.Method.POST).timeout(18000).execute();
        return response;
    }

    public static void main(String[] args){
        try {
            Map<String,Object> map = new HashedMap();
            map.put("INDATE","2018-05-14");
            map.put("hisCallType", HisCallTypeEnum.DoctorAdice.getEnumValue());
            HttpClientRequest.postRequest(SystemConfigParseUtil.getProperty("HIS_HTTP_RESPONSE"),map,"UTF-8");
            /*Connection.Response response = sendHttpRequest(SystemConfigParseUtil.getProperty("HIS_HTTP_RESPONSE"),"",map);
            String body = response.body();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
