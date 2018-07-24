package com.haoze.service.repository;

import com.haoze.common.model.BaseService;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.model.repository.entity.DataElementEntity;
import com.haoze.model.repository.entity.DataGroupEntity;
import com.haoze.model.repository.vo.DataDictionaryVO;

/**
 * 数据元服务接口。
 * @author maxl
 * @time 2018-07-18。
 */
public interface DataElementService extends BaseService<DataElementEntity,String> {

    /**
     * 新增数据元
     * @param dataDictionaryVO
     * @return
     */
    ResponseResult insert(DataDictionaryVO dataDictionaryVO);

    /**
     * 根据数据集ID获取数据元信息
     * @param dataDictionaryId
     * @return
     */
    DataElementEntity getByDataDictionaryId(String dataDictionaryId);

    /**
     * 更新排序号
     * @param dataElementEntity
     */
    ResponseResult updateSort(DataElementEntity dataElementEntity);

    /**
     * 减小排序号
     * @param queryParam
     */
    ResponseResult updateSortNoForReduce(QueryParam queryParam);
}
