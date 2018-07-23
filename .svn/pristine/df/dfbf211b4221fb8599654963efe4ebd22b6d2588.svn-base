package com.haoze.utils;

import com.haoze.common.enumeration.common.DelFlagEnum;
import com.haoze.common.model.BaseEntity;

import java.util.Date;

/**
 * 固定字段初始化工具。
 * @author maxl
 * @time 2018-05-18。
 */
public class FixedFieldInitializedUtil {

    public static void initialize(BaseEntity baseEntity){

        baseEntity.setID(UUIDUtil.randomString());
        baseEntity.setDelFlag(DelFlagEnum.Not_Deleted.getEnumValue());
        baseEntity.setCreator(CurrentUser.getUserId());
        baseEntity.setCreateTime(new Date());
        baseEntity.setModifier(CurrentUser.getUserId());
        baseEntity.setModifyTime(new Date());
    }
}
