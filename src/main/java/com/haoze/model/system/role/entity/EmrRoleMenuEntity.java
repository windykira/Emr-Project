package com.haoze.model.system.role.entity;

import com.haoze.common.model.BaseEntity;

/**
 * 角色菜单关联信息。
 * @author maxl
 * @time 2018-05-10。
 */
public class EmrRoleMenuEntity extends BaseEntity {

    private String pkRoleMenu;//ID
    private String pkOrg;//所属机构
    private String pkRole;//角色
    private String pkMenu;//菜单

    public String getPkRoleMenu() {
        return pkRoleMenu;
    }

    public void setPkRoleMenu(String pkRoleMenu) {
        this.pkRoleMenu = pkRoleMenu == null ? null : pkRoleMenu.trim();
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    public String getPkRole() {
        return pkRole;
    }

    public void setPkRole(String pkRole) {
        this.pkRole = pkRole == null ? null : pkRole.trim();
    }

    public String getPkMenu() {
        return pkMenu;
    }

    public void setPkMenu(String pkMenu) {
        this.pkMenu = pkMenu == null ? null : pkMenu.trim();
    }

}
