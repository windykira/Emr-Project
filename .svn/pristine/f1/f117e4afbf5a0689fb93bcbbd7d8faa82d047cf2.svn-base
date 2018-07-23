package com.haoze.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.haoze.model.emr.emrwriting.po.HisPatientCheckupPO;
import com.haoze.model.emr.emrwriting.po.HisResponseDataPO;

import java.util.List;

/**
 * JSON解析工具。
 * @author maxl
 * @time 2018-05-17。
 */
public class GsonUtil<T> {

    private static Gson gson = new Gson();

    public static String toJson(Object object){
        return gson.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> clazz){
        return gson.fromJson(json,clazz);
    }

}
