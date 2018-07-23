package com.haoze.service.repository.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.dao.repository.DataDictionaryDao;
import com.haoze.dao.repository.DataElementDao;
import com.haoze.dao.repository.DataElementValuesDao;
import com.haoze.model.repository.entity.DataDictionaryEntity;
import com.haoze.model.repository.entity.DataElementEntity;
import com.haoze.model.repository.entity.DataGroupEntity;
import com.haoze.model.repository.vo.DataDictionaryVO;
import com.haoze.service.repository.DataElementService;
import com.haoze.utils.CurrentUser;
import com.haoze.utils.FixedFieldInitializedUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;

/**
 * 数据元服务接口实现类。
 * @author maxl
 * @time 2018-07-18。
 */
@Service
public class DataElementServiceImpl implements DataElementService {

    @Autowired
    DataElementDao dataElementDao;
    @Autowired
    DataDictionaryDao dataDictionaryDao;
    @Autowired
    DataElementValuesDao dataElementValuesDao;

    @Override
    @Transactional
    public ResponseResult insert(DataDictionaryVO dataDictionaryVO) {

        try {
            DataElementEntity dataElementEntity = dataDictionaryVO.getDataElement();
            FixedFieldInitializedUtil.initialize(dataElementEntity);
            dataElementEntity.setPkDataElemt(dataElementEntity.getID());
            dataElementDao.insert(dataElementEntity);

            DataDictionaryEntity dataDictionaryEntity = dataDictionaryVO.getDataDictionary();
            FixedFieldInitializedUtil.initialize(dataDictionaryEntity);
            dataDictionaryEntity.setPkNode(dataDictionaryEntity.getID());
            dataDictionaryEntity.setPkBd(dataElementEntity.getPkDataElemt());
            //获取同一父节点下的子节点
            QueryParam queryParam = QueryParam.getDefaultQueryParam();
            queryParam.put("pkFather", dataDictionaryEntity.getPkFather());
            int count = dataDictionaryDao.count(queryParam);
            dataDictionaryEntity.setSortNo(count + 1);
            dataDictionaryDao.insert(dataDictionaryEntity);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "新增失败");
        }
    }

    @Override
    public DataElementEntity getByDataDictionaryId(String dataDictionaryId) {
        return dataElementDao.getByDataDictionaryId(dataDictionaryId);
    }

    @Override
    public ResponseResult insert(DataElementEntity dataElementEntity) {
        return null;
    }

    @Override
    @Transactional
    public ResponseResult delete(String dataElementId) {
        try {
            //判断是否有子节点
            QueryParam queryParam = QueryParam.getDefaultQueryParam();
            queryParam.put("pkFather",dataElementId);
            int count = dataDictionaryDao.count(queryParam);
            if(count > 0){
                return ResponseResult.failure(0, "具备子节点，无法删除。");
            }
            //删除关联关系
            dataDictionaryDao.deleteByDataId(dataElementId);
            //删除数据元值域
            dataElementValuesDao.deleteByDataElementId(dataElementId);
            //删除数据元
            dataElementDao.delete(dataElementId);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "删除失败");
        }
    }

    @Override
    @Transactional
    public ResponseResult update(DataElementEntity dataElementEntity) {

        try {
            dataElementEntity.setModifyTime(new Date());
            dataElementEntity.setModifier(CurrentUser.getUserId());
            dataElementDao.update(dataElementEntity);
            //更新节点信息
            DataDictionaryEntity dataDictionaryEntity = dataDictionaryDao.getByDataId(dataElementEntity.getPkDataElemt());
            dataDictionaryEntity.setNameNode(dataElementEntity.getNameDe());
            dataDictionaryDao.update(dataDictionaryEntity);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "更新失败");
        }
    }

    @Override
    public DataElementEntity get(String dataElementId) {
        return dataElementDao.get(dataElementId);
    }

    @Override
    public Page<DataElementEntity> list(QueryParam queryParam) {
        PageHelper.startPage(queryParam.getPage(),queryParam.getLimit());
        return dataElementDao.list(queryParam);
    }

    @Override
    public int count(QueryParam queryParam) {
        return dataElementDao.count(queryParam);
    }
}
