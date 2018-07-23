package com.haoze.service.emr.enumeration;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 模板类型枚举。
 * @author maxl
 * @time 2018-05-31。
 */
public class TemplateClassTypeEnum {

    private String enumValue;
    private String enumName;
    private final static Map<String,TemplateClassTypeEnum> enumMap = new HashMap();

    /**
     * 全院。
     */
    public final static TemplateClassTypeEnum Hospital = new TemplateClassTypeEnum("1","全院");

    /**
     * 科室。
     */
    public final static TemplateClassTypeEnum Department = new TemplateClassTypeEnum("2","科室");

    /**
     * 个人。
     */
    public final static TemplateClassTypeEnum Personal = new TemplateClassTypeEnum("3","个人");

    private TemplateClassTypeEnum(String enumValue, String enumName){
        this.enumValue = enumValue;
        this.enumName = enumName;
    }

    public static TemplateClassTypeEnum fromValue(int enumValue){
        if(enumMap.size() == 0) {
            putSourceEnum();
        }
        return enumMap.get(enumValue);
    }

    private static void  putSourceEnum(){

        Class clazz = TemplateClassTypeEnum.class;
        Field[] fields = clazz.getDeclaredFields();
        TemplateClassTypeEnum enumClass = null;
        for(Field field : fields) {
            if(field.getType().equals(clazz)) {
                try {
                    enumClass = (TemplateClassTypeEnum)field.get(null);
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
