package com.haoze.model.emr.emrwriting.entity;

import com.haoze.common.model.BaseEntity;

import java.util.Date;

public class EmrFileEntity extends BaseEntity{

    private String pkOrg;//所属机构
    private String pkDept;//科室主键
    private String codeDept;//科室编码
    private String pkTmpClass;//病历类型
    private String patientId;//住院病人编号(住院号)
    private String fileLoc;//病历文件存放路径(相对路径)
    private String opNum;//门（急）诊号
    private String emrFileName;//病历文件名称
    private String lockFlag;//锁定标记 0：正常  1：已锁定
    private String locker;//锁定医生主键
    private Date lockTime;//锁定时间
    private String pkTemplate;//病历来源模板ID

    private String catalogId;//病历目录ID
    private String parentCatalogId;//病历目录父ID

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getParentCatalogId() {
        return parentCatalogId;
    }

    public void setParentCatalogId(String parentCatalogId) {
        this.parentCatalogId = parentCatalogId;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    public String getPkDept() {
        return pkDept;
    }

    public void setPkDept(String pkDept) {
        this.pkDept = pkDept == null ? null : pkDept.trim();
    }

    public String getCodeDept() {
        return codeDept;
    }

    public void setCodeDept(String codeDept) {
        this.codeDept = codeDept == null ? null : codeDept.trim();
    }

    public String getPkTmpClass() {
        return pkTmpClass;
    }

    public void setPkTmpClass(String pkTmpClass) {
        this.pkTmpClass = pkTmpClass == null ? null : pkTmpClass.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getFileLoc() {
        return fileLoc;
    }

    public void setFileLoc(String fileLoc) {
        this.fileLoc = fileLoc == null ? null : fileLoc.trim();
    }

    public String getOpNum() {
        return opNum;
    }

    public void setOpNum(String opNum) {
        this.opNum = opNum == null ? null : opNum.trim();
    }

    public String getEmrFileName() {
        return emrFileName;
    }

    public void setEmrFileName(String emrFileName) {
        this.emrFileName = emrFileName == null ? null : emrFileName.trim();
    }

    public String getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag == null ? null : lockFlag.trim();
    }

    public String getLocker() {
        return locker;
    }

    public void setLocker(String locker) {
        this.locker = locker == null ? null : locker.trim();
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public String getPkTemplate() {
        return pkTemplate;
    }

    public void setPkTemplate(String pkTemplate) {
        this.pkTemplate = pkTemplate == null ? null : pkTemplate.trim();
    }
}