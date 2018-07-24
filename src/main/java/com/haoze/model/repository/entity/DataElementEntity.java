package com.haoze.model.repository.entity;

import com.haoze.common.model.BaseEntity;

import java.util.Date;

/**
 * 数据元基本实体信息。
 * @author maxl
 * @time 2018-07-17。
 */
public class DataElementEntity extends BaseEntity{

    private String pkDataElemt;//主键
    private String pkOrg;//所属机构
    private String codeDe;//数据元编码
    private String nameDe;//数据元名称
    private String pyCode;//拼音码
    private String wbCode;//五笔码
    private String definition;//数据元定义
    private String deValsType;//数据元值的数据类型
    private String repFmt;//数据元表示格式
    private String elementPdId;//数据元对应标准数据ID(PD)
    private String elementBdId;//数据元对应基础数据ID(BD)
    private String elementFdId;//数据元对应标识数据ID(FD)
    private String elementStdId;//数据元对应国家或行业标准标识码

    private int sortNo;//排序

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public String getPkDataElemt() {
        return pkDataElemt;
    }

    public void setPkDataElemt(String pkDataElemt) {
        this.pkDataElemt = pkDataElemt == null ? null : pkDataElemt.trim();
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    public String getCodeDe() {
        return codeDe;
    }

    public void setCodeDe(String codeDe) {
        this.codeDe = codeDe == null ? null : codeDe.trim();
    }

    public String getNameDe() {
        return nameDe;
    }

    public void setNameDe(String nameDe) {
        this.nameDe = nameDe == null ? null : nameDe.trim();
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

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition == null ? null : definition.trim();
    }

    public String getDeValsType() {
        return deValsType;
    }

    public void setDeValsType(String deValsType) {
        this.deValsType = deValsType == null ? null : deValsType.trim();
    }

    public String getRepFmt() {
        return repFmt;
    }

    public void setRepFmt(String repFmt) {
        this.repFmt = repFmt == null ? null : repFmt.trim();
    }

    public String getElementPdId() {
        return elementPdId;
    }

    public void setElementPdId(String elementPdId) {
        this.elementPdId = elementPdId == null ? null : elementPdId.trim();
    }

    public String getElementBdId() {
        return elementBdId;
    }

    public void setElementBdId(String elementBdId) {
        this.elementBdId = elementBdId == null ? null : elementBdId.trim();
    }

    public String getElementFdId() {
        return elementFdId;
    }

    public void setElementFdId(String elementFdId) {
        this.elementFdId = elementFdId == null ? null : elementFdId.trim();
    }

    public String getElementStdId() {
        return elementStdId;
    }

    public void setElementStdId(String elementStdId) {
        this.elementStdId = elementStdId == null ? null : elementStdId.trim();
    }
}