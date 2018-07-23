package com.haoze.utils;

import java.util.UUID;

/**
 * UUID工具。
 * @author maxl
 * @time 2018-05-09。
 */
public class UUIDUtil {

    public static String randomString(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
