package com.haoze.service.repository;

import com.haoze.common.model.BaseService;
import com.haoze.common.model.ResponseResult;
import com.haoze.model.repository.entity.DataGroupEntity;
import com.haoze.model.repository.vo.DataDictionaryVO;

/**
 * 数据组服务接口。
 * @author maxl
 * @time 2018-07-16。
 */
public interface DataGroupService extends BaseService<DataGroupEntity,String>{

    /**
     * 新增数据组
     * @param dataDictionaryVO
     * @return
     */
    ResponseResult insert(DataDictionaryVO dataDictionaryVO);

    /**
     * 根据数据集ID获取数据组信息
     * @param dataDictionaryId
     * @return
     */
    DataGroupEntity getByDataDictionaryId(String dataDictionaryId);

    /**
     * 根据数据集ID删除数据组
     * @param dataDictionaryId
     * @return
     */
    ResponseResult deleteByDataDictionaryId(String dataDictionaryId);
}
