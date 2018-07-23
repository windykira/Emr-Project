package com.haoze.dao.system;

import com.github.pagehelper.Page;
import com.haoze.model.system.user.entity.EmrUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户数据操作类。
 * @author maxl
 * @time 2018-05-07。
 */
public interface EmrUserDao {

    /**
     * 新增用户
     * @param list
     */
    void batchSave(List<EmrUserEntity> list);

    /**
     * 新增用户信息
     * @param emrUserEntity
     */
    void save(EmrUserEntity emrUserEntity);

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    EmrUserEntity get(String userId);

    /**
     * 根据账号和密码获取用户信息
     * @param paramMap
     * @return
     */
    EmrUserEntity getByAccountAndPassword(Map<String,Object> paramMap);

    /**
     * 删除用户
     * @param userId
     */
    void remove(String userId);

    /**
     * 更新用户
     * @param emrUserEntity
     */
    void update(EmrUserEntity emrUserEntity);

    /**
     * 根据条件查询用户列表
     * @param map
     * @return
     */
    Page<EmrUserEntity> listUsers(Map<String, Object> map);

    /**
     * 统计用户数量
     * @param map
     * @return
     */
    int countUsers(Map<String, Object> map);
}
