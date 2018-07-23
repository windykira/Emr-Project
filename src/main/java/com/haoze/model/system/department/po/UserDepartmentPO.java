package com.haoze.model.system.department.po;

/**
 * 用户部门关联信息。
 * @author maxl
 * @time 2018-05-08。
 */
public class UserDepartmentPO {

    private String userId;//用户ID
    private String departmentId;//科室ID
    private String pkOrg;//机构ID
    private String departmentCode;//科室编码
    private String departmentName;//科室名称

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
