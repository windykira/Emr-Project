package com.haoze.model.repository.entity;

import com.haoze.common.model.BaseEntity;

import java.util.Date;

/**
 * 数据元域基本实体信息。
 * @author maxl
 * @time 2018-07-17。
 */
public class DataElementValuesEntity extends BaseEntity{

    private String pkDataEleVal;//主键
    private String pkOrg;//机构
    private String codeDeVal;//数据元值域实际值
    private String nameDeVal;//数据元值域值含义
    private String pyCode;//拼音码
    private String wbCode;//五笔码
    private String describe;//数据元值域说明
    private String pkDataElemt;//所属数据元主键

    public String getPkDataEleVal() {
        return pkDataEleVal;
    }

    public void setPkDataEleVal(String pkDataEleVal) {
        this.pkDataEleVal = pkDataEleVal == null ? null : pkDataEleVal.trim();
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    public String getCodeDeVal() {
        return codeDeVal;
    }

    public void setCodeDeVal(String codeDeVal) {
        this.codeDeVal = codeDeVal == null ? null : codeDeVal.trim();
    }

    public String getNameDeVal() {
        return nameDeVal;
    }

    public void setNameDeVal(String nameDeVal) {
        this.nameDeVal = nameDeVal == null ? null : nameDeVal.trim();
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getPkDataElemt() {
        return pkDataElemt;
    }

    public void setPkDataElemt(String pkDataElemt) {
        this.pkDataElemt = pkDataElemt == null ? null : pkDataElemt.trim();
    }
}