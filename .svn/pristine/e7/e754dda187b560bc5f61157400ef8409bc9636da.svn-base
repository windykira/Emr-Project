package com.haoze.dao.system;

import com.haoze.model.system.department.po.UserDepartmentPO;
import com.haoze.model.system.user.entity.EmrUserDepartmentEntity;

import java.util.List;

/**
 * 用户部门关联数据操作类。
 * @author maxl
 * @time 2018-05-14。
 */
public interface EmrUserDepartmentDao {

    /**
     * 新增用户部门关联数据
     * @param list
     */
    void batchSave(List<EmrUserDepartmentEntity> list);

    /**
     * 根据用户ID删除用户科室关联关系数据
     * @param userId
     */
    void removeByUserId(String userId);

    /**
     * 查询用户关联科室ID集合
     * @param userId
     * @return
     */
    List<String> listUserDepartments(String userId);

    /**
     *查询用户关联科室列表
     * @return
     */
    List<UserDepartmentPO> listDepartmentsByUserId(String userId);

    /**
     * 查询用户关联全部科室名称
     * @param userId
     * @return
     */
    String getUserDepartmentNames(String userId);
}
