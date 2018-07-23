package com.haoze.model.system.department.entity;

import com.haoze.common.model.BaseEntity;

import java.math.BigDecimal;

/**
 * 科室基本信息。
 * @author maxl
 * @time 2018-05-08。
 */
public class EmrDepartmentEntity extends BaseEntity{

    private String organizationID;//所属机构
    private String departmentCode;//科室编码
    private String departmentName;//科室名称
    private String parentDepartmentID;//上级科室
    private String departmentLevel;//科室等级
    private String departmentType;//科室类型
    private String abbreviationName;//简称
    private String pyCode;//拼音码
    private String wbCode;//五笔码
    private String description;//科室简介
    private String note;//备注
    private String departmentPhone;//科室电话
    private BigDecimal dataVersion;//数据版本
    private String mtType;//医疗类型：OP:门诊，IP:住院，OT:其他，OI:门诊住院

    public String getMtType() {
        return mtType;
    }

    public void setMtType(String mtType) {
        this.mtType = mtType;
    }

    public String getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(String organizationID) {
        this.organizationID = organizationID;
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

    public String getParentDepartmentID() {
        return parentDepartmentID;
    }

    public void setParentDepartmentID(String parentDepartmentID) {
        this.parentDepartmentID = parentDepartmentID;
    }

    public String getDepartmentLevel() {
        return departmentLevel;
    }

    public void setDepartmentLevel(String departmentLevel) {
        this.departmentLevel = departmentLevel;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public String getAbbreviationName() {
        return abbreviationName;
    }

    public void setAbbreviationName(String abbreviationName) {
        this.abbreviationName = abbreviationName;
    }

    public String getPyCode() {
        return pyCode;
    }

    public void setPyCode(String pyCode) {
        this.pyCode = pyCode;
    }

    public String getWbCode() {
        return wbCode;
    }

    public void setWbCode(String wbCode) {
        this.wbCode = wbCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDepartmentPhone() {
        return departmentPhone;
    }

    public void setDepartmentPhone(String departmentPhone) {
        this.departmentPhone = departmentPhone;
    }

    public BigDecimal getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(BigDecimal dataVersion) {
        this.dataVersion = dataVersion;
    }
}
