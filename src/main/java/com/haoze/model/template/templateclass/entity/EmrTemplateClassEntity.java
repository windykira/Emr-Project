package com.haoze.model.template.templateclass.entity;

import com.haoze.common.model.BaseEntity;


/**
 * 模板类型基本信息。
 * @author maxl
 * @time 2018-05-31。
 */
public class EmrTemplateClassEntity extends BaseEntity{

    private String pkOrg;//机构
    private String codeClass;//模板类型编码
    private String nameClass;//模板类型名称
    private String pyCode;//拼音码
    private String wbCode;//五笔码
    private String pkCatalog;//
    private String stopFlag;//状态：1-启用，0-停用

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    public String getCodeClass() {
        return codeClass;
    }

    public void setCodeClass(String codeClass) {
        this.codeClass = codeClass == null ? null : codeClass.trim();
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass == null ? null : nameClass.trim();
    }

    public String getPyCode() {
        return pyCode;
    }

    public void setPyCode(String pyCode) {
        this.pyCode = pyCode == null ? null : pyCode.trim();
    }

    public String getWbCode() {
        return wbCode;
    }

    public void setWbCode(String wbCode) {
        this.wbCode = wbCode == null ? null : wbCode.trim();
    }

    public String getPkCatalog() {
        return pkCatalog;
    }

    public void setPkCatalog(String pkCatalog) {
        this.pkCatalog = pkCatalog == null ? null : pkCatalog.trim();
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag == null ? null : stopFlag.trim();
    }

}