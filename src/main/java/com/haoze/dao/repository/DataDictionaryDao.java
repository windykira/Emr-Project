package com.haoze.dao.repository;

import com.haoze.common.model.BaseDao;
import com.haoze.common.model.QueryParam;
import com.haoze.model.repository.entity.DataDictionaryEntity;

/**
 * 数据集合数据操作类。
 * @author maxl
 * @time 2018-07-16。
 */
public interface DataDictionaryDao extends BaseDao<DataDictionaryEntity,String>{

    void deleteByDataId(String dataId);

    /**
     * 根据数据组、数据元、数据集ID获取节点信息
     * @param dataId
     * @return
     */
    DataDictionaryEntity getByDataId(String dataId);

}