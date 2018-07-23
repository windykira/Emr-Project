package com.haoze.dao.emr;

import com.haoze.common.model.BaseDao;
import com.haoze.common.model.QueryParam;
import com.haoze.model.emr.emrwriting.entity.EmrFileEntity;
import com.haoze.model.emr.emrwriting.po.EmrFilePO;

import java.util.List;

/**
 * 病历文件数据操作类。
 * @author maxl
 * @time 2018-06-21。
 */
public interface EmrFileDao extends BaseDao<EmrFileEntity,String>{

    /**
     * 查询病历文件列表
     * @param queryParam
     * @return
     */
    List<EmrFilePO> listEmrFiles(QueryParam queryParam);
}