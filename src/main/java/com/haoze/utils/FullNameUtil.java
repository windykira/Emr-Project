package com.haoze.utils;

import com.haoze.model.system.department.entity.EmrDepartmentEntity;

import java.util.List;

/**
 * 全称工具。
 * @author maxl
 * @time 2018-05-14。
 */
public class FullNameUtil {

    public static String getFullDepartmentName(List<EmrDepartmentEntity> departments) {

        int length = departments.size();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (i == (length - 1)) {
                buffer.append(departments.get(i).getDepartmentName());
            } else {
                buffer.append(departments.get(i).getDepartmentName()).append(",");
            }
        }
        return buffer.toString();
    }
}
