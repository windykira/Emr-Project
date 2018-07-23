package com.haoze.dao.system;

import com.haoze.model.system.department.entity.EmrDepartmentEntity;

import java.util.List;
import java.util.Map;

/**
 * 科室数据操作类。
 * @author maxl
 * @time 2018-05-08。
 */
public interface EmrDepartmentDao {

    /**
     * 查询用户关联科室
     * @param userId
     * @return
     */
    List<EmrDepartmentEntity> listEmrDepartmentsByUserId(String userId);

    List<EmrDepartmentEntity> listEmrDepartments(Map<String, Object> paramMap);

    int countUserDepartments(Map<String, Object> paramMap);
    
    int count(Map<String, Object> paramMap);
    
    List<EmrDepartmentEntity> list(Map<String, Object> paramMap);

	int save(Map<String, Object> params);

    /**
     * 获取部门详情
     * @param departmentId
     * @return
     */
    EmrDepartmentEntity get(String departmentId);
}
