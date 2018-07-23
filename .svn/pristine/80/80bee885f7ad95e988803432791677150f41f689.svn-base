package com.haoze.dao.system;

import com.haoze.model.system.role.entity.EmrRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色数据操作类。
 * @author maxl
 * @time 2018-05-09。
 */
public interface EmrRoleDao {


    /**
     * 新增角色
     * @param role
     */
    void save(EmrRoleEntity role);

    /**
     * 删除角色
     * @param roleId
     */
    void remove(String roleId);

    /**
     * 更新角色
     * @param role
     */
    void update(EmrRoleEntity role);

    /**
     * 查询角色列表
     * @param paramsMap
     * @return
     */
    List<EmrRoleEntity> listRoles(Map<String, Object> paramsMap);

    /**
     * 获取角色详情
     * @param roleId
     * @return
     */
    EmrRoleEntity get(String roleId);

}
