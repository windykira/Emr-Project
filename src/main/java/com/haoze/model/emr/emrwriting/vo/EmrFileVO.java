package com.haoze.model.emr.emrwriting.vo;

import com.haoze.common.model.PaginationResult;
import com.haoze.model.emr.emrwriting.entity.EmrFileEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 病历文件信息。
 * @author maxl
 * @time 2018-06-22。
 */
public class EmrFileVO implements Serializable {

    private EmrFileEntity emrFile = new EmrFileEntity();
    private String catalogName;//目录名称
    private String xmlContent;

    public String getXmlContent() {
        return xmlContent;
    }

    public void setXmlContent(String xmlContent) {
        this.xmlContent = xmlContent;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public EmrFileEntity getEmrFile() {
        return emrFile;
    }

    public void setEmrFile(EmrFileEntity emrFile) {
        this.emrFile = emrFile;
    }

}
