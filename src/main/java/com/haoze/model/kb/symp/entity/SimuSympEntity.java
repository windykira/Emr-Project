package com.haoze.model.kb.symp.entity;

import com.haoze.common.model.BaseEntity;

/**
 * 症状实体类。
 * @author yangyb
 * @time 2018-05-11。
 */
public class SimuSympEntity extends BaseEntity {

    private String organizationID;//所属机构
    private String simuSympCode;//伴随症状编码
    private String simuSympName;//伴随症状名称
    private String pyCode;//拼音码
    private String wbCode;//五笔码
	public String getOrganizationID() {
		return organizationID;
	}
	public void setOrganizationID(String organizationID) {
		this.organizationID = organizationID;
	}
	public String getSimuSympCode() {
		return simuSympCode;
	}
	public void setSimuSympCode(String simuSympCode) {
		this.simuSympCode = simuSympCode;
	}
	public String getSimuSympName() {
		return simuSympName;
	}
	public void setSimuSympName(String simuSympName) {
		this.simuSympName = simuSympName;
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
    
    
    
}
