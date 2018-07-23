package com.haoze.model.system.menu.entity;

import com.haoze.common.model.BaseEntity;

import java.math.BigDecimal;

/**
 * 菜单基本信息。
 * @author maxl
 * @time 2018-05-07。
 */
public class EmrMenuEntity extends BaseEntity{

    private String menuOrganization;//所属机构
    private String menuCode;//菜单编码
    private String menuName;//菜单名称
    private String parentMenu;//父菜单
    private String menuLevel;//菜单等级
    private String status;//状态：1-启用，2-禁用
    private String params;//参数
    private String description;//描述
    private String menuIcon;//菜单图标
    private String order;//排序
    private String menuPermission;//菜单权限标识（多个逗号隔开如：user:list,user:create）
    private String pyCode;//拼音码
    private String wbCode;//五笔码
    private BigDecimal dataVersion;//数据版本
    private String menuUrl;//菜单链接地址
    private String menuType;//菜单类型：1-目录，2-菜单，3-按钮

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuOrganization() {
        return menuOrganization;
    }

    public void setMenuOrganization(String menuOrganization) {
        this.menuOrganization = menuOrganization;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(String parentMenu) {
        this.parentMenu = parentMenu;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getMenuPermission() {
        return menuPermission;
    }

    public void setMenuPermission(String menuPermission) {
        this.menuPermission = menuPermission;
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

    public BigDecimal getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(BigDecimal dataVersion) {
        this.dataVersion = dataVersion;
    }
}
