package com.haoze.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 构建Http请求工具。
 *
 * @author maxl
 * @time 2018-07-12。
 */
public class HttpClientRequest {

    public static String postRequest(String url, Map<String, Object> paramMap, String encoding) {

        CloseableHttpClient httpClient = null;
        String responseData = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            //设置参数
            List<NameValuePair> nameValuePairs = new ArrayList();
            Iterator iterator = paramMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> valuePairMap = (Map.Entry<String, String>) iterator.next();
                nameValuePairs.add(new BasicNameValuePair(valuePairMap.getKey(), String.valueOf(valuePairMap.getValue())));
            }
            if (nameValuePairs.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nameValuePairs, encoding);
                httpPost.setEntity(entity);
            }
            //发送post请求
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity httpEntity = response.getEntity();
                if (httpEntity != null) {
                    responseData = EntityUtils.toString(httpEntity, encoding);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return responseData;
    }


}
