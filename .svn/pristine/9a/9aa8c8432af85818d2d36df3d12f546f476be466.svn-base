package com.haoze.service.emr.enumeration;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * HIS调用接口类型枚举。
 * @author maxl
 * @time 2018-06-03。
 */
public class HisCallTypeEnum {

    private String enumValue;
    private String enumName;
    private final static Map<String,HisCallTypeEnum> enumMap = new HashMap();


    /**
     * 医嘱。
     */
    public final static HisCallTypeEnum DoctorAdice = new HisCallTypeEnum("1","医嘱");

    /**
     * 检查。
     */
    public final static HisCallTypeEnum PatientCheckUp = new HisCallTypeEnum("2","检查");

    /**
     * 检验汇总。
     */
    public final static HisCallTypeEnum PatientInspect = new HisCallTypeEnum("3","检验汇总");

    /**
     * 检验明细。
     */
    public final static HisCallTypeEnum PatientDetailInspect = new HisCallTypeEnum("7","检验明细");

    /**
     * 处方。
     */
    public final static HisCallTypeEnum Prescription = new HisCallTypeEnum("4","处方");

    /**
     * 手术。
     */
    public final static HisCallTypeEnum Operation = new HisCallTypeEnum("5","手术");

    /**
     * 病人列表。
     */
    public final static HisCallTypeEnum PatientList = new HisCallTypeEnum("6","病人列表");

    private HisCallTypeEnum(String enumValue, String enumName){
        this.enumValue = enumValue;
        this.enumName = enumName;
    }

    public static HisCallTypeEnum fromValue(String enumValue){
        if(enumMap.size() == 0) {
            putSourceEnum();
        }
        return enumMap.get(enumValue);
    }

    private static void  putSourceEnum(){

        Class clazz = HisCallTypeEnum.class;
        Field[] fields = clazz.getDeclaredFields();
        HisCallTypeEnum enumClass = null;
        for(Field field : fields) {
            if(field.getType().equals(clazz)) {
                try {
                    enumClass = (HisCallTypeEnum)field.get(null);
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
