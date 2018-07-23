package com.haoze.utils;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 時間格式化工具。
 * @author maxl
 * @time 2018-05-05。
 */
public class DateFormatUtil {

    private static  SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date parseDate(String date) throws ParseException {

        Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{1,2}-[0-3]{1,2} [0-4]{1,2}:[0-9]{1,2}:[0-9]{1,2}");
        Matcher matcher = pattern.matcher(date);
        if(!matcher.find()){
            throw new IllegalArgumentException("错误格式的时间表达式。");
        }
        return defaultFormat.parse(date);
    }

    public static Date parseDate(String date,String regulation) throws ParseException {
        if(StringUtils.isNotEmpty(regulation)){
            SimpleDateFormat innerFormat = new SimpleDateFormat(regulation);
            return innerFormat.parse(date);
        }
        return defaultFormat.parse(date);
    }

    public static String formatDate(Date date,String regulation){
        if(StringUtils.isNotEmpty(regulation)){
            SimpleDateFormat innerFormat = new SimpleDateFormat(regulation);
            return innerFormat.format(date);
        }
        return defaultFormat.format(date);
    }

    public static String formatDate(Date date){
        return defaultFormat.format(date);
    }
}
