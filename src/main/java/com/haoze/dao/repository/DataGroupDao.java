package com.haoze.dao.repository;

import com.haoze.common.model.BaseDao;
import com.haoze.model.repository.entity.DataGroupEntity;

/**
 * 数据组数据操作类。
 * @author maxl
 * @time 2018-07-16。
 */
public interface DataGroupDao extends BaseDao<DataGroupEntity,String>{

    DataGroupEntity getByDataDictionaryId(String dataDictionaryId);
}