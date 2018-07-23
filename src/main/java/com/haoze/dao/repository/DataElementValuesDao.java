package com.haoze.dao.repository;

import com.haoze.common.model.BaseDao;
import com.haoze.common.model.QueryParam;
import com.haoze.model.repository.entity.DataElementValuesEntity;

public interface DataElementValuesDao extends BaseDao<DataElementValuesEntity,String>{

    void deleteByDataElementId(String dataElementId);

    /**
     * 批量删除数据元值域
     * @param ids
     */
    void batchDelete(String[] ids);

    /**
     * 根据编码、名称、父节点精确统计
     * @param queryParam
     * @return
     */
    int countExact(QueryParam queryParam);
}