package com.haoze.dao.kb;

import java.util.List;

import com.haoze.model.kb.symp.entity.SimuSympEntity;

/**
 * 角色数据操作类。
 * @author maxl
 * @time 2018-05-09。
 */
public interface EmrSimuSympDao {


	  /**
     * 新增角色
     * @param role
     * @return 
     */
    int save(SimuSympEntity role);

    /**
     * 删除角色
     * @param roleId
     */
    void remove(String sympId);

    /**
     * 更新角色
     * @param role
     */
    void update(SimuSympEntity role);

    /**
     * 查询角色列表
     * @param paramsMap
     * @return
     */
    List<SimuSympEntity> list();

    /**
     * 获取角色详情
     * @param roleId
     * @return
     */
    SimuSympEntity get(String roleId);
    
    SimuSympEntity getByName(String simuSympName);

}
