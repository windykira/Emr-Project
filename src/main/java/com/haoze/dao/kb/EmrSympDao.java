package com.haoze.dao.kb;

import java.util.List;
import java.util.Map;

import com.haoze.model.kb.symp.entity.SympEntity;

/**
 * 角色数据操作类。
 * @author maxl
 * @time 2018-05-09。
 */
public interface EmrSympDao {


    /**
     * 新增角色
     * @param role
     * @return 
     */
    int save(SympEntity role);

    /**
     * 删除角色
     * @param roleId
     */
    void remove(String sympId);

    /**
     * 更新角色
     * @param role
     */
    void update(SympEntity role);

    /**
     * 查询角色列表
     * @param paramsMap
     * @return
     */
    List<SympEntity> list();

    /**
     * 获取角色详情
     * @param roleId
     * @return
     */
    SympEntity get(String roleId);
    
    SympEntity getByName(String sympName);

}
