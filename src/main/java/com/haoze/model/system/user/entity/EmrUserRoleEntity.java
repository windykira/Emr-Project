package com.haoze.model.system.user.entity;

import com.haoze.common.model.BaseEntity;

/**
 * 用户角色关联数据基本信息。
 * @author maxl
 * @time 2018-05-14。
 */
public class EmrUserRoleEntity extends BaseEntity{

    private String organization;//所属机构
    private String userId;//用户ID
    private String roleId;//角色ID

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
