package com.haoze.service.repository.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.dao.repository.DataDictionaryDao;
import com.haoze.dao.repository.DataGroupDao;
import com.haoze.model.repository.entity.DataDictionaryEntity;
import com.haoze.model.repository.entity.DataGroupEntity;
import com.haoze.model.repository.vo.DataDictionaryVO;
import com.haoze.service.repository.DataGroupService;
import com.haoze.utils.CurrentUser;
import com.haoze.utils.FixedFieldInitializedUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 数据组服务接口实现类。
 *
 * @author maxl
 * @time 2018-07-16。
 */
@Service
public class DataGroupServiceImpl implements DataGroupService {

    @Autowired
    DataGroupDao dataGroupDao;
    @Autowired
    DataDictionaryDao dataDictionaryDao;

    @Override
    @Transactional
    public ResponseResult insert(DataGroupEntity dataGroupEntity) {

        try {
            FixedFieldInitializedUtil.initialize(dataGroupEntity);
            dataGroupDao.insert(dataGroupEntity);
            //新增节点关系
            return ResponseResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "新增失败");
        }
    }

    @Override
    @Transactional
    public ResponseResult delete(String dataGroupId) {
        try {
            //判断是否有子节点
            QueryParam queryParam = QueryParam.getDefaultQueryParam();
            queryParam.put("pkFather", dataGroupId);
            int count = dataDictionaryDao.count(queryParam);
            if (count > 0) {
                return ResponseResult.failure(0, "具备子节点，无法删除。");
            }
            //删除数据组
            dataGroupDao.delete(dataGroupId);
            //删除节点关系
            dataDictionaryDao.deleteByDataId(dataGroupId);
            return ResponseResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "删除失败");
        }
    }

    @Override
    @Transactional
    public ResponseResult update(DataGroupEntity dataGroupEntity) {

        try {
            dataGroupEntity.setModifyTime(new Date());
            dataGroupEntity.setModifier(CurrentUser.getUserId());
            dataGroupDao.update(dataGroupEntity);
            //更新节点信息
            DataDictionaryEntity dataDictionaryEntity = dataDictionaryDao.getByDataId(dataGroupEntity.getID());
            dataDictionaryEntity.setNameNode(dataGroupEntity.getNameDg());
            dataDictionaryEntity.setSortNo(dataGroupEntity.getSortNo());
            /*//获取同一父节点下的子节点
            QueryParam queryParam = QueryParam.getDefaultQueryParam();
            queryParam.put("pkFather", dataDictionaryEntity.getPkFather());
            int count = dataDictionaryDao.count(queryParam);
            int sortNo;
            if (dataGroupEntity.getSortNo() <= 1) {
                dataDictionaryEntity.setSortNo(1);
                sortNo = 1;
                dataDictionaryDao.updateSortNoForEnlarge(queryParam);
            } else if (dataGroupEntity.getSortNo() > count) {
                dataDictionaryEntity.setSortNo(count + 1);
                sortNo = count + 1;
            } else {
                dataDictionaryEntity.setSortNo(dataGroupEntity.getSortNo());
                sortNo = dataGroupEntity.getSortNo();
                queryParam.put("sortNo",dataGroupEntity.getSortNo());
                if (dataDictionaryEntity.getSortNo() > dataGroupEntity.getSortNo()) {
                    dataDictionaryDao.updateSortNoForEnlarge(queryParam);
                } else {
                    dataDictionaryDao.updateSortNoForReduce(queryParam);
                }
            }*/
            dataDictionaryDao.update(dataDictionaryEntity);
            return ResponseResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "更新失败");
        }
    }

    @Override
    public DataGroupEntity get(String dataGroupId) {
        return dataGroupDao.get(dataGroupId);
    }

    @Override
    public Page<DataGroupEntity> list(QueryParam queryParam) {
        PageHelper.startPage(queryParam.getPage(), queryParam.getLimit());
        return dataGroupDao.list(queryParam);
    }

    @Override
    public int count(QueryParam queryParam) {
        return dataGroupDao.count(queryParam);
    }

    @Override
    @Transactional
    public ResponseResult insert(DataDictionaryVO dataDictionaryVO) {

        try {
            //新增数据组信息
            DataGroupEntity dataGroupEntity = dataDictionaryVO.getDataGroup();
            FixedFieldInitializedUtil.initialize(dataGroupEntity);
            dataGroupDao.insert(dataGroupEntity);

            //新增节点关系
            DataDictionaryEntity dataDictionaryEntity = dataDictionaryVO.getDataDictionary();
            FixedFieldInitializedUtil.initialize(dataDictionaryEntity);
            dataDictionaryEntity.setPkNode(dataDictionaryEntity.getID());
            dataDictionaryEntity.setPkBd(dataGroupEntity.getID());
            //获取同一父节点下的子节点
            QueryParam queryParam = QueryParam.getDefaultQueryParam();
            queryParam.put("pkFather", dataDictionaryEntity.getPkFather());
            int count = dataDictionaryDao.count(queryParam);
            dataDictionaryEntity.setSortNo(count + 1);
            dataDictionaryDao.insert(dataDictionaryEntity);
            return ResponseResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "新增失败");
        }
    }

    @Override
    public DataGroupEntity getByDataDictionaryId(String dataDictionaryId) {
        return dataGroupDao.getByDataDictionaryId(dataDictionaryId);
    }

    @Override
    @Transactional
    public ResponseResult deleteByDataDictionaryId(String dataDictionaryId) {

        try {
            ResponseResult responseResult = ResponseResult.success();
            DataDictionaryEntity dataDictionaryEntity = dataDictionaryDao.get(dataDictionaryId);
            responseResult.put("sortNo",dataDictionaryEntity.getSortNo());
            responseResult.put("pkFather",dataDictionaryEntity.getPkFather());
            if (dataDictionaryEntity == null) {
                return ResponseResult.failure(0, "不存在的数据集。");
            }
            //判断是否有子节点
            QueryParam queryParam = QueryParam.getDefaultQueryParam();
            queryParam.put("pkFather", dataDictionaryEntity.getPkNode());
            int count = dataDictionaryDao.count(queryParam);
            if (count > 0) {
                return ResponseResult.failure(0, "具备子节点，无法删除。");
            }
            dataGroupDao.delete(dataDictionaryEntity.getPkBd());
            //删除节点关系
            dataDictionaryDao.delete(dataDictionaryId);
            return responseResult;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "删除失败");
        }
    }

    @Override
    @Transactional
    public ResponseResult updateSort(DataGroupEntity dataGroupEntity) {

        try {
            DataDictionaryEntity dataDictionaryEntity = dataDictionaryDao.getByDataId(dataGroupEntity.getID());
            //获取同一父节点下的子节点
            QueryParam queryParam = QueryParam.getDefaultQueryParam();
            queryParam.put("pkFather", dataDictionaryEntity.getPkFather());
            int count = dataDictionaryDao.count(queryParam);

            if (dataGroupEntity.getSortNo() < 1) {
                dataGroupEntity.setSortNo(1);
            }
            if (dataGroupEntity.getSortNo() > count) {
                dataGroupEntity.setSortNo(count);
            }
            queryParam.put("currentSortNo", dataDictionaryEntity.getSortNo());
            queryParam.put("targetSortNo", dataGroupEntity.getSortNo());
            if(dataGroupEntity.getSortNo() > dataDictionaryEntity.getSortNo()){
                dataDictionaryDao.updateSortNoForReduce(queryParam);
            }else if(dataGroupEntity.getSortNo() < dataDictionaryEntity.getSortNo()){
                dataDictionaryDao.updateSortNoForEnlarge(queryParam);
            }
            ResponseResult responseResult = ResponseResult.success();
            responseResult.put("sortNo", dataGroupEntity.getSortNo());
            return responseResult;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "更新排序号失败。");
        }
    }

    @Transactional
    public ResponseResult updateSortNoForEnlarge(QueryParam queryParam) {

        try {
            dataDictionaryDao.updateSortNoForEnlarge(queryParam);
            return ResponseResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "减小排序号失败。");
        }
    }

    @Override
    @Transactional
    public ResponseResult updateSortNoForReduce(QueryParam queryParam) {

        try {
            queryParam.put("currentSortNo",queryParam.get("sortNo"));
            dataDictionaryDao.updateSortNoForReduce(queryParam);
            return ResponseResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "减小排序号失败。");
        }
    }
}
