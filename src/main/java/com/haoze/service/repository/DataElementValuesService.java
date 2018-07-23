package com.haoze.service.repository;

import com.haoze.common.model.BaseService;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.model.repository.entity.DataElementValuesEntity;

/**
 * 数据元值域服务接口。
 * @author maxl
 * @time 2018-07-18。
 */
public interface DataElementValuesService extends BaseService<DataElementValuesEntity,String>{

    /**
     * 删除数据元值域
     * @param ids
     */
    ResponseResult batchDelete(String[] ids);

    /**
     * 根据编码、名称、父节点精确统计
     * @param queryParam
     * @return
     */
    int countExact(QueryParam queryParam);
}
