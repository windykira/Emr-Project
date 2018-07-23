package com.haoze.common.enumeration.common;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 是否逻辑删除类型枚举。
 * @author maxl
 * @time 2018-05-17。
 */
public class DelFlagEnum {

    private String enumValue;
    private String enumName;
    private final static Map<String,DelFlagEnum> enumMap = new HashMap();

    /**
     * 未删除。
     */
    public final static DelFlagEnum Not_Deleted = new DelFlagEnum("0","未删除");

    /**
     * 已删除。
     */
    public final static DelFlagEnum Deleted = new DelFlagEnum("1","已删除");

    private DelFlagEnum(String enumValue, String enumName){
        this.enumValue = enumValue;
        this.enumName = enumName;
    }

    public static DelFlagEnum fromValue(int enumValue){
        if(enumMap.size() == 0) {
            putSourceEnum();
        }
        return enumMap.get(enumValue);
    }

    private static void  putSourceEnum(){

        Class clazz = DelFlagEnum.class;
        Field[] fields = clazz.getDeclaredFields();
        DelFlagEnum enumClass = null;
        for(Field field : fields) {
            if(field.getType().equals(clazz)) {
                try {
                    enumClass = (DelFlagEnum)field.get(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if(enumClass != null) {
                    enumMap.put(enumClass.getEnumValue(),enumClass);
                }
            }
        }
    }


    public String getEnumValue() {
        return enumValue;
    }

    public String getEnumName() {
        return enumName;
    }
}
