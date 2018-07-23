package com.haoze.dao.emr;

import com.haoze.common.model.BaseDao;
import com.haoze.model.emr.emrwriting.entity.EmrCataLogEntity;

public interface EmrCataLogDao extends BaseDao<EmrCataLogEntity,String>{

	EmrCataLogEntity getNameCatalog(String id);
}