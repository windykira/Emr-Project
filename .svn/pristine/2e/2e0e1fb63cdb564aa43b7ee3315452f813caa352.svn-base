package com.haoze.service.emr.enumeration;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 医疗类型枚举。
 * @author maxl
 * @time 2018-05-17。
 */
public class MtTypeEnum {

    private String enumValue;
    private String enumName;
    private final static Map<String,MtTypeEnum> enumMap = new HashMap();

    /**
     * 门诊。
     */
    public final static MtTypeEnum Outpatient = new MtTypeEnum("OP","门诊");

    /**
     * 住院。
     */
    public final static MtTypeEnum Be_Hospitalized = new MtTypeEnum("IP","住院");

    /**
     * 其他。
     */
    public final static MtTypeEnum Others = new MtTypeEnum("OT","其他");

    /**
     * 门诊住院。
     */
    public final static MtTypeEnum Outpatient_Hospital = new MtTypeEnum("OI","门诊住院");

    private MtTypeEnum(String enumValue, String enumName){
        this.enumValue = enumValue;
        this.enumName = enumName;
    }

    public static MtTypeEnum fromValue(int enumValue){
        if(enumMap.size() == 0) {
            putSourceEnum();
        }
        return enumMap.get(enumValue);
    }

    private static void  putSourceEnum(){

        Class clazz = MtTypeEnum.class;
        Field[] fields = clazz.getDeclaredFields();
        MtTypeEnum enumClass = null;
        for(Field field : fields) {
            if(field.getType().equals(clazz)) {
                try {
                    enumClass = (MtTypeEnum)field.get(null);
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
