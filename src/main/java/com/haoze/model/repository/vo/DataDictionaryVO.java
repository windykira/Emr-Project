package com.haoze.model.repository.vo;

import com.haoze.model.repository.entity.DataDictionaryEntity;
import com.haoze.model.repository.entity.DataElementEntity;
import com.haoze.model.repository.entity.DataGroupEntity;

/**
 * 数据字典基本实体信息。
 * @author maxl
 * @time 2018-07-17。
 */
public class DataDictionaryVO {

    private DataDictionaryEntity dataDictionary;
    private DataGroupEntity dataGroup;
    private DataElementEntity dataElement;

    public DataElementEntity getDataElement() {
        return dataElement;
    }

    public void setDataElement(DataElementEntity dataElement) {
        this.dataElement = dataElement;
    }

    public DataDictionaryEntity getDataDictionary() {
        return dataDictionary;
    }

    public void setDataDictionary(DataDictionaryEntity dataDictionary) {
        this.dataDictionary = dataDictionary;
    }

    public DataGroupEntity getDataGroup() {
        return dataGroup;
    }

    public void setDataGroup(DataGroupEntity dataGroup) {
        this.dataGroup = dataGroup;
    }

}
