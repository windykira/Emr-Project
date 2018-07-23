package com.haoze.dao.system;

import com.haoze.model.system.user.entity.EmrUserRoleEntity;

import java.util.List;

/**
 * 用户角色关联数据操作类。
 * @author maxl
 * @time 2018-05-07。
 */
public interface EmrUserRoleDao {

    /**
     * 新增用户部门关联数据
     * @param list
     */
    void batchSave(List<EmrUserRoleEntity> list);

    /**
     * 查询用户关联角色ID
     * @param userId
     * @return
     */
    List<String> listUserRoleIds(String userId);

    /**
     * 删除用户角色关联关系
     * @param userId
     */
    void removeByUserId(String userId);

    /**
     * 查询用户关联全部角色名称
     * @param userId
     * @return
     */
    String getUserRoleNames(String userId);

}
