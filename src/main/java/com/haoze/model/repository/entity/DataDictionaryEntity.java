package com.haoze.model.repository.entity;

import com.haoze.common.model.BaseEntity;

/**
 * 数据集基本实体信息。
 * @author maxl
 * @time 2018-07-17。
 */
public class DataDictionaryEntity extends BaseEntity{

    private String pkNode;//主键
    private String pkOrg;//机构
    private String pkRoot;//根节点
    private String pkFather;//父节点
    private String ordNode;//数据目录排序号
    private String nameNode;//数据目录名称
    private String remark;//备注
    private String icoNode;//数据节点图标
    private String nodeType;//数据节点类型：1-数据组，2-数据元，3-数据集
    private String pkBd;//基础数据主键，可为数据元主键、数据组主键

    private int sortNo;//排序

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public String getPkNode() {
        return pkNode;
    }

    public void setPkNode(String pkNode) {
        this.pkNode = pkNode == null ? null : pkNode.trim();
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    public String getPkRoot() {
        return pkRoot;
    }

    public void setPkRoot(String pkRoot) {
        this.pkRoot = pkRoot == null ? null : pkRoot.trim();
    }

    public String getPkFather() {
        return pkFather;
    }

    public void setPkFather(String pkFather) {
        this.pkFather = pkFather == null ? null : pkFather.trim();
    }

    public String getOrdNode() {
        return ordNode;
    }

    public void setOrdNode(String ordNode) {
        this.ordNode = ordNode == null ? null : ordNode.trim();
    }

    public String getNameNode() {
        return nameNode;
    }

    public void setNameNode(String nameNode) {
        this.nameNode = nameNode == null ? null : nameNode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIcoNode() {
        return icoNode;
    }

    public void setIcoNode(String icoNode) {
        this.icoNode = icoNode == null ? null : icoNode.trim();
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType == null ? null : nodeType.trim();
    }

    public String getPkBd() {
        return pkBd;
    }

    public void setPkBd(String pkBd) {
        this.pkBd = pkBd == null ? null : pkBd.trim();
    }
}