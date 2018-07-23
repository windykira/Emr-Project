package com.haoze.dao.system;

import com.haoze.model.system.menu.entity.EmrMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 菜单数据操作类。
 * @author maxl
 * @time 2018-05-07。
 */
public interface EmrMenuDao {

    /**
     * 新增菜单
     * @param emrMenuEntity
     * @return
     */
    void save(EmrMenuEntity emrMenuEntity);

    /**
     * 删除菜单
     * @param menuID
     * @return
     */
    void remove(String menuID);

    /**
     * 更新菜单
     * @param emrMenuEntity
     */
    void update(EmrMenuEntity emrMenuEntity);

    /**
     * 查询子菜单
     * @param menuID
     * @return
     */
    List<EmrMenuEntity> listChildrenMenus(String menuID);

    List<EmrMenuEntity> listMenusByUserID(String userID);

    List<String> listUserPermissions(String userID);

    List<String> listUserRoles(String userID);
    /**
     * 查詢菜单列表
     * @param params
     * @return
     */
    List<EmrMenuEntity> listMenus(Map<String, Object> params);

    /**
     * 根据ID获取菜单信息
     * @param menuID
     * @return
     */
    EmrMenuEntity get(String menuID);

	List<Map> getSubMenuByName(String name);
}
