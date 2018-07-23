package com.haoze.dao.system;

import com.haoze.model.system.role.entity.EmrRoleMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色菜单关联数据操作类。
 * @author maxl
 * @time 2018-05-09。
 */
public interface EmrRoleMenuDao {

    int deleteByPrimaryKey(EmrRoleMenuEntity key);
    int insert(EmrRoleMenuEntity record);

    /**
     * 新增角色菜单关联关系
     * @param record
     * @return
     */
    int insertSelective(EmrRoleMenuEntity record);

    /**
     *
     * @param roleId
     * @return
     */
    void removeByRoleId(String roleId);

    /**
     * 批量新增角色菜单关联关系
     * @param list
     */
    void batchSave(List<EmrRoleMenuEntity> list);

    /**
     * 查询角色关联菜单
     * @param roleId
     * @return
     */
    List<String> listMenuIdsByRoleId(String roleId);

    /**
     * 统计数量
     * @param paramMap
     * @return
     */
    int count(Map<String, Object> paramMap);
}