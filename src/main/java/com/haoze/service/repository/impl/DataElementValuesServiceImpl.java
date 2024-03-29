package com.haoze.service.repository.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoze.common.enumeration.common.DelFlagEnum;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.dao.repository.DataElementValuesDao;
import com.haoze.model.repository.entity.DataElementValuesEntity;
import com.haoze.service.repository.DataElementValuesService;
import com.haoze.utils.FixedFieldInitializedUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * 数据元值域服务接口实现类。
 * @author maxl
 * @time 2018-07-18。
 */
@Service
public class DataElementValuesServiceImpl implements DataElementValuesService {

    @Autowired
    DataElementValuesDao dataElementValuesDao;

    @Override
    @Transactional
    public ResponseResult insert(DataElementValuesEntity dataElementValuesEntity) {

        try {
            FixedFieldInitializedUtil.initialize(dataElementValuesEntity);
            dataElementValuesEntity.setPkDataEleVal(dataElementValuesEntity.getID());
            dataElementValuesDao.insert(dataElementValuesEntity);
            return ResponseResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "新增失败");
        }
    }

    @Override
    @Transactional
    public ResponseResult delete(String dataElementValueId) {

        try {
            dataElementValuesDao.delete(dataElementValueId);
            return ResponseResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "删除失败");
        }
    }

    @Override
    @Transactional
    public ResponseResult update(DataElementValuesEntity dataElementValuesEntity) {
        try {
            dataElementValuesDao.update(dataElementValuesEntity);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "更新失败");
        }
    }

    @Override
    public DataElementValuesEntity get(String dataElementValueId) {
        return dataElementValuesDao.get(dataElementValueId);
    }

    @Override
    public Page<DataElementValuesEntity> list(QueryParam queryParam) {
        PageHelper.startPage(queryParam.getPage(), queryParam.getLimit());
        queryParam.put("delFlag", DelFlagEnum.Not_Deleted.getEnumValue());
        return dataElementValuesDao.list(queryParam);
    }

    @Override
    public int count(QueryParam queryParam) {
        return dataElementValuesDao.count(queryParam);
    }

    @Override
    @Transactional
    public ResponseResult batchDelete(String[] ids) {

        try {
            dataElementValuesDao.batchDelete(ids);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "删除失败");
        }
    }

    @Override
    public int countExact(QueryParam queryParam) {
        return dataElementValuesDao.countExact(queryParam);
    }
}
