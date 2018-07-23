package com.haoze.service.system.enumeration.user;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 用戶创建状态类型枚举。
 * @author maxl
 * @time 2018-05-17。
 */
public class UserCreateStatusEnum {

    private String enumValue;
    private String enumName;
    private final static Map<String,UserCreateStatusEnum> enumMap = new HashMap();

    /**
     * 未创建。
     */
    public final static UserCreateStatusEnum Not_Created = new UserCreateStatusEnum("1","未创建");

    /**
     * 已创建。
     */
    public final static UserCreateStatusEnum Created = new UserCreateStatusEnum("2","已创建");

    private UserCreateStatusEnum(String enumValue, String enumName){
        this.enumValue = enumValue;
        this.enumName = enumName;
    }

    public static UserCreateStatusEnum fromValue(int enumValue){
        if(enumMap.size() == 0) {
            putSourceEnum();
        }
        return enumMap.get(enumValue);
    }

    private static void  putSourceEnum(){

        Class clazz = UserCreateStatusEnum.class;
        Field[] fields = clazz.getDeclaredFields();
        UserCreateStatusEnum enumClass = null;
        for(Field field : fields) {
            if(field.getType().equals(clazz)) {
                try {
                    enumClass = (UserCreateStatusEnum)field.get(null);
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
