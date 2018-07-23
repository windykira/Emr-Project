package com.haoze.service.system;

import com.haoze.common.model.QueryParam;
import com.haoze.common.model.Tree;
import com.haoze.model.system.department.entity.EmrDepartmentEntity;
import com.haoze.model.system.department.po.UserDepartmentPO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 科室数据服务接口。
 * @author maxl
 * @time 2018-05-08。
 */
@Service
public interface EmrDepartmentService {

    /**
     * 查询用户关联部门信息
     * @param userId
     * @return
     */
    List<EmrDepartmentEntity> listEmrDepartmentsByUserId(String userId);

    /**
     * 查询科室列表
     * @param paramMap
     * @return
     */
    List<EmrDepartmentEntity> listEmrDepartments(Map<String, Object> paramMap);

    /**
     * 查询科室列表数量
     * @param paramMap
     * @return
     */
    int count(Map<String, Object> paramMap);
    
    /**
     * 查询科室列表
     * @param queryParam
     * @return
     */
	List<EmrDepartmentEntity> list(QueryParam queryParam);
	
	 /**
     * 新增科室
     * @param params
     * @return
     */
	int save(Map<String, Object> params);

    /**
     * 获取部门数据
     * @return
     */
    Tree<EmrDepartmentEntity> getTree(Map<String, Object> paramMap);

    /**
     * 获取部门详情
     * @param departmentId
     * @return
     */
    EmrDepartmentEntity get(String departmentId);
}
