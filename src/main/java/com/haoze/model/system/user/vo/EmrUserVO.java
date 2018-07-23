package com.haoze.model.system.user.vo;

import com.haoze.model.system.user.entity.EmrUserEntity;

import java.util.List;

/**
 * 用户数据封装信息。
 * @author maxl
 * @time 2018-05-07。
 */
public class EmrUserVO{

    private EmrUserEntity emrUser = new EmrUserEntity();
    private List<String> departmentIds;//用户关联部门
    private List<String> roleIds;//用户关联角色

    private String empId;//EMP人员ID

    public EmrUserEntity getEmrUser() {
        return emrUser;
    }

    public void setEmrUser(EmrUserEntity emrUser) {
        this.emrUser = emrUser;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public List<String> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(List<String> departmentIds) {
        this.departmentIds = departmentIds;
    }

}
